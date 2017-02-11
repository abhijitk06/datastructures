package com.abhijit.tree;

public class Node {
	int value;
	Node leftNode;
	Node righNode;
	
	public Node(int value){
		this.value = value;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRighNode() {
		return righNode;
	}
	public void setRighNode(Node righNode) {
		this.righNode = righNode;
	}
	

}
