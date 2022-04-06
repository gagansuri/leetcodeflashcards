package com.iamgagansuri.leetcode.problems;

import java.util.*;

public class MostCommonWord_819
{
  public static void main(String[] args)
  {
    String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    String[] banned = new String[]{"hit"};

    new MostCommonWord_819().mostCommonWord(paragraph, banned);
  }

  public String mostCommonWord(String paragraph, String[] banned)
  {
    Map<String, Integer> wordCountMap = new HashMap<>();
    int max = 0, index = 0;
    Set<String> bannedSet = new HashSet<>();
    for (String word : banned)
    {
      bannedSet.add(word);

    }
    String[] cleanedInput = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");
    for (int i = 0; i < cleanedInput.length; i++)
    {
      String cWord = cleanedInput[i];
      if (bannedSet.contains(cWord)) continue;

      wordCountMap.put(cWord, wordCountMap.getOrDefault(cWord, 0) + 1);
      if (wordCountMap.get(cWord) > max)
      {
        max = wordCountMap.get(cWord);
        index = i;
      }

    }
    return cleanedInput[index];

  }
}
