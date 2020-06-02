package example;


import java.util.LinkedList;
import java.util.Queue;

class Node { 
	int data; 
	Node left, right; 

	public Node(int item) { 
		data = item; 
		left = null; 
		right = null; 
	} 
} 

public class BinaryTree {
	
	Node root; 
	
	Queue<Node> queue1 = new LinkedList<Node>(); 
	
	// return queue all leaf node
	Queue<Node> printLevelOrder() 
	{ 
		
		Queue<Node> queue = new LinkedList<Node>(); 
		queue.add(root); 
		queue1.add(root);
		while (!queue.isEmpty()) 
		{ 
	
			Node tempNode = queue.poll();  

			/*Enqueue left child */
			if (tempNode.left != null) { 
				queue.add(tempNode.left); 
				queue1.add(tempNode.left);
			} 

			/*Enqueue right child */
			if (tempNode.right != null) { 
				queue.add(tempNode.right); 
				queue1.add(tempNode.right);
			} 
		} 
		
		return queue1;
	} 

	public static void main(String args[]) 
	{ 
		/* creating a binary tree and entering 
		the nodes */
		BinaryTree binaryTree= new BinaryTree(); 
		binaryTree.root = new Node(1); 
		binaryTree.root.left = new Node(2); 
		binaryTree.root.right = new Node(5); 
		binaryTree.root.right.left = new Node(3);
		binaryTree.root.right.right = new Node(6);
		binaryTree.root.right.left.left = new Node(4);

      Queue<Node>	result = binaryTree.printLevelOrder();
      result.forEach(e ->{
    	  System.out.print(e.data+" ");
      });
	} 

}
