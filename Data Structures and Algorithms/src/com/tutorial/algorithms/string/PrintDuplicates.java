package com.tutorial.algorithms.string;

import java.util.HashMap;
import java.util.Map;

public class PrintDuplicates {

	public static void main(String[] args) {
		
		printDuplicates("stringjavadeveloper");
	}
	
	
	//Find and print duplicate characters in String - 1st way
	public static void printDuplicates(String str) {
		
		char[] chars = str.toCharArray();
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(char c : chars) {
			if(map.containsKey(c)) {
				int counter = map.get(c);
				map.put(c, ++counter);
			}
			
			else {
				map.put(c, 1);
			}
		}
		
		//print duplicate characters
		for(char c : map.keySet()) {
			if(map.get(c) > 1) {
				System.out.println(c);
			}
		}
		
//		//Print duplicate characters excluding white space
//		for(char c : map.keySet()) {
//			if(map.get(c) > 1 && !Character.isWhitespace(c)) {
//				System.out.println(c);
//			}
//		}
//		
//		   //Print distinct characters
//	    for(char c : map.keySet()) {
//	      if(map.get(c) == 1) {
//	        System.out.println(c);
//	      }
//	    }
	}
	

}
