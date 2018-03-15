package com.zipcode.processor;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import com.zipcode.processor.factorybot.ZipcodeDataSet;
import junit.framework.TestCase;

public class ZipcodeMergerTest extends TestCase {

  @Test
  public void testMergeZipcodes() {
    ZipcodeDataSet dataSet = new ZipcodeDataSet();
    String zipcodeRanges = dataSet.generateRandomZipcodeData(100);
    ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(zipcodeRanges);
    List<Zipcode> zipcodeList = zipcodeProcessor.stripZipcode();
    ZipcodeMerger zipcode_merger = new ZipcodeMerger();
    List<Zipcode> sortedZipCodeList = zipcode_merger.sortByLowerBounds(zipcodeList);
    List<Zipcode> mergedZipcodeList = zipcode_merger.mergeZipcodes(sortedZipCodeList);
    assertTrue(mergedZipcodeList.size() > 0);
  }

  public void testOverlappingRangeToReturnOneRange() {
    Zipcode zipcode1 = new Zipcode(95000, 95005);
    Zipcode zipcode2 = new Zipcode(95002, 95006);
    List<Zipcode> zipcodeList = new LinkedList<Zipcode>();
    zipcodeList.add(zipcode1);
    zipcodeList.add(zipcode2);
    ZipcodeMerger zipcode_merger = new ZipcodeMerger();
    List<Zipcode> sortedZipCodeList = zipcode_merger.sortByLowerBounds(zipcodeList);
    List<Zipcode> mergedZipcodeList = zipcode_merger.mergeZipcodes(sortedZipCodeList);
    assertTrue(mergedZipcodeList.get(0).getUpper_bound() == 95006);
  }

  public void testSortingBeforeMerging() {
    Zipcode zipcode1 = new Zipcode(95000, 95005);
    Zipcode zipcode2 = new Zipcode(95002, 95006);
    List<Zipcode> zipcodeList = new LinkedList<Zipcode>();
    zipcodeList.add(zipcode2);
    zipcodeList.add(zipcode1);
    ZipcodeMerger zipcode_merger = new ZipcodeMerger();
    List<Zipcode> sortedZipCodeList = zipcode_merger.sortByLowerBounds(zipcodeList);
    assertTrue(sortedZipCodeList.get(0) == zipcode1);
  }

  public void testLoadAfterCallingMerge() {
    Zipcode zipcode1 = new Zipcode(95000, 95005);
    Zipcode zipcode2 = new Zipcode(95007, 95008);
    List<Zipcode> zipcodeList = new LinkedList<Zipcode>();
    zipcodeList.add(zipcode1);
    zipcodeList.add(zipcode2);
    ZipcodeMerger zipcode_merger = new ZipcodeMerger();
    List<Zipcode> sortedZipCodeList = zipcode_merger.sortByLowerBounds(zipcodeList);
    List<Zipcode> mergedZipcodeList = zipcode_merger.mergeZipcodes(sortedZipCodeList);
    assertEquals(mergedZipcodeList, zipcodeList);
  }

}
