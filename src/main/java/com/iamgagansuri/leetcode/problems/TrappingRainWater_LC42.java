package com.iamgagansuri.leetcode.problems;

import java.util.*;

public class TrappingRainWater_LC42
{

  public static void main(String[] args)
  {
    int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trap(height));
    System.out.println(findMinMax(height));
  }

  public static int trap(int[] height)
  {

    int totalWater = 0;

    for (int i = 0; i < height.length; i++)
    {
      int n = height[i];

      //find max left and max right
      int maxLeft = 0;
      int maxRight = 0;
      for (int j = 0; j < height.length; j++)
      {
        if (j < i)
        {
          if (height[j] > maxLeft)
          {
            maxLeft = height[j];
          }
        }
        else if (j > i)
        {
          if (height[j] > maxRight)
          {
            maxRight = height[j];
          }

        }

      }

      System.out.println(" maximum left :" + maxLeft + " maximum right : " + maxRight);
      System.out.println("water at i=" + i + "th location : " + (Math.min(maxLeft, maxRight) - n));
      int water = Math.max(0, (Math.min(maxLeft, maxRight) - n));
      totalWater += water;
    }

    return totalWater;

  }

  private static int findMinMax(int[] height)
  {
    Map<Integer, Integer> maxMapLeft = new HashMap<>();
    Map<Integer, Integer> maxMapRight = new HashMap<>();
    int total = 0;
    int max = 0;
    for (int i = 0; i < height.length; i++)
    {
      maxMapLeft.put(i, max);
      max = Math.max(height[i], max);
    }

    max = 0;
    for (int i = height.length - 1; i >= 0; i--)
    {
      maxMapRight.put(i, max);
      max = Math.max(height[i], max);
    }

    for (int i = 0; i < height.length; i++)
    {
      int n = height[i];
      int water = Math.max(Math.min(maxMapLeft.get(i), maxMapRight.get(i)) - n, 0);
      total += water;
    }
    System.out.println(total);
    return total;
  }

  static int bothAtTheSameTime(int[] height)
  {
    Map<Integer, Integer> maxMapLeft = new HashMap<>();
    Map<Integer, Integer> maxMapRight = new HashMap<>();
    int total = 0;
    int maxL = 0;
    int maxR = 0;
    int len = height.length;
    for (int i = 0; i < height.length; i++)
    {
      maxMapLeft.put(i, maxL);
      maxL = Math.max(height[i], maxL);

      maxMapRight.put(len - 1 - i, maxR);
      maxR = Math.max(height[len - i - 1], maxR);
    }
    for (int i = 0; i < height.length; i++)
    {
      int n = height[i];
      int water = Math.max(Math.min(maxMapLeft.get(i), maxMapRight.get(i)) - n, 0);
      total += water;
    }
    System.out.println(total);
    return total;
  }

  private static int trapTwoPointer(int[] height)
  {
    int left = 0, right = height.length - 1, maxLeft = 0, maxRight = 0, total = 0;

    while (left < right)
    {

      //check whether to move left or right. whichever is smaller needs to move
      if (height[left] < height[right])
      {
        // check if left is less than equal to maxLeft if it is then it can hold water and not otherwise
        if (height[left] <= maxLeft)
        {
          total += maxLeft - height[left];
        }
        else
        {
          maxLeft = height[left];
        }
        left++;
      }
      else
      {
        // means we have to move right pointter
        if (height[right] <= maxRight)
        {
          total += maxRight - height[right];
        }
        else
        {
          maxRight = height[right];
        }
        right--;
      }
    }
    return total;

  }

}




