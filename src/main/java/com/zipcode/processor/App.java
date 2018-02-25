package com.zipcode.processor;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Scanner scan;
    
	public static void main( String[] args )
    {
        scan = new Scanner(System.in);
        String zipcodeRanges = scan.nextLine();
        ZipcodeProcessor zipcodeProcessor = new ZipcodeProcessor(zipcodeRanges);
        List<Zipcode> zipcodeList = zipcodeProcessor.stripZipcode();
        ZipcodeMerger zipcode_merger = new ZipcodeMerger(zipcodeList);
        List<Zipcode> mergedZipcodeList = zipcode_merger.mergeZipcodes();
        for(Zipcode zipcode: mergedZipcodeList) {
        	System.out.println("["+zipcode.getLower_bound()+","+zipcode.getUpper_bound() +"]");
        }
        
        
    }
}
