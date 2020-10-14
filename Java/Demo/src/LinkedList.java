
public class LinkedList {
	
	Node head;
	LinkedList list;
	
	static class Node {
		int data;
		Node next;
		Node () {
			super();
		}
		
		Node (int d) {
			this.data=d;
			this.next=null;
			//this.list=null;
		}
	}
	
	public void push(int i) {
		
		list.head=new Node();
		list.head.next=new Node(i);
	}
	
	public static void main(String[] args) {
		
	}
	
	
	
	

}
