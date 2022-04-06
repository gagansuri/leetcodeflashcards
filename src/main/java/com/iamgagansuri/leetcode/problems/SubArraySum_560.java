package com.iamgagansuri.leetcode.problems;

/*

Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.



Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Constraints:

1 <= nums.length <= 2 * 104
-1000 <= nums[i] <= 1000
-107 <= k <= 107


 */
import java.util.*;

public class SubArraySum_560
{
//Input: nums = [1,2,3], k = 3
  public int subarraySum(int[] nums, int k) {
    int sum=0;
    int res=0;
    Map<Integer,Integer> sumMap=new HashMap<>();
    sumMap.put(0,1);
    for(int i =0;i<nums.length;i++) {
      sum+=nums[i];
      if(sum==k) {
        res++;
      }
      sumMap.put(sum,i);

      if(sumMap.containsKey(sum-k)) {
        res++;
      }

    }

  return res;
  }


  public static int subArrar(int[] nums, int k) {
    HashMap <Integer, Integer> previousSum = new HashMap<>();
    int res = 0;
    int currentSum = 0;
    int n=nums.length;

    for (int i = 0; i < n; i++) {
      currentSum += nums[i];
      if (currentSum == k)
        res++;

      if (previousSum.containsKey(currentSum - k))
        res += previousSum.get(currentSum - k);

      Integer count = previousSum.get(currentSum);

      if (count == null)
        previousSum.put(currentSum, 1);
      else
        previousSum.put(currentSum, count+1);


      /*System.out.println("nums[i] :"+nums[i] + " currentSum :"+currentSum + " previousSum : "+previousSum +" res :"+res +" currentSum : "+currentSum);*/
    }

    return res;

  }

  public static void main(String[] args)
  {
    int[] nums={1,-1,1,1,1,1};
    int k=3;
    int res=subArrar(nums,k);
    System.out.println("res:"+res);

    List<Integer> res1=new ArrayList<>();

  }
}

