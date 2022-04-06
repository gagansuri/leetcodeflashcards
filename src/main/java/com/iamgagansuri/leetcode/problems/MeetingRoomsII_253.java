package com.iamgagansuri.leetcode.problems;

import java.util.*;

public class MeetingRoomsII_253
{

  public static int minMetingRooms(Interval[]intervals) {
    if(intervals==null || intervals.length==0) {
      return 0;
    }
    int result=0;
    //sort by earliest start time
    Arrays.sort(intervals,(a,b)->a.start-b.start);
    //create a min heap by earliest end time
    PriorityQueue<Interval> minHeap= new PriorityQueue<>((a,b)->a.end-b.end);
    minHeap.add(intervals[0]);
    for(int i=1;i<intervals.length;i++)  {
      Interval currentInterval=intervals[i];
      Interval earliestEndingMeeting=minHeap.remove();
      if(currentInterval.start >= earliestEndingMeeting.end) {
        earliestEndingMeeting.end= currentInterval.end;
      } else {
        minHeap.add(currentInterval);
      }
       minHeap.add(earliestEndingMeeting);


    }

    return minHeap.size();
  }


  static class Interval{
    int start;
    int end;
    Interval(){start=0;end=0;}
    Interval(int s ,int e) {
      start=s;end=e;
    }

  }

  public static void main(String[] args)
  {
    Interval[] intervals=new Interval[] {
            new Interval(0,30),
            new Interval(5,10),
            new Interval(15,20)
    };

    System.out.println(minMetingRooms(intervals));
  }
}
