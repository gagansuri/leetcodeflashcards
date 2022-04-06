package com.iamgagansuri.leetcode.problems;

public class BinarySearch1Iterative
{

  public static void main(String[] args)
  {
    int[] nums={1,2,3,7,9,11,15,17};
    System.out.println(search(nums,1) + " testcase passed : if 0 ");
    System.out.println(search(nums,17) +" test case passed if 7");
    System.out.println(search(nums,9)+" test case passed if 4");
    System.out.println(search(nums,13)+" test case passed if -1");
    System.out.println(search(nums,19)+" test case passed if -1");


    System.out.println(search(new int[]{},19)+" test case passed if -1");

  }


  static int search(int[] nums,int target) {

    if(nums==null || nums.length==0) return -1;
    int low=0,high=nums.length-1;

    while(low<=high) {
      int mid=low+(high-low)/2;

      if(target==nums[mid])  {
        return mid;
      } else if(target > nums[mid]) {
        low=mid+1;
      } else {
        high=mid-1;
      }


    }
    return -1;
  }
}
