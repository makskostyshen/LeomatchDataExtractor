package org.acme.demo.file;

import java.nio.file.Path;
import org.acme.demo.file.parse.FileParseService;
import org.acme.demo.file.storage.FileStorageService;
import org.acme.demo.statistics.StatisticsData;
import org.acme.demo.statistics.StatisticsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
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
  public StatisticsDto getStatistics(
      @RequestParam("file") MultipartFile file,
      @RequestParam("user_name") String userName){

    Path filePath = fileStorageService.storeFile(file, userName);
    String fileName = StringUtils.cleanPath(filePath.toString());

    StatisticsData statisticsData = fileParseService.parse(filePath);

    String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
        .path("/downloadFile/")
        .path(fileName)
        .toUriString();

    return new StatisticsDto(statisticsData, fileName, fileDownloadUri,
        file.getContentType(), file.getSize());
  }
}
