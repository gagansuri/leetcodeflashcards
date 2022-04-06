package com.iamgagansuri.leetcode.topinterviewquestions.arrays;

public class Leetcode125_ValidPalindrome
{

  /*

  A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
Accepted
1,063,709
Submissions
2,641,372

   */

  public boolean isPalindrome1(String s) {

    s=s.replaceAll("^[a-zA-z]","");
    int start=0,end=s.length()-1;
    System.out.println("s->"+s);
    while(start<end) {
      if(s.charAt(start++) != s.charAt(end--)) {
        return false;
      }

    }

    return true;
  }

  public static void main(String[] args)
  {
    Leetcode125_ValidPalindrome lc=new Leetcode125_ValidPalindrome();
    System.out.println(lc.isPalindrome("A man, a plan, a canal: Panama"));

  }


  public  boolean isPalindrome(String s) {
    //find valid character fromleft
    int i =0;int j = s.length()-1;


    while(i<j) {
      while(!Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }

      while(!Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      }

      if(Character.toLowerCase(s.charAt(i))!=Character.toLowerCase(s.charAt(j))) {
        return false;
      }

    }
    return true;
    //find valid character fromright


    //if not equal. return false
  }
}
