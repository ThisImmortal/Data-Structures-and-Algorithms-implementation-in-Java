package com.tutorial.algorithms.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	
	private TreeNode root;
	
	private class TreeNode {
		
		private TreeNode left;
		private TreeNode right;
		private int data;
		
		public TreeNode(int data) {
			this.data = data;
		}
	}
	
	
	public void insert(int value) {
		root = insert(root, value);
	}
	
	public TreeNode insert(TreeNode root, int value) {
		
		if(root == null) {
			root = new TreeNode(value);
			return root;
		}
		
		if(value < root.data) {
			root.left = insert(root.left, value);
		}
		else {
			root.right = insert(root.right, value);
		}
		
		return root;
	}
	
	public void levelOrder() {
		if(root == null) {
			return;
		}
		
		Queue<TreeNode> queue = new LinkedList<BinarySearchTree.TreeNode>();
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
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(9);
		bst.insert(2);
		bst.insert(4);
		bst.insert(3);
		bst.insert(7);
		bst.insert(8);
		bst.insert(1);
		bst.insert(5);
		bst.insert(6);
		
		bst.levelOrder();
	}
	
}
