package com.tutorial.algorithms.string;

public class CharacterSame {
	
	public static boolean isCharacterSame(String str) {
		
		for(int i =1, length = str.length(); i < length; ++i) {
			if(str.charAt(i) != str.charAt(0)) {
				return false;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) {
		System.out.println(isCharacterSame("java"));
	}

}
