package org.acme.demo.statistics;

public class StatisticsData {

  private Long numberOfMessages;
  private Long numberOfInteractions;

  private StatisticsData(){
    this.numberOfInteractions=1L;
    this.numberOfMessages=1L;
  }
  public static StatisticsData getEmptyStatisticsData(){
    return new StatisticsData();
  }

}
