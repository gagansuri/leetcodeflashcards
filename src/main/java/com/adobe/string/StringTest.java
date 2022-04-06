package com.adobe.string;

public class StringTest
{
  public static void StringCheck(String[] args)
  {
    String s ="Hello";


    String s1= new String("Hello");

    String s2= "Hello";

    System.out.println("s==s1 :"+(s==s1) +"\n s==s2 :"+(s==s2));
  }

  public static void main(String[] args)
  {
    int i=7;
    int j = i>>2;
    System.out.println((j));
  }
}
