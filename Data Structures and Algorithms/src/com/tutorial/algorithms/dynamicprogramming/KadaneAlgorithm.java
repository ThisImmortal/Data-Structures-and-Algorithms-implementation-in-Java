package com.tutorial.algorithms.dynamicprogramming;

public class KadaneAlgorithm {
	
	//Kadane's Algorithm for finding maximum subarray sum
	public static int maxSubArraySum(int[]arr) {
		
		int currentSum = arr[0];
		int maxSum = arr[0];
		
		for(int i = 1; i < arr.length; i++) {
			currentSum = currentSum + arr[i];
			if(currentSum < arr[i]) {
				currentSum = arr[i];
			}
//		OR  maxSum = Math.max(currentSum + arr[i], arr[i]);
			if(maxSum < currentSum) {
				maxSum = currentSum;
			}
		}
		return maxSum;
	}
	
	
	//Another way, but same logic
	   public static int maxSubArraySum1(int[] nums) {
	        
	        int max = Integer.MIN_VALUE, sum = 0;
	        
	        for(int i=0;i<nums.length;i++){
	            sum += nums[i];
	            max = Math.max(sum,max);
	            
	            if(sum<0) sum = 0;
	        }
	        
	        return max;
	    }
	
	public static void main(String[] args) {
		int[]arr = {-2,5,1,-3,8,4,-7,6};
		System.out.println(maxSubArraySum1(arr));
	}

}
