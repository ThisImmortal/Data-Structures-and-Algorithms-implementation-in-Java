package com.tutorial.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
	
	private TreeNode root;
	
	private class TreeNode{
		
		private TreeNode left;
		private TreeNode right;
		private int data;
		
		public TreeNode(int data) {
			this.data = data;
		}
	}
	
	public void createBinaryTree() {
		
		TreeNode first = new TreeNode(9);
		TreeNode second = new TreeNode(2);
		TreeNode third = new TreeNode(4);
		TreeNode fourth = new TreeNode(3);
		TreeNode fifth = new TreeNode(7);
		TreeNode sixth = new TreeNode(8);
		TreeNode seventh = new TreeNode(11);
		TreeNode eigth = new TreeNode(5);
		TreeNode nineth = new TreeNode(6);
		
		
		root = first;  // root ---> first
		first.left = second;
		first.right = third;  // second <--- first ---> third
		second.left = fourth;
		second.right = fifth;
		third.left = sixth;
		third.right = seventh;
		fourth.left = eigth;
		fourth.right = nineth;
		
		
		
	}
	
	
	//Recursive preorder traversal of a binary tree
	public void recursivePreOrder(TreeNode root) {
		
		if(root == null) {
			return;  //base case
		}
		
		System.out.print(root.data + " ");
		recursivePreOrder(root.left);
		recursivePreOrder(root.right);
	}
	
	
	//Iterative preorder traversal of a binary tree
	public void iterativePreOrder() {
		
		if(root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.println(temp.data);
			
			if(temp.right != null) {
				stack.push(temp.right);
			}
			
			if(temp.left != null) {
				stack.push(temp.left);
			}
		}
	}
	
	
	//Recursive inorder traversal of a binary tree
	public void recursiveInOrder(TreeNode root) {
		
		if(root == null) {  //base case
			return;
		}
		
		recursiveInOrder(root.left);
		System.out.print(root.data + " ");
		recursiveInOrder(root.right);
	}
	
	//Iterative inorder traversal of a binary tree
	public void iterativeInOrder() {
		if(root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = root;

		while(!stack.isEmpty() || temp != null) {
			if(temp != null) {
				stack.push(temp);
				temp = temp.left;
			} else {
				temp = stack.pop();
				System.out.print(temp.data + " ");
				temp = temp.right;
			}
		}
	}
	
	
	//Level order traversal of a binary tree
	public void levelOrder() {
		
		if(root == null) {
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			System.out.print(temp.data + " ");
			
			if(temp.left != null) {
				queue.offer(temp.left);
			}
			
			if(temp.right != null) {
				queue.offer(temp.right);
			}
		}
	}
	
	
	//Find maximum value of a binary tree
	public int findMax(TreeNode root) {
		
		if(root == null) { //base case
			return Integer.MIN_VALUE;
		}
		
		int result = root.data;
		
		int left = findMax(root.left);
		int right = findMax(root.right);
		
		if(left > result) {
			result = left;
		}
		
		if(right > result) {
			result = right;
		}
		
		return result;
	}
	

	
	
	
	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.createBinaryTree();
		binaryTree.recursivePreOrder(binaryTree.root);
		System.out.println(" ");
		binaryTree.recursiveInOrder(binaryTree.root);
		System.out.println(" ");
		binaryTree.levelOrder();
		
		System.out.print("\n" + "Max value: " + binaryTree.findMax(binaryTree.root));
	}

}
