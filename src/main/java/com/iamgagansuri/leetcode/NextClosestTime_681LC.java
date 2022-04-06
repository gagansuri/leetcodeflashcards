package com.iamgagansuri.leetcode;

import java.util.*;
/*

Next Closest Time
Problem:
Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example 1:

Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
Example 2:

Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
asdf.jpg

Solution 1:
We can try to increase the minute and the hour one by one. If all these four digits of the next time is in hashset, we find it and output! because these four digits are all reused.
 */
public class NextClosestTime_681LC
{
  public static void main(String[] args)
  {
    String time ="19:34";
    System.out.println(" next closeset time : "+nextClosestTime(time) +" ");
  }
  public static String nextClosestTime(String time)
  {
    //convert time to minutes
    ///e.g 19:34

    int minutes = Integer.parseInt(time.substring(0,2))*60 + Integer.parseInt(time.substring(3));
    Set<Integer> digitsSet=new HashSet<>();
    for(char c : time.toCharArray())
    {
      digitsSet.add(c - '0');
    }

    while(true) {
      minutes++;
      minutes=minutes%(24*60);
      int digit1=minutes/60/10;
      int digit2= minutes/60%10;

      int digit3=minutes%60/10;
      int digit4=minutes%60%10;

      if(digitsSet.contains(digit1) &&
              digitsSet.contains(digit2) &&
              digitsSet.contains(digit3) &&
              digitsSet.contains(digit4)) {
        //found

        return digit1+""+digit2+":"+digit3+""+digit4;
      }
    }
  }
  }

