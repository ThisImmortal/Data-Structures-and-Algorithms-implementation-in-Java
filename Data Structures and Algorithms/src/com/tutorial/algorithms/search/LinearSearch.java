package com.tutorial.algorithms.search;

public class LinearSearch {

	public static void main(String[] args) {
		
		int[] arr = {3, 15, 20, 10, 38, 4, 7};
		
		System.out.println(linearSearch(arr, arr.length, 38));

	}
	
	
	public static int linearSearch(int[] arr, int n, int x) {
		
		if(arr == null || arr.length == 0) {
			throw new IllegalArgumentException("Invalid input");
		}
		
		for(int i = 0; i < n; i++) {
			if(arr[i] == x) {
				return i;
			}
		}
		
		return -1;
	}

}
