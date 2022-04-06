package com.iamgagansuri.leetcode.problems;
import java.util.*;



/*

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.



Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
Example 2:

Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both s and t become "".
Example 3:

Input: s = "a##c", t = "#a#c"
Output: true
Explanation: Both s and t become "c".
Example 4:

Input: s = "a#c", t = "b"
Output: false
Explanation: s becomes "c" while t becomes "b".
 */
public class BackspaceStringCompare_LeetCode_844
{
  public boolean backspaceCompare(String S, String T) {


    S=getTrimmedString(S);
    T=getTrimmedString(T);
    if(S.length()==T.length()) {
      return S.equals(T);
    }   else {
      return false;
    }


  }


  String getTrimmedString(String S ) {
    Stack<Character> stack=new Stack<>();

    for(char c : S.toCharArray()) {
      if(c!='#') {
        stack.push(c);

      } else if(!stack.isEmpty()) {
        stack.pop();
      }
    }

    StringBuilder sb  = new StringBuilder();
    while(!stack.isEmpty()) {
      sb.append(stack.pop());
    }
    // System.out.println(S + " became : "+sb);
    return sb.toString();
  }


  public static boolean backspaceCompare2(String S, String T) {

    int p1=S.length()-1;int p2=T.length()-1;

    while(p1>=0 && p2>=0) {
      char s=S.charAt(p1);
      char t=T.charAt(p2);
      if(s!='#' && t!='#') {
        if(s!=t) {
          return false;
        } else {
          p1--;p2--;
        }
      } else {
        int p1HashCount=0;
        while(p1>=0 && S.charAt(p1)=='#') {
          p1--;
          p1HashCount++;
        }
        int p2HashCount=0;
        while(p2>=0 && T.charAt(p2)=='#') {
          p2--;
          p2HashCount++;
        }
// check if there is a # between p1 and p1Hashcount then include that aswel
        p1=p1-p1HashCount;
        p2=p2-p2HashCount;
      }

    }

    return p1==p2;


  }

  public static void main(String[] args)
  {
    String s="xywrrmp";
    String t="xywrrm#p";
    s="bxj##tw";
    t="bxo#j##tw";
    System.out.println(backspaceCompare2(s,t));
  }
}