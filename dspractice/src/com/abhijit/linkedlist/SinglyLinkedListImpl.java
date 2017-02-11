package com.abhijit.linkedlist;

public class SinglyLinkedListImpl<T> {
	 
    private Node<T> head;
    private Node<T> tail;
     
    public void add(T element){
         
        Node<T> nd = new Node<T>();
        nd.setValue(element);
        System.out.println("Adding: "+element);
        /**
         * check if the list is empty
         */
        if(head == null){
            //since there is only one element, both head and
            //tail points to the same object.
            head = nd;
            tail = nd;
        } else {
            //set current tail next link to new node
            tail.setNextRef(nd);
            //set tail as newly created node
            tail = nd;
        }
    }
     
    public void addAfter(T element, T after){
         
        Node<T> tmp = head;
        Node<T> refNode = null;
        System.out.println("Traversing to all nodes..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refNode != null){
            //add element after the target node
            Node<T> nd = new Node<T>();
            nd.setValue(element);
            nd.setNextRef(tmp.getNextRef());
            if(tmp == tail){
                tail = nd;
            }
            tmp.setNextRef(nd);
             
        } else {
            System.out.println("Unable to find the given element...");
        }
    }
     
    public void deleteFront(){
         
        if(head == null){
            System.out.println("Underflow...");
        }
        Node<T> tmp = head;
        head = tmp.getNextRef();
        if(head == null){
            tail = null;
        }
        System.out.println("Deleted: "+tmp.getValue());
    }
     
    public void deleteAfter(T after){
         
        Node<T> tmp = head;
        Node<T> refNode = null;
        System.out.println("Traversing to all nodes..");
        /**
         * Traverse till given element
         */
        while(true){
            if(tmp == null){
                break;
            }
            if(tmp.compareTo(after) == 0){
                //found the target node, add after this node
                refNode = tmp;
                break;
            }
            tmp = tmp.getNextRef();
        }
        if(refNode != null){
            tmp = refNode.getNextRef();
            refNode.setNextRef(tmp.getNextRef());
            if(refNode.getNextRef() == null){
                tail = refNode;
            }
            System.out.println("Deleted: "+tmp.getValue());
        } else {
            System.out.println("Unable to find the given element...");
        }
    }
     
    public void traverse(){
         
        Node<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getValue());
            tmp = tmp.getNextRef();
        }
    }
    public void traverse(Node<T> head){
        
        Node<T> tmp = head;
        while(true){
            if(tmp == null){
                break;
            }
            System.out.println(tmp.getValue());
            tmp = tmp.getNextRef();
        }
    }
 
    
    public Node<T> getMiddleElement(Node<T> head){
    	Node<T> firstPointer;
    	Node<T> secondPointer;
    	firstPointer = secondPointer = head;
    	
    	while(secondPointer != null && secondPointer.getNextRef() != null){	
    		firstPointer = firstPointer.getNextRef();
    		secondPointer = secondPointer.getNextRef().getNextRef();
    	}
    	return firstPointer;
    }
    
    public Node<T> getNthNodeFromEnd(Node<T> head, int n){
    	Node<T> firstPointer;
    	Node<T> secondPointer;
    	firstPointer = secondPointer = head;
    	for(int i=0; i < n; i++){
    		if(secondPointer != null){
    			secondPointer = secondPointer.getNextRef();
    		}
    	}
    	while(secondPointer != null){
    		secondPointer = secondPointer.getNextRef();
    		firstPointer = firstPointer.getNextRef();
    	}
    	return firstPointer;
    	
    	
    }	
    
    public Node<T>  reverseList(Node<T> head){
    	Node<T> current = head;
    	Node<T> previous = null;
    	while(current != null){
    		previous = current.getNextRef();
    		current.setNextRef(previous);    		
    		current = previous;
    	}
    	return current;
    }
    
    public void exchangeAdjacent(Node<T> head){
    	Node<T> current = head;
    	Node<T> next = current.getNextRef();
    	Node<T> temp = next;
    	temp.setNextRef(current);
    	current.setNextRef(next.getNextRef());
    	
    }
     
    public Node<T> getHead(){
    	return head;
    }
    public static void main(String a[]){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.add(83);
        sl.add(88);
        sl.add(23);
        sl.add(48);
       // sl.addAfter(76, 54);
        //sl.deleteFront();
        //sl.deleteAfter(76);
        sl.traverse();
        System.out.println("Middle Element : " + (sl.getMiddleElement(sl.getHead())).getValue());
     
        System.out.println("Element from last n element "+   sl.getNthNodeFromEnd(sl.getHead(), 2).getValue()  );
       
        sl.traverse(sl.getHead()); 
        System.out.println("****");
        sl.traverse(sl.reverseList(sl.getHead()));
        
        
    }
}