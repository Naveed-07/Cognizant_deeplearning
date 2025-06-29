  package LinkedList;

public class LinkedList{
	
	Node head;
	
	
	public void insert(int data) {
		Node node=new Node();
		node.data=data;
		node.next=null;
		
		if(head==null) {
			insertAtStartUsingNode(node);
		}
		else {
			Node n=head;
			while(n.next!=null) {
				n=n.next;
			}
			
			n.next=node;
		}
	}
	private void insertAtStartUsingNode(final Node node) {
		node.next = this.head;
		this.head = node;
	}
	public void insertAtStart(int data) {
		Node node=new Node();
		node.data=data;
		insertAtStartUsingNode(node);
	}
	public void insertAt(int index,int data) {
		Node node=new Node();
		node.data=data;
		node.next=null;
		
		if(index==0) {
			insertAtStartUsingNode(node);
		}else {
			Node n=head;
			for(int i=0;i<index-1 && n.next != null;i++) {
				n=n.next;
			}
			node.next=n.next;
			n.next=node;
		}
	}
	public void deleteAt(int index) {
		
		if(index==0) {
			head=head.next;
		}
		else {
			Node n=head;
			Node n1=null;
			
			for(int i=0;i < index-1;i++) {
				n=n.next;
			}
			n1=n.next;
			n.next=n1.next;
		}
	}
	public void show() {
		Node node=head;
		
		while(node!=null) {
			System.out.println(node.data);
			node=node.next;
		}
		
	}
}