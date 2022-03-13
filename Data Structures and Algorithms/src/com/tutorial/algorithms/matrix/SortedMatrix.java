package com.tutorial.algorithms.matrix;

public class SortedMatrix {
	
	public static void main(String[] args) {
		int[][] matrix = {{10,20,30,40},
				          {15,25,35,45},
				          {27,29,37,48},
				          {32,33,39,51}};
		
		search(matrix, matrix.length, 37);
		
	}
	
	
	
	//In row and column wise sorted matrix rows and columns sorted in ascending order.
	//It means that from each element to the left are only elements that less than this element.
	//And from each element to down are only elements that bigger than this element.
	
	//Search in a row wise and column wise sorted matrix.
	public static void search(int[][]matrix, int n, int x) {
		
		int i = 0;
		int j = n - 1;
		
		while(i < n && j >= 0) {
			if(matrix[i][j] == x) {
				System.out.println(x + " found at " + i + " and " + j);
				return;
			}
			
			if(x < matrix[i][j]) {
				j--;
			}
			else {
				i++;
			}
		}
		System.out.println("Not Found!");
	}

	

}
