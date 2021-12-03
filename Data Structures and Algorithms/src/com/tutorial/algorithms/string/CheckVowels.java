package com.tutorial.algorithms.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckVowels {
	
	public static void main(String[] args) {
		
		assert checkVowels("java");
		assert !checkVowels("jdk");
	}
	
	//Check if a String has vowels or not
	public static boolean checkVowels(String str) {
		Pattern pattern = Pattern.compile("[AEIOUaeiou]");
		Matcher matcher = pattern.matcher(str);
		if(matcher.find()) {
			countVowels(str);
			return true;
		}
		
		return false;
	}
	
	
	//Find the number of vowels
	public static void countVowels(String str) {
		str = str.toLowerCase();
		int count = 0;
		int i = 0;
		
		while(i < str.length()) {
			if(str.charAt(i)=='a'
			   ||str.charAt(i)=='e'
			   ||str.charAt(i)=='i'
			   ||str.charAt(i)=='o'
			   ||str.charAt(i)=='u') {
				count++;
			}
			i++;
		}
		System.out.println(count);
	}
	

}
