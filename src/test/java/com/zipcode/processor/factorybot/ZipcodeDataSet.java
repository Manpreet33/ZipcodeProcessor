package com.zipcode.processor.factorybot;

import org.fluttercode.datafactory.impl.DataFactory;

public class ZipcodeDataSet {
  public String generateRandomZipcodeData(int noOfDataSets) {
    DataFactory dataFactory = new DataFactory();
    String dataSet = "";
    for (int i = 0; i < noOfDataSets; i++) {
      int lower_bound = dataFactory.getNumberBetween(10000, 99999);
      int upper_bound = dataFactory.getNumberBetween(lower_bound, 99999);
      dataSet += "[" + lower_bound + "," + upper_bound + "] ";
    }
    return dataSet;
  }

  public String generateOverlappingZipcodeData(int noOfDataSets) {
    DataFactory dataFactory = new DataFactory();
    String dataSet = "";
    for (int i = 0; i < noOfDataSets; i++) {
      int lower_bound = dataFactory.getNumberBetween(10000, 99999);
      int upper_bound = dataFactory.getNumberBetween(lower_bound, 99999);
      dataSet += "[" + (lower_bound - 4) + "," + upper_bound + "] ";
    }
    return dataSet;
  }
}
