package com.tutorial.algorithms.stack;

import java.util.Stack;

public class BalancedBrackets {
	
	public static void main(String[] args) {
		
		assert isValid("{()}");
		assert !isValid("{(}");
		
		assert isBalanced("{()}");
		assert !isBalanced("{(}");
		
	}

	//First way. As a matter of fact both ways used the same logic but by different means.
	public static boolean isValid(String str) {
		Stack<Character> stack = new Stack<Character>();

		for (char c : str.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {

				stack.push(c);
			}

			else {
				if (stack.isEmpty()) {
					return false;
				}

				else {
					char top = stack.peek();
					if (c == ')' && top == '(' || c == '}' && top == '{' || c == ']' && top == '[') {

						stack.pop();
					} else {
						return false;
					}
				}
			}
		}
		return stack.isEmpty();
	}
	
	
	
	//Second way consists of two parts: isPaired() and isBalanced()
	public static boolean isPaired(char leftBracker, char rightBracket) {
		char[][] pairedBrackets = {{'(', ')'}, {'{', '}'}, {'[', ']'}};
		
		for(char[] pairedBracket : pairedBrackets) {
			if(pairedBracket[0] == leftBracker && pairedBracket[1] == rightBracket) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isBalanced(String str) {
		if(str == null) {
			throw new IllegalArgumentException("String is null!");
		}
		
		Stack<Character> stack = new Stack<Character>();
		for(char bracket : str.toCharArray()) {
			switch (bracket) {
			case '(':
			case '{':
			case '[':
				stack.push(bracket);
				break;
			case ')':
			case '}':
			case ']':
				if (stack.isEmpty() || !isPaired(stack.pop(), bracket)) {
					return false;
				}
				break;
				
			default:
				return false;
			}
		}
		return stack.isEmpty();
	}

}
