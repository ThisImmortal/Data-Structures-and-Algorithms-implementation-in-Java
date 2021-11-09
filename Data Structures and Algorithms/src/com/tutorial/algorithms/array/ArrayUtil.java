package com.tutorial.algorithms.array;

import java.util.Arrays;
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
	
	//Remove even integers from an array
	public static int[] removeEven(int[]arr) {
		int oddCount = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0) {
				oddCount++;
			}
		}
		
		int[]oddArray = new int[oddCount];
		int idx = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0) {
				oddArray[idx++] = arr[i];
			}
		}
		return oddArray;
		
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
		
		System.out.println(findSecondMax(arr));
		printArray(arr);
		arr = removeEven(arr);
		printArray(arr);
		
	}

}
