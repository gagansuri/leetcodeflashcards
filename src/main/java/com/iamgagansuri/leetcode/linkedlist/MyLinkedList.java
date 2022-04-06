package com.iamgagansuri.leetcode.linkedlist;

public class MyLinkedList {
  Node head=null;
  int length=0;
  class Node{
    int data;
    Node next=null;
    Node(int data) {
      this.data=data;
    }
  }
  public MyLinkedList() {

  }

  public int get(int index) {
    if(length>index) return -1;

    int count=0;
    Node temp = head;
    while(count<index && temp.next!=null) {
      temp=temp.next;
      count++;
    }

    if(temp!=null) {
      return temp.data;
    } else {
      return -1;
    }
  }

  public void addAtHead(int val) {
    if(head==null) {
      head=new Node(val);
    } else {
      Node node = new Node(val);
      node.next=head;
      head=node;
    }
    length++;
  }

  public void addAtTail(int val) {

    if(head==null) {
      addAtHead(val);
    }
    Node temp = head;
    while(temp.next!=null) {
      temp=temp.next;
    }
    Node last=new Node(val);
    temp.next=last;
    length++;
  }

  public void addAtIndex(int index, int val) {
    int count=0;

    if(index==0) {
      Node node=new Node(val);
      node.next=head;
      head=node;
      return;
    }

    Node temp=head;
    while(count<index-1 && temp.next!=null) {
      temp=temp.next;
      count++;
    }

    if(count==index-1) {
      Node current=new Node(val);
      current.next=temp.next;
      temp.next=current;
    }
    length++;
  }

  public void deleteAtIndex(int index) {
    if(index>length) return;

    if (index==0) {
      head=head.next;
      length--;
      return;
    }

    Node temp = head;
    int count=0;
    while(count<index-1 && temp.next!=null) {
      temp = temp.next;
      count++;
    }

    if(count==index-1) {
      if(temp.next!=null)
      {
        temp.next = temp.next.next;
        length--;
      } else {
        temp=null;
        length--;
      }
    }

  }
}

/**id
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */