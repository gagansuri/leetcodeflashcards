package com.iamgagansuri.leetcode.topinterviewquestions.arrays;

public class RemoveDuplicatesFromSortedArray
{
  public static void main(String[] args)
  {
    int[] nums=new int[]{1,1,1,2,2,2,3,4,5,6,7};
    //nums=new int[]{1,1,2};
    removeDuplicates(nums);

  }
  public static int removeDuplicates(int[] nums) {
    int index=0;
    int i=0;
    while(i<nums.length-1) {
      while(nums[i]==nums[i+1]) {
        i++;
      }
      nums[index++]=nums[i++];
    }
    return index;
  }
}
