package com.abhijit.ctci;

import java.util.Arrays;

import com.abhijit.ctci.linkedlist.Node;

public class MinIntHeap {
	int capacity = 10;
	int size;	
	int items[] = new int[capacity];
	
	public int getLeftChildIndex(int index){
		return ((index*2)+1);
	}
	public int getRightChildIndex(int index){
		return ((index*2)+2);
	}
    public int getParentIndex(int index){
    	return ((index-1)/2);
    }
    
    public boolean hasLeftChild(int index){
    	return (getLeftChildIndex(index) < size);
    }
	
    public boolean hasRightChild(int index){
    	return (getRightChildIndex(index) < size);
    }

    public boolean hasParent(int index){
    	return (getParentIndex(index) < size);
    }

    public int getLeftChild(int index){
    	return items[getLeftChild(index)];
    }
    
    public int getRightChild(int index){
    	return items[getRightChild(index)];
    }
    
    public int getParent(int index){
    	return items[getParent(index)];
    }
    
    
    public void swap(int index1,int index2){
    	int temp = items[index1];
    	items[index1] = items[index2];
    	items[index2] = temp;
    }
    
    public void ensureCapacity(){
        if(items.length == size){
        	items = Arrays.copyOf(items, size*2);
        	capacity *= 2;
        }
    }
    
    public int peek(){
    	if(size ==0){
    		throw new IllegalArgumentException();
    	}
    	return items[0];
    }
    
    public int poll(){
    	if(size ==0){
    		throw new IllegalArgumentException();
    	}
    	int item = items[0];
    	items[0] = items[size-1];
    	size--;
    	heapifyDown();
    	return item;
    }
    
    public void add(int data){
    	ensureCapacity();
    	items[size] = data;
        size++;
        heapifyUp();
    }
    
    public void heapifyUp(){
    	int index = size -1;
    	while(hasParent(index) && (getParent(index)> items[index] ) ){
    		swap(index, getParentIndex(index));
    		index --;
    	}
    }
    
    public void heapifyDown(){
    	int index = size -1;
    	while(hasLeftChild(index) ){
    		int minChildIndex = getLeftChild(index);
    		if(hasRightChild(index) && (getRightChild(index) < getLeftChild(index))){
    			minChildIndex = getLeftChildIndex(index);
    		}   		
    		if(items[index] < items[minChildIndex]){
    			break;
    		}else{
    			swap(index,minChildIndex);
    		}
    	}
    }
    
    
    
    
    
    
    
    
    
}
