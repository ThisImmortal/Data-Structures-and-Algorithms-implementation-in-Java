package com.tutorial.algorithms.linkedlist;


public class SinglyLinkedList {

	private static ListNode head;
	
	private static class ListNode{
		
		private int data; //Generic Type
		private ListNode next;
		
		public ListNode(int data) {
		
			this.data = data;
			this.next = null;
		}
	}
	
	//Print LinkedList Elements (Implementation)
	public void display() {
		
		ListNode current = head;
		
		while(current != null) {
			System.out.print(current.data + " --> ");
			current = current.next;
		}
		System.out.println("null");
	}
	
    //Find length of LinkedList
	public int length() {
		
		if(head == null) {
			return 0;
		}
		
		int count = 0;
		ListNode current = head;
		
		while(current != null) {
			count++;
			current = current.next;
		}		
		return count;
	}
	
	//Insert node at the beginning of LinkedList
	public void insertFirst(int value) {
		
		ListNode newNode = new ListNode(value);
		newNode.next = head;
		head = newNode;
						
	}
	
	//Insert node at the end of LinkedList
	public void insertLast(int value) {
		
		ListNode newNode = new ListNode(value);
		if(head == null) {
			head = newNode;
			return;
		}
		
		ListNode current = head;
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = newNode;
	}
	
	//Insert node at a given position of LinkedList
	public void insert(int position, int value) {
		
		ListNode node = new ListNode(value);
		if(position == 1) {
			node.next = head;
			head = node;
		} else {
			ListNode previous = head;
			int count = 1;
			while(count < position-1) {
				previous = previous.next;
				count++;
			}
			
			ListNode current = previous.next;
			previous.next = node;
			node.next = current;
		}
				
	}
	
	//Delete first node of a LinkedList
	public ListNode deleteFirst() {
		
		if(head == null) {
			return null;
		}
		
		ListNode temp = head;
		head = head.next;
		temp.next = null;
		
		return temp;
	}
	
	//Delete last node of a LinkedList
	public ListNode deleteLast() {
		
		if(head == null || head.next == null) {
			
			return head;
		}
		
		ListNode current = head;
		ListNode previous = null;
		while(current.next != null) {
			previous = current;
			current = current.next;
		}
		
		previous.next = null;
		return current;
		
	}
	
	//Delete node from a given position of LinkedList
	public void delete(int position) {
		
		if(position == 1) {
			head = head.next;
		}
		
		ListNode previous = head;
		int count = 1;
		
		while(count < position-1) {
			previous = previous.next;
			count++;
		}
		ListNode current = previous.next;
		
		previous.next = current.next;
				
	}
	
	//Search an element in LinkedList
	public boolean find(ListNode head, int searchKey) {
		
		if(head == null) {
			return false;
		} 
			ListNode current = head;
			while(current != null) {
				if(current.data == searchKey) {
					return true;
				}
				current = current.next;
			}
			return false;
									
	}
	
	//Reverse LinkedList
	public ListNode reverse(ListNode head) {
		
		if(head == null) {
			return head;
		}
		
		ListNode current = head;
		ListNode previous = null;
		ListNode next = null;
		
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		
		return previous;
	}
	
	//Find middle node of LinkedList
	public ListNode findMiddle() {
		
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		
		while(fastPointer != null && fastPointer.next != null) {
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		
		return slowPointer;
		
	}
	
	//Find Nth node from the end of a LinkedList
	public ListNode findNthFromEnd(int n) {
		
		if(head == null) {
			return null;
		}
		
		if(n <= 0) {
			throw new IllegalArgumentException("Invalid value: " + n);
		}
		ListNode mainPointer = head;
		ListNode refPointer = head;
		int count = 0;
		
		while(count < n) {
			if(refPointer == null) {
				throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
			}
			refPointer = refPointer.next;
			count++;
		}
		
		while(refPointer != null) {
			refPointer = refPointer.next;
			mainPointer = mainPointer.next;
		}
		
		return mainPointer;
	}
	
	//Remove duplicate nodes from sorted LinkedList
	public void removeDuplicates() {
		
		if(head == null) {
			return;
		}
		
		ListNode current = head;
		while(current != null && current.next != null) {
			if(current.data == current.next.data) {
				current.next = current.next.next;
			}
			
			else {
				current = current.next;
			}
		}
				
	}
	
	//Insert a node in a sorted LinkedList
	public ListNode insertInSortedList(int value) {
		
		ListNode newNode = new ListNode(value);
		if(head == null) {
			return newNode;
		}
		
		ListNode current = head;
		ListNode temp = null;
		
		while(current != null & current.data < newNode.data) {
			temp = current;
			current = current.next;
		}
		
		newNode.next = current;
		temp.next = newNode;
		
		return head;
	}
	
	
	//Check if LinkedList contains a loop
	public boolean ifContainsLoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		
		while(fastPtr!= null && fastPtr.next!=null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			
			if(fastPtr == slowPtr) {
				return true;
			}
		}
		
		return false;
	
	}
	
	
	//Find start of a loop in singly LinkedList  -  1st PART (Floyd's cycle detection algorithm)
	public ListNode findStartingOfLoop() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		
		while(fastPtr!= null && fastPtr.next!=null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			
			if(fastPtr == slowPtr) {
				return getStartingNode(slowPtr);
			}
		}
		
		return null;
	}
	
	//Find start of a loop in singly LinkedList  -  2nd PART (Floyd's cycle detection algorithm)
	public ListNode getStartingNode(ListNode slowPtr) {
		ListNode temp = head;
		while(slowPtr!=temp) {
			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		return temp;
	}
	
	
	
	//Remove a loop from singly LinkedList
	public void removeLoopFromLinkedlist() {
		
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		
		while(fastPtr!=null && fastPtr.next!=null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
			
			if(fastPtr == slowPtr) {
				removeLoop(slowPtr);
				return;
			}
		}
	}
	
	private void removeLoop(ListNode slowPtr) {
		ListNode temp = head;
		
		while(temp.next != slowPtr.next) {
			temp = temp.next;
			slowPtr = slowPtr.next;
			
		}
		
		slowPtr.next = null;
		
	}

	public void createLoopInLinkedList() {
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);
		
		head = first;
		first.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;
		sixth.next = third;
	}
	
	
	public static void main(String [] args) {
		
		SinglyLinkedList sll = new SinglyLinkedList();
		
		sll.createLoopInLinkedList();
		System.out.println(sll.ifContainsLoop());
		System.out.println(sll.findStartingOfLoop().data);
		sll.removeLoopFromLinkedlist();
		System.out.println(sll.ifContainsLoop());
		
	
		
		
		
//		sll.head = new ListNode(5);
//		sll.head.next = new ListNode(6);
//		sll.head.next.next = new ListNode(7);
//		sll.display();
//		head = sll.reverse(head);
//		sll.display();
//			
	}
}


