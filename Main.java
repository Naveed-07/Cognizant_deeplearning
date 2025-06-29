package bst;


public class Main {

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		
		tree.insert(10);
		tree.insert(40);
		tree.insert(20);
		tree.insert(5);
		tree.insert(6);
		tree.insert(99);
		
		
		System.out.println("Before");
		tree.inorder();
		
		tree.delete(20);
		
		System.out.println("After");
		tree.inorder();
		
//		tree.preorder();
//		
//		tree.postorder();
	}
}
