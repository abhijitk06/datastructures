package com.abhijit.ctci.linkedlist;

import java.util.Stack;

public class Queue {
	Node head;
	Node tail;
	
	public boolean isEmpty(){
		if(head == null){
			return true;
		}else{
			return false;
		}
	}
	
	  public static boolean areEqual(char a, char b){
		  if(a == '(' && b == ')'){
			  return true;
		  }else if(a == '[' && b == ']'){
			  return true;
		  }else if(a == '{' && b == '}'){
			  return true;
		  }
		  return false;
	  }
	  
	  public static boolean isBalanced(String expression) {
	        if((expression != null) &&  (!expression.isEmpty())){
	            char charArray[] = expression.toCharArray();
	            Stack<Character> st = new Stack<Character>();
	            for(int i=0; i < charArray.length; i++){
	            	if(st.isEmpty()){
	            		st.add(charArray[i]);
	            	}else{
	       
	            		if(areEqual(st.peek(),charArray[i])){
	            			st.pop();
	            		}else{
	            			st.add(charArray[i]);
	            		}
	            		
	            	}
	            }
	            if(st.isEmpty()){
	            	return true;
	            }else{
	            	return false;
	            }
	        }
	        return false;
	    }
	  
	
	public void push(int data){
		if(head == null){
			head = new Node(data);
			return;
		}
		
		Node current = head;
		while(current.next != null){
			current = current.next;
		}
		current.next = new Node(data);
		tail = current.next;
	}
	
	public int pop(){
		Node temp = head.next;
		int d = temp.data;
		head = temp;
		return d;
	}
	
	public static void main(String args[]){
		String test = "{[()]}";
		System.out.println(isBalanced(test));
	}
}
