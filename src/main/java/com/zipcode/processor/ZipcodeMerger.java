package com.zipcode.processor;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class ZipcodeMerger {
	List<Zipcode> zipcodeRangeList;
	List<Zipcode> mergedZipcodeList = new LinkedList<Zipcode>();
 	public ZipcodeMerger(List<Zipcode> zipcodeRangeList) {
		this.zipcodeRangeList = zipcodeRangeList;
		Collections.sort(zipcodeRangeList, new ZipcodeComparator());
	}
 	
 	public List<Zipcode> mergeZipcodes(){
 		Zipcode zipcode = null;
		for(Zipcode zipcodeInterval: zipcodeRangeList) {
			if(zipcode == null)
				zipcode = zipcodeInterval;
			else {
				if(zipcode.getUpper_bound() >= zipcodeInterval.getLower_bound()) {
					zipcode.setUpper_bound(Math.max(zipcode.getUpper_bound(), 
									   		zipcodeInterval.getUpper_bound()));
				}else {
					mergedZipcodeList.add(zipcode);
					zipcode = zipcodeInterval;
				}
			}
		}
		mergedZipcodeList.add(zipcode);
		return mergedZipcodeList;
 	}
	
}
