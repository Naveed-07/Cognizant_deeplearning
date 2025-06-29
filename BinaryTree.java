package bst;


class Node{
	
	int data;
	Node right;
	Node left;
	
	public Node(int data) {
		
		this.data = data;
		this.left = null;
		this.right = null;

	}package bst;

class Node {
    int data, height;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {
    Node root;

    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private Node rotateRight(Node unbalancedNode) {
        Node newRoot = unbalancedNode.left;
        Node tempSubtree = newRoot.right;

        newRoot.right = unbalancedNode;
        unbalancedNode.left = tempSubtree;

        unbalancedNode.height = Math.max(height(unbalancedNode.left), height(unbalancedNode.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;

        return newRoot;
    }

    private Node rotateLeft(Node unbalancedNode) {
        Node newRoot = unbalancedNode.right;
        Node tempSubtree = newRoot.left;

        newRoot.left = unbalancedNode;
        unbalancedNode.right = tempSubtree;

        unbalancedNode.height = Math.max(height(unbalancedNode.left), height(unbalancedNode.right)) + 1;
        newRoot.height = Math.max(height(newRoot.left), height(newRoot.right)) + 1;

        return newRoot;
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node node, int data) {
        if (node == null) return new Node(data);

        if (data < node.data) node.left = insertRec(node.left, data);
        else if (data > node.data) node.right = insertRec(node.right, data);
        else return node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);

        if (balance > 1 && data < node.left.data) return rotateRight(node);
        if (balance < -1 && data > node.right.data) return rotateLeft(node);
        if (balance > 1 && data > node.left.data) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && data < node.right.data) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node node, int data) {
        if (node == null) return node;

        if (data < node.data) node.left = deleteRec(node.left, data);
        else if (data > node.data) node.right = deleteRec(node.right, data);
        else {
            if (node.left == null || node.right == null) {
                Node temp = node.left != null ? node.left : node.right;
                if (temp == null) return null;
                else node = temp;
            } else {
                Node temp = minValueNode(node.right);
                node.data = temp.data;
                node.right = deleteRec(node.right, temp.data);
            }
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);

        if (balance > 1 && getBalance(node.left) >= 0) return rotateRight(node);
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) return rotateLeft(node);
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) current = current.left;
        return current;
    }

    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.data + " -> ");
            inorderRec(node.right);
        }
    }
}

}
 public class BinaryTree{
	 
	 Node root;
	 
	 public void insert(int data) {
		 
		 root=insertRec(root , data);
	 }
	 
	 private Node insertRec(Node root , int data) {
		 
		 if(root == null) {
			 return new Node (data);
			 
		 }
		 else if(data < root.data) {
			 root.left = insertRec(root.left, data);
		 }
		 else if(data > root.data) {
			 root.right =insertRec(root.right, data);
		 }
		return root;
	}
	 
	 public void delete(int data) {
		 
		 root = deleteRec(root,data);
	 }
	 
	 private Node deleteRec(Node root,int data) {
		
		 if(root == null) {
			 return null;
		 }
		 else if(data < root.data) {
			 root.left = deleteRec(root.left,data);
		 }
		 else if(data > root.data) {
			 root.right=deleteRec(root.right,data);
		 }else
		 {
			 if (root.left == null && root.right == null) {  //no leaf node 
				 
				 return null;
			 }
			 else {
				 if(root.left == null) { //one child
					 
					 return root.right;
				 }
				 else if(root.right == null) {
					 
					 return root.left;
				 }
				 
			 }
		 }
		 
		 return root;
	 }
	 
	 public void inorder() {
		 
		 System.out.println("Inorder");
		 inorderRec(root);
		 System.out.println();
	 }

	private void inorderRec(Node root) {
		
		if(root != null) {
			
			inorderRec(root.left);
			System.out.print(root.data + " -> ");
			inorderRec(root.right);
			
		}
	}
	
	public void preorder() {
		
		System.out.println("Preorder");
		preorderRec(root);
		System.out.println();
		
	}

	private void preorderRec(Node root) {
		
		if(root != null) {
		
		System.out.print(root.data + " -> ");
		preorderRec(root.left);
		preorderRec(root.right);
		
	}
	}
	public void postorder() {
		
		System.out.println("Postorder");
		postorderRec(root);
		System.out.println();
		
	}
	private void postorderRec(Node root) {
		
		if(root != null) {
			
		preorderRec(root.left);
		preorderRec(root.right);
		System.out.print(root.data + " -> ");
		
		}
	}
 }
