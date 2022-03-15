package com.tutorial.algorithms.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckAnagrams {
	
	public static void main(String[] args) {
		
		assert isAnagram1("listen", "silent");
		assert !isAnagram1("listen", "silence");
		
		assert isAnagram2("listen", "silent");
		assert !isAnagram2("listen", "silence");
		
		
	}
	
	
	//Check if two strings are anagrams - first way
	public static boolean isAnagram1(String str1, String str2){       
	       
		if(str1.length() != str2.length()){
	            return false;
	        }
	       
	        char[] chars = str1.toCharArray();
	       
	        for(char c : chars){
	            int index = str2.indexOf(c);
	            if(index != -1){
	                str2 = str2.substring(0,index) 
	                       + str2.substring(index +1, str2.length());
	            }else{
	                return false;
	            }           
	        }
	       
	        return str2.isEmpty();
	    }


	
	//Check if two strings are anagrams - second way (Using HashMap)
	public static boolean isAnagram2(String str1, String str2) {
		
		int l1 = str1.length();
		int l2 = str2.length();
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		Map<Character, Integer> charAppearences = new HashMap<Character, Integer>();
		
		for(int i = 0; i < l1; i++) {
			char c = str1.charAt(i);
			int numberOfAppearance = charAppearences.getOrDefault(c, 0);
			charAppearences.put(c, numberOfAppearance+1);
		}
		
		for(int i = 0; i < l2; i++) {
			char c = str2.charAt(i);
			if(!charAppearences.containsKey(c)) {
				return false;
			}
			charAppearences.put(c, charAppearences.get(c)-1);
		}
		
		for(int cnt : charAppearences.values()) {
			if(cnt != 0) {
				return false;
			}
		}
		return true;
	}
	
	
	
	//Check if two strings are anagrams - third way. This method
	public static boolean isAnagram3(String str1, String str2) {
		
		char[] charFromStr1 = str1.toCharArray();
		char[] charFromStr2 = str2.toCharArray();
		
		Arrays.sort(charFromStr1);
		Arrays.sort(charFromStr2);
		
		return charFromStr1.equals(charFromStr2);
	}
	

}
