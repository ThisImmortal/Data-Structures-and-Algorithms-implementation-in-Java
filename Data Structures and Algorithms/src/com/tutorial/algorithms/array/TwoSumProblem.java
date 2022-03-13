package com.tutorial.algorithms.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
	
	
	//Two sum problem - First way
	public static int[] twoSum(int[] arr, int target) {
		
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			if(!map.containsKey(target - arr[i])) {
				map.put(arr[i], i);
			}
			else {
				result[1] = i;
				result[0] = map.get(target - arr[i]);
				return result;
			}
		}
		throw new IllegalArgumentException("Two numbers not found");
	}
	
	//leetcode less time usage version
	public int[] twoSum1a(int[] nums, int target) {
        HashMap<Integer,Integer>h=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            if(h.containsKey(target-nums[i])){
                return new int[]{h.get(target-nums[i]),i};
            }
            else{
                h.put(nums[i],i);
            }
        }
        return new int[]{0,0};
    }
	
	public static void main(String[] args) {
		int[] arr = {2,5,3,12,4};
		System.out.println(Arrays.toString(twoSum(arr, 40)));
	}
	

}
