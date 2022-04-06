package com.iamgagansuri.usefulcode;

public class ReturnVsCallRecursive
{

  public int random(int c)
  {
    if(c > 10)
    {
      System.out.println("c is greater than 10");
      return random(c - 1);
    }
    System.out.println("multiplying c=" + c + " by 8");
    return c * 8;
  }


  public int random1(int c)
  {
    if(c > 10)
      random1(c - 1);
    return c * 8;
  }


  public static void main(String[] args)
  {
    ReturnVsCallRecursive rvcsr=new ReturnVsCallRecursive();

    System.out.println(rvcsr.random(11));

    System.out.println(rvcsr.random1(11));
  }

}
