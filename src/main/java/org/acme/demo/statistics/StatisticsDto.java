package org.acme.demo.statistics;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatisticsDto {
  private String fileName;
  private String fileDownloadUri;
  private String contentType;
  private long size;
  public StatisticsDto(StatisticsData statisticsData, String fileName,
      String fileDownloadUri, String contentType, long size) {

    this.fileName = fileName;
    this.fileDownloadUri = fileDownloadUri;
    this.contentType = contentType;
    this.size = size;
  }
}
