package com.iamgagansuri.usefulcode;

public class MaximumSubArray_leetcode53
{

  public static void main(String[] args)
  {
    int nums[]={-2,1,-3,4,-1,2,1,-5,4};

    System.out.println(maxSum(nums));
  }

 static  int maxSum(int[] nums) {
  int localMax=0;
  int globalMax=Integer.MIN_VALUE;

  for(int i=0;i<nums.length;i++) {
    localMax=Math.max(nums[i],nums[i]+localMax);

    if(localMax>globalMax) {
      globalMax=localMax;
    }

  }
  return globalMax;
  }


}
