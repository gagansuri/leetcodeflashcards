package com.iamgagansuri.leetcode.topinterviewquestions.arrays;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MirrorBinaryTree {

  static int addNumbers(int a, int b) {
    return a+b;
  }

  static class Node{
    int data;
    public Node(int _d) {
      this.data=_d;
    }
    Node left=null;
    Node right=null;


  }
  public static void main(String[] args) {
        /*
          1
        2      3
      4   5   6. 7
      */

      /*
           1
       3.      2
      7. 6.  5.  4

      */


    Node root= new Node(1);

    Node fLeftChild=new Node(2);

    Node fRightChild=new Node(3);
    root.left=fLeftChild;
    root.right=fRightChild;

    Node secondLeftChild=new Node(4);
    Node secondRightChild=new Node(5);
    fLeftChild.left=secondLeftChild;
    fLeftChild.right=secondRightChild;


    Node secondRightLeftChild=new Node(6);
    Node secondRightRightChild=new Node(7);
    fRightChild.left=secondRightLeftChild;
    fRightChild.right=secondRightRightChild;




    //print(root);



    //Node mirrorNode= mirrorRec(root);
    //print(mirrorNode);

    //mirrorIterative(root);
    Node copyNode=copy(root);
    print(copyNode);
    mirrorIterative(copyNode);

    print(root);
    print(copyNode);

  }



  static Node mirrorRec(Node node) {
    if(node==null) return node;


    Node left= mirrorRec(node.left);
    Node right=mirrorRec(node.right);

    node.left=right;
    node.right=left;

    return node;

  }

  static Node mirrorIterative(Node node)
  {
    Node otherNode=node;

    if(node==null) return node;

    Queue<Node> queue=new LinkedList<>();

    queue.add(node);


    while(!queue.isEmpty()) {

      int length=queue.size();

      for(int i =0;i<length;i++) {
        Node n=queue.remove();
        System.out.print(" "+n.data+" ");
        Node temp=n.left;
        n.left=n.right;
        n.right=temp;
        if(n.left!=null) {
          queue.add(n.left);
        }

        if(n.right!=null) {
          queue.add(n.right);
        }

      }
      System.out.println();
    }

  return otherNode;
  }



  /*
  Implement a method that takes in a Node, which represents the head of a binary tree. The return of this method is also a node, that points to the binary tree that is the "mirrored" version of that tree ie.
     1   |   1
     /\   |   /\
    2  3  |  3 2
      /   |  \
     4    |   4
  */
  static void print(Node root) {
    if(root==null) return;

    Queue<Node> queue =new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()) {
      int length=queue.size();
      for(int i =0;i<length;i++) {
        Node n=queue.remove();
        System.out.print(n.data +"  ");
        if(n.left!=null) {
          queue.add(n.left);
        }

        if(n.right!=null) {
          queue.add(n.right);
        }
      }
      System.out.println("  ");

    }

    //  return null;
    //  Node mirror(Node root)


  }


  static Node copy(Node node)
  {
   // PriorityQueue<Integer> nums=new PriorityQueue<>();

//    nums.add
    if(node==null) return node;
    Node node1 =new Node(node.data);
    node1.left=copy(node.left);
    node1.right=copy(node.right);
    return node1;
  }


  public void   KthLargest(int k, int[] nums) {

  }
}

