package com.tutorial.algorithms.string;

import java.util.Stack;

public class StringReverse {
	
	
	public static void main(String[] args) {
		
		assert reverse("java").equals("avaj");
		assert reverse1("java").equals("avaj");
		assert reverse2("java").equals("avaj");
		
		
	}

	
	//First and the easiest way
	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
	
	
	
	//Second way with using stack
	public static String reverse1(String str) {
		Stack<Character>stack = new Stack<Character>();
		char[]chars = str.toCharArray();
		
		for(char c : chars) {
			stack.push(c);
		}
		
		for(int i = 0; i<str.length(); i++) {
			chars[i] = stack.pop();
		}
		
		return new String(chars);
				
	}
	
	//Third way without stack
	public static String reverse2(String str) {
		
		if(str == null || str.isEmpty()) {
			return str;
		}
		
		char[] value = str.toCharArray();
		for(int i = 0, j = str.length()-1; i < j; i++, j--) {
			char temp = value[i];
			value[i] = value[j];
			value[j] = temp;			
		}
		
		return new String(value);
	}
	
	
	//Fourth way using recursion
	 public static String reverse3(String str) {

	        //base case to handle one char string and empty string
	        if (str.length() < 2) {
	            return str;
	        }

	        return reverse3(str.substring(1)) + str.charAt(0);

	    }

	
	

}
