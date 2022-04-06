package com.iamgagansuri.leetcode.linkedlist;

public class MyLinkedListClient
{

  public static void main(String[] args)
  {
    MyLinkedList myLinkedList=new MyLinkedList();
    /*
    ["MyLinkedList","addAtHead 7","addAtTail 7","addAtHead 9","addAtTail 8","addAtHead 6 ","addAtHead 0 ","get 5",

    "addAtHead 0 ","get 2 ","get 5 ","addAtTail 4"]
[[],[7],[7],[9],[8],[6],[0],[5],[0],[2],[5],[4]]
     */
    /*
    myLinkedList.addAtHead(7);
    myLinkedList.addAtTail(7);

    myLinkedList.addAtHead(9);

    myLinkedList.addAtTail(8);
    myLinkedList.addAtHead(6);

    myLinkedList.addAtHead(0);

    System.out.println(myLinkedList.get(5));

    myLinkedList.addAtHead(0);

    System.out.println(myLinkedList.get(2));

    System.out.println(myLinkedList.get(5));

    myLinkedList.addAtTail(4);

     */

    myLinkedList.addAtHead(2);
    myLinkedList.deleteAtIndex(1);
  }
}
