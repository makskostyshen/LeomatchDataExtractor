package org.acme.demo.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileController {
  private final FileService fileStorageService;

  @Autowired
  public FileController(FileService fileStorageService) {
    this.fileStorageService = fileStorageService;
  }

  @PostMapping("/uploadFile")
  public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
    String fileName = fileStorageService.storeFile(file);

    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/downloadFile/")
        .path(fileName)
        .toUriString();

    return new UploadFileResponse(fileName, fileDownloadUri,
        file.getContentType(), file.getSize());
  }
}
