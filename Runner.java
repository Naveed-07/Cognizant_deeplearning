package Double.LL;

import LinkedList.LinkedList;

public class Runner {

	public static void main(String[] args) {
		
		DoubleLL list=new DoubleLL();
		list.insert(5);
		list.insert(4);
		list.insert(9);
		list.insertFirst(44);
		list.insertAt(2, 56);
		list.delete(3);
		
		
		list.show();
	}
}


