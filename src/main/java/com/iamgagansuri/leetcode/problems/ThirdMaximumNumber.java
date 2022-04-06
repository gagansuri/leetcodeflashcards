package com.iamgagansuri.leetcode.problems;

import org.neo4j.cypher.internal.expressions.In;

import java.util.*;
public class ThirdMaximumNumber
{
  public static void main(String[] args)
  {
    ThirdMaximumNumber thirdMaximumNumber=new ThirdMaximumNumber();
    thirdMaximumNumber.thirdMax(new int[]{1,1,-2147483648});
  }
  public void thirdMax(int[] nums)
  {

    Set<Integer> numSet=new HashSet<>();
    for(int n:nums) {
      numSet.add(n);
    }

    List<Integer> numList=new ArrayList<>(numSet);
    Collections.sort(numList, new Comparator<Integer>()
    {
      @Override
      public int compare(Integer o1, Integer o2)
      {
        if (o1.intValue() < o2.intValue())
        {
          return 1;
        }
        else if (o1.intValue() == o2.intValue())
        {
          return 0;
        }
         return -1;
      }
    });
    numList.stream().forEach(System.out::println);

  }

}
