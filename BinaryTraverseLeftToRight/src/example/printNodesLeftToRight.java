package example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class printNodesLeftToRight {
	
	// A Binary Tree Node 
	static class Node 
	{ 
		int data; 
		Node left, right; 
	}; 
	
	// create a new tree node 
	static Node newNode(int data) 
	{ 
		Node temp = new Node(); 
		temp.data = data; 
		temp.left = temp.right = null; 
		return temp; 
	} 
	

	public static Queue<Node> queue = new LinkedList<Node>();

	// return leaf nodes from right to left 
	static Queue<Node> traverseLeaves(Node root) 
	{ 
		 
		Stack<Node> stack = new Stack<>(); 

		while (true) 
		{ 
			if (root != null) 
			{ 
				stack.push(root); 
				root = root.right; 
			} 

			else
			{ 
				// If stack is empty then come out 
				// of the loop 
				if (stack.empty()) 
					break; 
				else
				{ 
					if (stack.peek().left == null) 
					{ 
						root = stack.peek(); 
						stack.pop(); 

						// Add the leaf node 
						if (root.right == null) 
							queue.add(root);
					} 

					while (root == stack.peek().left) 
					{ 
						root = stack.peek(); 
						stack.pop(); 

						if (stack.empty()) 
							break; 
					} 
					if (!stack.empty()) 
						root = stack.peek().left; 
					else
						root = null; 
				} 
			} 
		}
		return queue;
		
	} 
 
	public static void main(String args[]) 
	{ 
		Node root = newNode(8); 
		root.left = newNode(3); 
		root.right = newNode(10); 
		root.left.left = newNode(1); 
		root.left.right = newNode(6); 
		root.right.right = newNode(14); 
		root.left.right.left = newNode(4);
	  	root.left.right.right = newNode(7); 
		root.right.right.left = newNode(13); 
		
		 traverseLeaves(root).forEach(e ->{
			System.out.print(e.data + " ");
		});
	} 

}
