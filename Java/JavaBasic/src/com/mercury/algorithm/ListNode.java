package com.mercury.algorithm;

public class ListNode  {
	public int val;
	public ListNode next;
	
	
	public ListNode (int val) {
		this.val=val;
	}
	



	public void addNode(ListNode n) {
		this.next=n;
	}
	
	public void print(ListNode l) {
		
		System.out.print("[");
		
		while(l!=null) {
			System.out.print(l.val);
			l=l.next;
			if(l!=null) {
				System.out.print(",");
			} else {
				System.out.print("]");
				System.out.println();
			}
		}
		
	}

}
