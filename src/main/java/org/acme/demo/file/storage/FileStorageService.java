package org.acme.demo.file.storage;

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
  private final String folderPathString;
  private final String jsonFileName;

  @Autowired
  public FileStorageService(Environment environment) {
    this.folderPathString = environment.getProperty("file.upload-dir");
    this.jsonFileName = environment.getProperty("file.json-name");
  }

  private Path obtainFolderPath(String userName){
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

  public Path storeFile(MultipartFile file, String userName) {
    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    Path folderPath = obtainFolderPath(userName);

    try {
      Path targetLocation = folderPath.resolve(fileName);
      Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

    } catch (IOException ex) {
      throw new FileStorageException("Could not store file");
    }
    return Paths
        .get(folderPath.toString() + "\\" + jsonFileName)
        .toAbsolutePath()
        .normalize();
  }
}
