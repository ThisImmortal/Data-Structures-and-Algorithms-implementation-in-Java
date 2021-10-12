package com.tutorial.algorithms.linkedlist;

public class DoublyLinkedList {
	
	private ListNode head;
	private ListNode tail;
	private int length;
	
	public class ListNode{
		
		private int data;
		private ListNode next;
		private ListNode previous;
		
		public ListNode(int data) {
			this.data = data;
		}
		
	}
	
	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public boolean isEmpty() {
		return length==0;
	}
	
	public int length() {
		return length;
	}
	
	
	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		if(isEmpty()) {
			head=newNode;
		}
		else {
			tail.next = newNode;
			
		}
		newNode.previous = tail;
		tail = newNode;
		length++;
	}

	//Display Doubly LinkedList in forward direction
	public void displayForward() {
		
		if(head == null) {
			return;
		}
		ListNode temp = head;
		
		while(temp != null) {
			System.out.print(temp.data+" --> ");
			temp = temp.next;
		}
		System.out.println("null");
	}
	
	//Display Doubly LinkedList in backward direction
	public void displayBackward() {
		
		if(tail == null) {
			return;
		}
		ListNode temp = tail;
		
		while(temp != null) {
			System.out.print(temp.data+" --> ");
			temp = temp.previous;
		}
		System.out.println("null");
	}
	
	public static void main(String[]args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		System.out.println(dll.isEmpty());
		System.out.println(dll.length);
		dll.insertLast(2);
		dll.insertLast(5);
		dll.insertLast(8);
		dll.displayForward();
		dll.displayBackward();
	}
}
