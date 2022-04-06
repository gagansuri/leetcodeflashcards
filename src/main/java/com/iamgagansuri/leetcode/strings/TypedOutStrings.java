package com.iamgagansuri.leetcode.strings;

import java.util.Stack;

public class TypedOutStrings
{

  public static void main(String[] args)
  {
    String s = "ab#z",t="az#z";
    System.out.println("true :"+typedOutStringCompare(s,t));
    System.out.println("false :"+typedOutStringCompare("abc#d","acc#c"));
    System.out.println("true :"+typedOutStringCompare("a###b","b"));
  }


  static boolean typedOutStringCompareOptimized(String s ,String t)
  {
  //using two pointer

   boolean result=false;

   //start from the end of the strings
    int sPointer=s.length()-1,tPointer=t.length()-1;

    while(sPointer >=0 && tPointer>0) {
      if(s.charAt(sPointer)!='#' && t.charAt(tPointer)!='#') {

      }


    }
return true;
  }
  static boolean typedOutStringCompare(String s ,String t) {
    int hasCount=0;
    s = getCharacters(s);
    t= getCharacters(t);
    System.out.println("S -> "+s +" \n t ->"+t);
    return s.equals(t);


  }

  private static String getCharacters(String s)
  {
    Stack<Character> stack=new Stack<>();
    for(int i = 0; i< s.length(); i++) {
      if(s.charAt(i)!='#') {
        stack.push(s.charAt(i));
      } else if(!stack.isEmpty()) {
        stack.pop();
      }
    }
    String finalString="";
    for(char c : stack) {
      finalString+=c;
    }

    return finalString;
  }

}
