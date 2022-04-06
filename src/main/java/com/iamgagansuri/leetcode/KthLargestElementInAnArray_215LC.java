package com.iamgagansuri.leetcode;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215LC
{

  public int findKthLargest(int[] nums, int k ) {
    PriorityQueue<Integer> minHeap=new PriorityQueue<>();

    for(int n : nums) {
      minHeap.add(n);
      System.out.println(minHeap);

      if(minHeap.size()>k) {
        int removed=minHeap.remove();
        System.out.println("removed : "+removed);
      }

    }

    return minHeap.remove();

  }

  public static void main(String[] args)
  {
    int[] nums = {3,2,1,5,6,4};int k = 2;
    KthLargestElementInAnArray_215LC obj = new KthLargestElementInAnArray_215LC();
    int result=obj.findKthLargest(nums,k);
    System.out.println("expected : 5 " + " obtainer : "+result + " test "+(result==5?"successfil":"failed"));
  }
}
