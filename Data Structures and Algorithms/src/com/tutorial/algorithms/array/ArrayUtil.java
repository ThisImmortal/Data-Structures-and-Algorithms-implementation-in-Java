package com.tutorial.algorithms.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.stream.IntStream;

public class ArrayUtil {
	
	
	//Print an array using traditional for loop
	public static void printArray(int[]arr) {
		int n = arr.length;
		
		for(int i = 0; i<n; i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	//Reverse an array - The first way
	public static void reverseArrayA(int[]arr, int start, int end) {
		while(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
			
		}
	}
	
	//Reverse an array - The second way
	public static void reverseArrayB(Object[]arr) {
		for(int i = 0; i<arr.length/2; i++) {
			Object temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
	}
	
	//Find minimum of an array
	public static int findMinimum(int[]arr) {
		if(arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		
		int min = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
			}
		}
		return min;
	}
	
	//Move Zeros to the end of an array
	public static void moveZeros(int[]arr, int n) {
		int j = 0;
		for(int i = 0; i < n; i++) {
			if(arr[i] != 0 && arr[j] == 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
			
			if(arr[j] != 0) {
				j++;
			}
		}
				
	}
		
	//Resize an array
	public static int[] resize(int[]arr, int size) {
		int [] temp = new int[size];
		
		for(int i = 0; i < arr.length; i++) {
			temp[i] = arr[i];
		}
		
		return temp;
	}
	
	
	//Find second maximum value in an array
	public static int findSecondMax(int[]arr) {
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				secondMax = max;
				max = arr[i];
			}
			else if (arr[i] > secondMax && arr[i] != max) {
				secondMax = arr[i];
			}
		}
		
		return secondMax;
	}
	
	//Find missing number in an array of n-1 distinct numbers. Mathemathical approach: the sum of first n natural
	// numbers 1+2+3+4+...n = nx(n+1)/2
	public static int findMissingNumber(int[]arr) {
		int n = arr.length + 1;
		
		int sum = n * (n + 1)/2;
		for(int num : arr) {
			sum = sum - num;
		}
		
		return sum;
	}
	
	//Check if duplicate numbers in an array - The first way
	public static boolean findDuplicate(int[]arr) {
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[i] == arr[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	//Check if duplicate numbers in an array - The second way
	//Set data structere does not allow duplicates
	public static boolean findDuplicate2(int[]arr) {
		Set<Integer> numbers = new HashSet<Integer>();
		
		for(int number : arr) {
			if(numbers.add(number) == false) {
				return true;
			}			
		}
		return false;
	}
	
	//Remove even integers from an array
	public static int[] removeEven(int[]arr) {
		int oddCount = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 != 0) {
				oddCount++;
			}
		}
		
		int[]oddArray = new int[oddCount];
		int idx = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 != 0) {
				oddArray[idx++] = arr[i];
			}
		}
		return oddArray;
		
	}
	
	//Next greater elements of an array
	public static int[] nextGreaterElement(int[]arr) {
		int[] result = new int[arr.length];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = arr.length-1; i >= 0; i--) {
			if(!stack.isEmpty()) {
				while(!stack.isEmpty() && stack.peek() <= arr[i]) {
					stack.pop();
				}
			}
			
			if(stack.isEmpty()) {
				result[i] = -1;
			}
			else {
				result[i] = stack.peek();
			}
			
			stack.push(arr[i]);
		}
		return result;
	}
	
	
	public void getSumCombinations(int[]arr, int sum) {
		
	}
	
	
	public static void main(String[] args) {
		int[]arr = {0,11,34,0,78,92,36,21,0,36,120,28,113,100};
//		String[]fruits = {"apple", "orange", "granate"};
//		System.out.println(Arrays.asList(fruits));
//		reverseArrayB(fruits);
//		System.out.println(Arrays.asList(fruits));
//		System.out.println(findMinimum(arr));
//		printArray(arr);
//		moveZeros(arr, arr.length);
//		printArray(arr);
		
//		int[]arr = {0,11,34,5};
//		System.out.println("original size: "+arr.length);
//		arr = resize(arr, 10);
//		System.out.println("size after resizing: "+arr.length);
//		
//		System.out.println(findSecondMax(arr));
//		printArray(arr);
//		arr = removeEven(arr);
//		printArray(arr);
		int[] nums = {1,7,5,4,2,9,6,8,3};
//		System.out.println(findMissingNumber(nums));
		System.out.println(Arrays.toString(nextGreaterElement(nums)));
		
		// 7,9,9,9,9,-1,8,-1,-1
		
	}

}
