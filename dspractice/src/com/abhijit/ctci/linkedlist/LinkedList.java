package com.abhijit.ctci.linkedlist;

public class LinkedList {
	Node head;

	public void append(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		Node current = head;
		while(current.next != null){
			current = current.next;
		}
		current.next = new Node(data);	
	}
	
	public void prepend(int data){
		Node newHead = new Node(data);
		newHead.next = head;
		head = newHead;
	}
	
	public void deleteWithValue(int data){
		if(head == null){
			return;
		}
		if(head.data == data){
			head = head.next;
			return;
		}
		Node current = head;
		Node next = current.next;
		while(next != null){
			if(next.data == data){
				Node newNext = next.next;
				current.next = newNext;
				return;
			}
		}
	}
	
	boolean hasCycle(Node head) {
	    if(head == null){
	        return false;
	    }     
	    Node current = head;
	    Node fastPointer = head;
	    while(current != null && fastPointer !=null){
	        current = current.next;
	        if(fastPointer.next != null){
	             fastPointer = fastPointer.next.next;
	             if(fastPointer != null && (current != null) &&(fastPointer.data == current.data)){
	                 return true;
	             }else{
	                 return false;
	             }
	            
	        }else{
	            return false;
	        }      
	    }
	    return false;
	}
	 
	public static void main(String args[]){
		LinkedList ll = new LinkedList();
		ll.append(3);
		System.out.println(ll.hasCycle(new Node(3)));
		//ll.hasCycle(new Node(3));
	}

}
