package com.zipcode.processor;

import java.util.List;
import com.zipcode.processor.factorybot.ZipcodeDataSet;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
  public AppTest(String testName) {
    super(testName);
  }

  public static Test suite() {
    TestSuite suite = new TestSuite(AppTest.class);
    return suite;
  }

  public void testLoadedList() {
    ZipcodeDataSet dataSet = new ZipcodeDataSet();
    String inputDataSet = dataSet.generateRandomZipcodeData(100);
    ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(inputDataSet);
    List<Zipcode> zipcodeList = zipcodeProcessor.stripZipcode();
    assertTrue(zipcodeList.size() > 0);
  }

  public void testfinalResultToMatch() {
    ZipcodeDataSet dataSet = new ZipcodeDataSet();
    String inputDataSet = dataSet.generateOverlappingZipcodeData(5);
    ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(inputDataSet);
    List<Zipcode> zipcodeList = zipcodeProcessor.stripZipcode();
    ZipcodeMerger zipcode_merger = new ZipcodeMerger();
    List<Zipcode> sortedZipCodeList = zipcode_merger.sortByLowerBounds(zipcodeList);
    List<Zipcode> mergedZipcodeList = zipcode_merger.mergeZipcodes(sortedZipCodeList);
    assertTrue(mergedZipcodeList.size() == 1);
  }

  public void testIllegalArgumentException() {
    try {
      String inputDataSet = "[92004,92002] [92003,92004]";
      ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(inputDataSet);
      List<Zipcode> zipcodeList = zipcodeProcessor.stripZipcode();
    } catch (IllegalArgumentException e) {
      assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
    }
  }

  public void testExceptionWhenMoreRanges() {
    try {
      String inputDataSet = "[92004,92002,92003] [92003,92004]";
      ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(inputDataSet);
      List<Zipcode> zipcodeList = zipcodeProcessor.stripZipcode();
    } catch (IllegalArgumentException e) {
      assertEquals("IllegalArgumentException", e.getClass().getSimpleName());
    }
  }

  public void testExceptionMessageWhenLowerBoundGreater() {
    try {
      String inputDataSet = "[92004,92002] [92003,92004]";
      ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(inputDataSet);
      List<Zipcode> zipcodeList = zipcodeProcessor.stripZipcode();
    } catch (IllegalArgumentException e) {
      String expectedMessage = "92004 92002:  Zipcode lower bound should be less" + " than upper bound";
      assertEquals(expectedMessage, e.getMessage());
    }
  }

  public void testExceptionMessageWhenMoreRangeGiven() {
    try {
      String inputDataSet = "[92004,92002,92003] [92003,92004]";
      ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(inputDataSet);
      List<Zipcode> zipcodeList = zipcodeProcessor.stripZipcode();
    } catch (IllegalArgumentException e) {
      String expectedMessage = "92004Zipcode should have lower " + "and upper bounds";
      assertEquals(expectedMessage, e.getMessage());
    }
  }

}
