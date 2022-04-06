package com.iamgagansuri.leetcode.problems;

import java.util.HashSet;
import java.util.Set;

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
 */
public class NextClosestTime_681
{
  public static void main(String[] args)
  {

    System.out.println(findNextTime());

  }


  static String findNextTime(){
    String time="19:34";
    time="23:59";
    Set<Integer> lookupKeySet=new HashSet<>();

    for(char c: time.toCharArray()) {
      if(c!=':') {
        lookupKeySet.add(c-'0');
      }
    }

    int minutes=Integer.parseInt(time.split(":")[1]);
    int hours=Integer.parseInt(time.split(":")[0]);

    while(true) {
      minutes++;
      if(minutes==61) {
        minutes=minutes%60;
        hours=++hours%24;
      }

      String timeNew=(hours<10?"0"+hours:hours)+":"+(minutes<10?"0"+minutes:minutes);
      boolean found=true;
      for(char c :timeNew.toCharArray()) {
        if(c!=':')
        {
          int c1 = c - '0';
          if (!lookupKeySet.contains(c1))
          {
            found = false;
            break;
          }
        }
        }
      if(found) {
        return timeNew;
      }
    }
  }
}
