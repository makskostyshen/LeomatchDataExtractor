package org.acme.demo.file.storage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.acme.demo.file.storage.FileStorageException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {
  private final String folderPathString;

  @Autowired
  public FileStorageService(Environment environment) {
    this.folderPathString = environment.getProperty("file.upload-dir");
  }

  private Path obtainFilePath(String userName){
    String filePathString = folderPathString + "\\" + userName;
    Path filePath = Paths
        .get(filePathString)
        .toAbsolutePath()
        .normalize();

    try {
      Files.createDirectories(filePath);
    } catch (Exception ex) {
      throw new FileStorageException(
          "Could not create the directory where the uploaded files will be stored.");
    }
    return filePath;
  }

  public String storeFile(MultipartFile file, String userName) {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    Path filePath = obtainFilePath(userName);

    try {
      Path targetLocation = filePath.resolve(fileName);
      Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

    } catch (IOException ex) {
      throw new FileStorageException("Could not store file");
    }
    return fileName;
  }
}
