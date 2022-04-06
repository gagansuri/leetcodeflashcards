package com.iamgagansuri.stanford;

public class RecursivePermutationString
{

  public static void main(String[] args)
  {
    String s="abcd";
    printPermutation(s);
  }



  static void printPermutation(String s) {
    printRecursive("",s);
  }

  static void printRecursive(String soFar,String rest) {
    if(rest.equals("")) {
      System.out.println(soFar);
    } else {

      for(int i =0;i<rest.length();i++) {
        String next=soFar+ rest.charAt(i);
        String remaining = rest.substring(1,rest.length());
        printRecursive(next,remaining);
      }
    }
  }
}
