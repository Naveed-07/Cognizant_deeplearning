package Double.LL;

public class DoubleLL {
 
	Node head;
	 public void insertFirst(int data) {
		 Node node=new Node();
		 node.data=data;
		 node.next=head;
		 node.prev=null;
		 
		 if(head!=null) {
			 head.prev=node;
		 }
		 
		 head=node;
		 
	 }
	 public void insert(int data) {
		 Node node=new Node();
		 node.data=data;
		 Node last=head;
		 node.next=null;
		 
		 if(head==null) {
			 node.prev=null;
			 head=node;
			 return;
		 }
		 while(last.next!=null) {
			 last=last.next;
		 }
		 last.next=node;
		 node.prev=last;
	 }
	 public void insertAt(int index,int data) {
		 Node node=new Node();
		 node.data=data;
		 node.next=null;
		 
		 if(index==0) {
			 insertFirst(data);
		 }
		 else {
			 Node n=head;
			 for(int i=0;i<index-1;i++) {
				 n=n.next;
			 }
			 node.next=n.next;
			 node.prev=n;
			 
			 if(n.next!=null) {
				 n.next.prev=node;
			 }
			 n.next=node;
			 
		 }
		 
	 }
	 public void delete(int index) {
		 if(index==0) {
			 head=head.next;
			 if(head!=null) {
				 head.prev=null;
			 }
		 }
		 else {
			 Node n=head;
			 Node n1=null;
			 
			 for(int i=0;i<index-1;i++) {
				 n=n.next;
			 }
			 n1=n.next;
			 n.next=n1.next;
			 
			 if(n.next!=null) {
				 n1.next.prev=n;
			 }
			 
		 }
	 }
	 public void show() {
		 Node node=head;
		 Node last=null;
		 while(node!=null) {
			 System.out.print(node.data+"->");
			 last=node;
			 node=node.next;
		 }
		 System.out.print("end");
		 System.out.println();
		
		 System.out.println("print in reverse");
		 while(last!=null) {
			 System.out.print(last.data+" -> ");
			 last=last.prev;
		 }
		 System.out.print("Start");
	 }
	 
	 
	
}
