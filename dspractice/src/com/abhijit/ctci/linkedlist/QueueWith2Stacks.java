package com.abhijit.ctci.linkedlist;

import java.util.Stack;

public class QueueWith2Stacks<T> {
	Stack<T> stackNewestOnTop = new Stack<T>();
    Stack<T> stackOldestOnTop = new Stack<T>();

    public void enqueue(T value) { // Push onto newest stack
    	stackNewestOnTop.add(value);  	
    }

    public T peek() {
    	if(stackOldestOnTop.isEmpty()){
    		while(!stackNewestOnTop.isEmpty()){
        		stackOldestOnTop.add(stackNewestOnTop.pop());   		
        	}
    	}
        return stackOldestOnTop.peek();    	
    }

    public T dequeue() {
    	if(stackOldestOnTop.isEmpty()){
    		while(!stackNewestOnTop.isEmpty()){
        		stackOldestOnTop.add(stackNewestOnTop.pop());   		
        	}
    	}
  	return stackOldestOnTop.pop();
    }
}
