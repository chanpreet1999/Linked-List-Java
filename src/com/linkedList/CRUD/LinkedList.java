package com.linkedList.CRUD;

public class LinkedList {

	class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	Node start;
	
	LinkedList(){
		start=null;
	}
	
	//INSERT AT THE BEG OF THE LL
	void insertBeg(int data){
		start = insertBegInner(start,data);
	}
	private Node insertBegInner(Node start, int data) {
		if (start==null){
			return new Node(data);
		}
		Node new_node=new Node(data);
		new_node.data=data;
		new_node.next=start;
		start=new_node;
		return start;
	}
	
	
	
	//INSERT AT THE END
	void insertEnd(int data){
		start=insertEndInner(start,data);
	}
	private Node insertEndInner(Node start,int data) {
		if(start==null)
			return new Node(data);
		Node new_node=new Node(data);
		Node temp=start;
		while(temp.next!=null){
			temp=temp.next;
		}
		temp.next=new_node;
		new_node.next=null;
		return start;
	}
	
	
	//INSERT MID
	void insertMid(int data,int pos){
		if(pos==1){
			start=insertBegInner(start, data);
			return;
		}
		
		start=insertMidInner(start,data,pos);
	}
	private Node insertMidInner(Node start, int data, int pos) {
		if(start==null){
			System.out.println("Cannot insert at the desired position coz the list is already empty!! Inserting to the first position");
			return new Node(data);
		}
		
		Node temp=start;
		int count =1;
		while(count<pos){
			temp=temp.next;
			count++;
			if(temp==null){
				System.out.println("Insertion Failed! Not enough elements!! Adding it to the end");
				return insertEndInner(start, data);
			}
			
		}
		Node new_node=new Node(data);
		new_node.next=temp.next;
		temp.next=new_node;
		
		return start;
	}
	
	
	
	//DELETION FROM BEG
	void delBeg(){
		start=delBegInner(start);
	}	
	private Node delBegInner(Node start) {
		if(start==null){
			System.out.println("Linked List already empty");
			return null;
		}
		System.out.println("The Element deleted is:"+start.data);
		start=start.next;
		if(start==null)
			return null;
		
		return start;
	}

	//DISPLAY lINKED LIST
	void disp(){
		if(start==null){
			System.out.println("Linked List Empty");
			return;
		}
		Node temp=start;
		while(temp.next!=null){
			System.out.print(temp.data+"->");
			temp=temp.next;
		}
		//Just for display purpose
		System.out.println(temp.data);
	}
	
	//DISPLAY RECURSIVELY
	void dispInReverseWithoutReversing(){
		dispRec(start);
	}
	private void dispRec(Node start) {
		if(start==null)
			return;
		dispRec(start.next);
		System.out.print(start.data+" ");	 
	}
	
	
	
	public static void main(String[] args) {
		
		LinkedList linkedList=new LinkedList();
		//linkedList.disp();
		linkedList.insertBeg(6);
		linkedList.insertBeg(5);
		linkedList.insertBeg(4);
		linkedList.insertBeg(3);
		linkedList.insertBeg(2);
		linkedList.insertBeg(1);
		//1->2->3->4->5->6
		
		
		
		linkedList.dispInReverseWithoutReversing();//op //6->5->4->3->2->1
		
		System.out.println();
		
		linkedList.insertEnd(7);    //1->2->3->4->5->6->7
		linkedList.disp();
		
		//Insert after 8th position
		linkedList.insertMid(50, 8);
		System.out.println();
		linkedList.disp();
		
		linkedList.delBeg(); //deletes 1
		linkedList.disp();
	}

}
