package com.tutorial.algorithms.linkedlist;

import java.util.NoSuchElementException;

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
	
	//Insert node at the beginning of a Doubly LinkedList
	public void insertFirst(int value) {
		ListNode newNode = new ListNode(value);
		
		if(isEmpty()) {
			tail = newNode;
		}
		else {
			head.previous = newNode;
		}
		newNode.next = head;
		head = newNode;
		length++;
	}
	
	//Insert node at the beginning of a Doubly LinkedList
	public void insertLast(int value) {
		ListNode newNode = new ListNode(value);
		
		if(isEmpty()) {
			head = newNode;
		}		
		else {
			tail.next = newNode;
			newNode.previous = tail;
		}
		tail = newNode;
		length++;
	}
	
	//Delete first node in a Doubly LinkedList
	public ListNode deleteFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException("No such element!");}
			
			ListNode temp = head;
			if(head == tail) {
				tail = null;
			}
			else {
				temp.next.previous = null;
			}
			head = head.next;
			temp.next = null;
			length--;
		
		
		return temp;
	}
	
	//Delete last node in a Doubly LinkedList
	public ListNode deleteLast() {
		if(isEmpty()) {
			throw new NoSuchElementException("No such element!");
		}
		
		ListNode temp = tail;
		if(head == tail) {
			head = null;
		}
		else {
			tail.previous.next = null;
			
		}
		tail = tail.previous;
		temp.previous = null;
		length--;
		
		return temp;
	}
	
	public static void main(String[]args) {
		DoublyLinkedList dll = new DoublyLinkedList();
//		System.out.println(dll.isEmpty());
//		System.out.println(dll.length);
//		dll.insertFirst(2);
//		dll.insertFirst(5);
//		dll.insertFirst(8);
//		dll.displayForward();
//		dll.displayBackward();
//		dll.insertFirst(3);
//		dll.insertLast(4);
//		dll.displayForward();
//		dll.deleteFirst();
//		dll.displayForward();
//		dll.deleteLast();
//		dll.deleteFirst();
//		dll.deleteFirst();
//		dll.deleteFirst();
//		dll.deleteFirst();
//		
//		dll.displayForward();
	}
}
