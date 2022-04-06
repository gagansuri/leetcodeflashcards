package com.iamgagansuri.leetcode.topinterviewquestions.arrays;
import java.util.*;
public class ThreeSum
{

  public static void main(String[] args)
  {

  }


  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    //[-4,-1,-1,0,1,2]
    System.out.println(Arrays.toString(nums));

    for(int i =0;i<nums.length-2;i++) {
      int a = nums[i];
      while(i>0 && nums[i]==nums[i-1] && i < nums.length-2) {
        i++;
      }
      int left =i+1;
      int right = nums.length-1;
      //two sum
      while(left<right) {
        int sum=a+nums[left]+nums[right];
        if(sum==0) {
          List<Integer> interimRes=new ArrayList<>();
          interimRes.add(a);
          interimRes.add(nums[left]);
          interimRes.add(nums[right]);
          result.add(interimRes);
          while(left<nums.length-1 && nums[left]==nums[left+1]) {
            left++;
          }
          while(right>0 && nums[right]==nums[right-1]) {
            right--;
          }

          left++;
          right--;
        } else if(sum > 0 ) {
          right--;
        } else {
          left++;
        }
      }
    }


    return result;

  }
}
