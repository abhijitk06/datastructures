package com.abhijit.tree;

public class BinerySearchTree {
	Node root;

	public void addNode(int value){
		addNode(new Node(value));
	}

	private void addNode(Node node){
		if(node != null){
			Node parentNode = root;
			if(root == null){
				root = node;
			}else{
				while(true){
					if(node.value < parentNode.value){
						if(parentNode.leftNode == null){
							parentNode.leftNode = node;
							return;
						}else{
							parentNode = parentNode.leftNode;
						}
					}else{
						if(parentNode.righNode == null){
							parentNode.righNode = node;
							return;
						}else{
							parentNode = parentNode.righNode;
						}
					}
				}
			}
		}   	
	}

	public void traverseAscending(){
		displayAscending(root);
	}

	public void traverseDescending(){
		displayDescending(root);
	}


	private void displayAscending(Node node){
		if(node.leftNode != null){
			displayAscending(node.leftNode);
		}
		System.out.println(node.value);
		if(node.righNode != null){
			displayAscending(node.righNode);
		}
	}

	private void displayDescending(Node node){
		if(node.righNode != null){
			displayDescending(node.righNode);
		}
		System.out.println(node.value);
		if(node.leftNode != null){
			displayDescending(node.leftNode);
		}
	}

	private boolean isIdenticalTree(Node a, Node b){
		if(a == null && b == null){
			return true;
		}
		if(a != null && b != null){
			return ((a.value == b.value) && isIdenticalTree(a.leftNode, b.leftNode) && isIdenticalTree(a.righNode, b.righNode));

		}
		return false;
	}
	
	boolean checkBST(Node root) {
        if(root != null){
            Node leftNode = root.leftNode;
            Node rightNode = root.righNode;
            if(leftNode != null){
                if(leftNode.value > root.value){
                    return false;
                }else{
                    checkBST(leftNode);
                }
            }
            if(rightNode != null){
                if(rightNode.value < root.value){
                    return false;
                }else{
                    checkBST(rightNode);
                }
            }
        }  
        return true;
    }


	public static void main(String args[]){
		BinerySearchTree bst = new BinerySearchTree();
		bst.addNode(1);
		bst.addNode(2);
		bst.addNode(2);
		bst.addNode(4);
		bst.addNode(5);
		bst.addNode(6);
		System.out.println(bst.checkBST(bst.root));
		
		/*
		bst.addNode(6);
		bst.addNode(8);
		bst.addNode(2);
		bst.addNode(3);
		bst.addNode(11);
		bst.addNode(1);
		
		System.out.println(bst.checkBST(bst.root));
		
		/*
		bst.traverseAscending();
		System.out.println("***");
		bst.traverseDescending();
		System.out.println("*******");
		
		BinerySearchTree bst2 = new BinerySearchTree();
		bst2.addNode(2);
		bst2.addNode(4);
		bst2.addNode(3);
		bst2.addNode(1);

		BinerySearchTree bst3 = new BinerySearchTree();
		bst3.addNode(2);
		bst3.addNode(3);
		bst3.addNode(1);
		bst3.addNode(4);
		
		System.out.println("Is identical: " + bst.isIdenticalTree(bst2.root, bst3.root));
		*/
		
		
	}
}
