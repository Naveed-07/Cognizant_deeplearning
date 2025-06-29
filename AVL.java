package avltree;

class AVL {

	    public class Node {
	    private int value;
	    private Node left;
	    private Node right;
	    private int height;

	 public Node(int value) { 
	 this.value = value;
	 }

	 public int getValue() {
		 
	    return value;
	    
	  }
	  }

	  private Node root;

	  public AVL() {

	  }

	  public int height() {
	    return height(root);
	  }
	  private int height(Node node) {
	    if (node == null) {
	      return -1;
	    }
	    return node.height;
	  }
	  
	  public void insert(int value) {
	    root = insert(value, root);
	  }

	  private Node insert(int value, Node node) {
	    if (node == null) {
	      node = new Node(value);
	      return node;
	    }

	    if (value < node.value) {
	      node.left = insert(value, node.left);
	    }

	    if (value > node.value) {
	      node.right = insert(value, node.right);
	    }

	    node.height = Math.max(height(node.left), height(node.right)) + 1;
	    return rotate(node);
	  }

	  private Node rotate(Node node) {
	    if (height(node.left) - height(node.right) > 1) {
	     
	      if(height(node.left.left) - height(node.left.right) > 0) {
	       
	        return rightRotate(node);
	      }
	      if(height(node.left.left) - height(node.left.right) < 0) {
	       
	        node.left = leftRotate(node.left);
	        return rightRotate(node);
	      }
	    }

	    if (height(node.left) - height(node.right) < -1) {
	      
	      if(height(node.right.left) - height(node.right.right) < 0) {
	        
	        return leftRotate(node);
	      }
	      if(height(node.right.left) - height(node.right.right) > 0) {
	       
	        node.right = rightRotate(node.right);
	        return leftRotate(node);
	      }
	    }

	    return node;
	  }

	  public Node rightRotate(Node parent) {
	    Node child = parent.left;
	    Node temp = child.right;

	    child.right = parent;
	    parent.left = temp;
	    
	    parent.height = Math.max(height(parent.left), height(parent.right) + 1);
	    child.height = Math.max(height(child.left), height(child.right) + 1);

	    return child;
	  }

	  public Node leftRotate(Node child) {
	    Node parent = child.right;
	    Node temp = parent.left;
	    parent.left = child;
	    child.right = temp;
	    
	    parent.height = Math.max(height(parent.left), height(parent.right) + 1);
	    child.height = Math.max(height(child.left), height(child.right) + 1);

	    return parent;
	  }

	  public void populate(int[] nums) {
	    for (int i = 0; i < nums.length; i++) {
	      this.insert(nums[i]);
	    }
	  }

	  public void populatedSorted(int[] nums) {
	    populatedSorted(nums, 0, nums.length);
	  }

	  private void populatedSorted(int[] nums, int start, int end) {
	    if (start >= end) {
	      return;
	    }

	    int mid = (start + end) / 2;

	    this.insert(nums[mid]);
	    populatedSorted(nums, start, mid);
	    populatedSorted(nums, mid + 1, end);
	  }

	  public void display() {
	    display(this.root, "Root Node: ");
	  }

	  private void display(Node node, String details) {
	    if (node == null) {
	      return;
	    }
	    System.out.println(details + node.value);
	    display(node.left, "Left child of " + node.value + " : ");
	    display(node.right, "Right child of " + node.value + " : ");
	  }
}