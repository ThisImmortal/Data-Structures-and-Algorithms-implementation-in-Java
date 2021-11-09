package com.tutorial.algorithms.string;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagrams {

	
	public static boolean isAnagrams(String str1, String str2) {
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
	
	public static void main(String[] args) {
		System.out.println(isAnagrams("listen", "silent"));

	}

}
