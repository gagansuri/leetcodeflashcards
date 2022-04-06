package com.iamgagansuri.leetcode.topinterviewquestions.arrays;



public class BinarySearch
{

  public static void main(String[] args)
  {
    int[]   nums={1,2,3,4,5,6,7,8,9,10};
    int x=4;
    String result=findX(nums,x)?"passed":"failed";
    System.out.println("result: "+result);
  }


  static boolean findX(int [] arr,int x) {
    int begin=0,mid=(arr.length-begin)/2, end=arr.length;
    System.out.println("searching");
    while(begin<end) {
      if(x<arr[mid]) {
        //find between begin and mid
        end=mid;
          mid=begin+(end-begin)/2;

      } else if(x>arr[mid]) {
        //find between mid and end
        begin=mid;
        mid=begin+(end-begin)/2;
      } else if(x==arr[mid]) {
        return true;
      }

    }

    return false;

  }
}
