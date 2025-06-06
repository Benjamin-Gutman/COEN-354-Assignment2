package Question4;

import java.util.Random;

//The code runs by randomly producing a boolean value
//instead of comparing larger vs smaller, produce a random boolean to determine when 
//to take from the left or right merge array

public class Question4 {

	
	public static void main(String[] args) {
		linkedlist list = new linkedlist();
		for (int i =1; i <= 10; i++) {
			list.pushFront(i);
		}
		linkedlist shuffledList = new linkedlist();
		shuffledList.head = list.shuffle(list.head);
		shuffledList.printLinkedList();
	}
}

	
	
	
class linkedlist{
	
	Node head;
	
	static class Node{
		int data;
		Node next;
	}

	
	void pushFront(int Data) {
		 Node temp = new Node();
		 temp.data = Data;
		 temp.next = head;
		 head = temp;
	}
	
	static Node getMid(Node Head) {
		if(Head == null|| Head.next == null) {
			return Head;
		}
		Node mid = Head;
		Node end = Head;
		Node beforeMid = null;
		while (end != null && end.next != null) {
			end = end.next.next;
			beforeMid = mid;
			mid = mid.next;
		}
		return beforeMid;
	}
	
	 Node shuffle(Node Head) {
		if (Head.next == null) {
			return Head;
		}
		Node mid = getMid(Head);
		Node second = mid.next;
		mid.next = null;
		
		Node half1 = shuffle(Head);
		Node half2 = shuffle(second);
		
		return merge(half1, half2);
	}
	
	static Node merge(Node left, Node right) {
		Node current = new Node();
		Node fakeHead = current;
		Random rand = new Random();
		while (left != null && right != null) {
			if (rand.nextBoolean()) {
				current.next = left;
				left = left.next;
				current = current.next;
			}
			else {
				current.next = right;
				right = right.next;
				current = current.next;
			}
		}
		while (left != null) {
				current.next = left;
				left = left.next;
				current = current.next;
		}
		while (right != null) {
				current.next = right;
				right = right.next;
				current = current.next;
		}
		
		return fakeHead.next;
	}
	
	void printLinkedList() {
		Node pointer = head;
		while (pointer != null) {
			System.out.println(pointer.data);
			pointer = pointer.next;
		}
	}
	
}

