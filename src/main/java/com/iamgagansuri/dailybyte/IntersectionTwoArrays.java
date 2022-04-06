package com.iamgagansuri.dailybyte;

import java.util.*;

public class IntersectionTwoArrays
{

  public static void main(String[] args)
  {
    int[]nums1 = {2, 4, 4, 2} ;
    int nums2[] = {2, 4};
    System.out.println(findIntersection(nums1,nums2));
    //return [2, 4]
    int[] nums3 = {1, 2, 3, 3};int nums4[] = {3, 3};
    //, return [3]
     System.out.println(findIntersection(nums3,nums4));
    int[] nums5 = {2, 4, 6, 8}; int nums6[] = {1, 3, 5, 7};
    //, return []

     System.out.println(findIntersection(nums5,nums6));


  }



 static  Integer[] findIntersection(int a[],int b[])
  {
    Set<Integer> firstLook = new HashSet<>();
    for (int i = 0; i < a.length; i++)
    {
      firstLook.add(a[i]);
    }
    Set<Integer> intersection = new HashSet<>();
    for (int i = 0; i < b.length; i++)
    {
      if (firstLook.contains(b[i]))
      {
        intersection.add(b[i]);
      }
    }
    Integer[] array = new Integer[intersection.size()];
    //Converting Set object to integer array
    intersection.toArray(array);
    return array;
  }
}
