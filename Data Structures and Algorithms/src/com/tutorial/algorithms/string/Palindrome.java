package com.tutorial.algorithms.string;

public class Palindrome {
	
	//Is String palindrome
	public static boolean isPalindrome(String str) {
		char[]chars = str.toCharArray();
		
		int start = 0;
		int end = chars.length-1;
		
		while(start < end) {
			if(chars[start] != chars[end]) {
				return false;
			}
			
			start++;
			end--;
		}
		
		return true;
	}
	
	//Is String palindrome - another way
	public static boolean isPalindromeAnotherWay(String str) {
		return (str == null || str.length() <= 1 || str.equals(new StringBuilder(str).reverse().toString()));
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome("ana"));
	}

}
