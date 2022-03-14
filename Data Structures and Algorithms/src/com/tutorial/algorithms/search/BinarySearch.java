package com.tutorial.algorithms.search;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] arr = {2,7,12,20,34,36,72,98};
		System.out.println(binarySearch(arr, 2));

	}
	
	
	public static int binarySearch(int[] arr, int key) {
		
		int low = 0;
		int high = arr.length - 1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			if(arr[mid] == key) {
				return mid;
			}
			
			if(key < arr[mid]) {
				high = mid - 1;
			}
			
			else {
				low = mid + 1;
			}
		}
		
		return -1;
	}

}
