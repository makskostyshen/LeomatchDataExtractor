package org.acme.demo.file;

import org.acme.demo.file.parse.FileParseService;
import org.acme.demo.file.storage.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileController {

  private final FileStorageService fileStorageService;
  private final FileParseService fileParseService;

  @Autowired
  public FileController(FileStorageService fileStorageService, FileParseService fileParseService) {
    this.fileStorageService = fileStorageService;
    this.fileParseService = fileParseService;
  }

  @PostMapping("/file")
  public UploadFileResponseDto uploadFile(
      @RequestParam("file") MultipartFile file,
      @RequestParam("user_name") String userName){

    String fileName = fileStorageService.storeFile(file, userName);
    String response = fileParseService.parse(fileName);

    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/downloadFile/")
        .path(fileName)
        .toUriString();

    return new UploadFileResponseDto(fileName, fileDownloadUri,
        file.getContentType(), file.getSize());
  }
}
