package com.iamgagansuri.leetcode.topinterviewquestions.arrays;

public class FactorialWithEndingZeroes
{

  static int trailingZeroes(int N){
    // Write your code here
    long num=1;
    int count=0;
    for(int i =1;i<=N;i++) {
      num*=i;
      String numb=num+"";
      if(numb.charAt(numb.length()-1)=='0') {
        count++;
        num=num/10;
      }
    }
    return count;
  }

  public static void main(String[] args)
  {
    int n=5;
    System.out.println(trailingZeroes(384));
  }
}
