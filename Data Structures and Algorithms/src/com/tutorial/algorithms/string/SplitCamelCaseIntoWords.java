package com.tutorial.algorithms.string;

public class SplitCamelCaseIntoWords {
	
	
	
	public static void main(String[] args) {
		SplitCamelCaseIntoWords.SplitCamelCase("IAmTheBestProgrammer");
	}

	public static void SplitCamelCase(String camelCase) {
		String response = "";
		for(int i=0; i<camelCase.length(); i++) {
			Character ch = camelCase.charAt(i);
			
			if(Character.toUpperCase(ch)==ch) {
				response += " ";
				
			}
			response += ch;
			
		}
		System.out.println(response);
	}
}
