package org.acme.demo.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
  private final Path fileStorageLocation;

  @Autowired
  public FileStorageService(Environment environment) {
    this.fileStorageLocation = Paths
        .get(environment.getProperty("file.upload-dir"))
        .toAbsolutePath()
        .normalize();

    try {
      Files.createDirectories(this.fileStorageLocation);
    } catch (Exception ex) {
      throw new FileStorageException(
          "Could not create the directory where the uploaded files will be stored.");
    }
  }

  public String storeFile(MultipartFile file) {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());

    try {
      if(fileName.contains("..")) {
        throw new FileStorageException("Filename contains invalid path sequence");
      }

      Path targetLocation = this.fileStorageLocation.resolve(fileName);
      Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

      return fileName;

    } catch (IOException ex) {
      throw new FileStorageException("Could not store file");
    }
  }
}
