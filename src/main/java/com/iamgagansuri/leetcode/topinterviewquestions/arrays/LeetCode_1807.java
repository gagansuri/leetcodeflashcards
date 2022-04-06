package com.iamgagansuri.leetcode.topinterviewquestions.arrays;

/**
 *
 * 1807. Evaluate the Bracket Pairs of a String
 * Medium
 *
 * 214
 *
 * 22
 *
 * Add to List
 *
 * Share
 * You are given a string s that contains some bracket pairs, with each pair containing a non-empty key.
 *
 * For example, in the string "(name)is(age)yearsold", there are two bracket pairs that contain the keys "name" and "age".
 * You know the values of a wide range of keys. This is represented by a 2D string array knowledge where each knowledge[i] = [keyi, valuei] indicates that key keyi has a value of valuei.
 *
 * You are tasked to evaluate all of the bracket pairs. When you evaluate a bracket pair that contains some key keyi, you will:
 *
 * Replace keyi and the bracket pair with the key's corresponding valuei.
 * If you do not know the value of the key, you will replace keyi and the bracket pair with a question mark "?" (without the quotation marks).
 * Each key will appear at most once in your knowledge. There will not be any nested brackets in s.
 *
 * Return the resulting string after evaluating all of the bracket pairs.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
 * Output: "bobistwoyearsold"
 * Explanation:
 * The key "name" has a value of "bob", so replace "(name)" with "bob".
 * The key "age" has a value of "two", so replace "(age)" with "two".
 * Example 2:
 *
 * Input: s = "hi(name)", knowledge = [["a","b"]]
 * Output: "hi?"
 * Explanation: As you do not know the value of the key "name", replace "(name)" with "?".
 * Example 3:
 *
 * Input: s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
 * Output: "yesyesyesaaa"
 * Explanation: The same key can appear multiple times.
 * The key "a" has a value of "yes", so replace all occurrences of "(a)" with "yes".
 * Notice that the "a"s not in a bracket pair are not evaluated.
 * Example 4:
 *
 * Input: s = "(a)(b)", knowledge = [["a","b"],["b","a"]]
 * Output: "ba"
 *
 */
import java.util.*;

public class LeetCode_1807
{

  public static void main(String[] args)
  {
    String s ="(name)is(age)yearsold";
    //[["name","bob"],["age","two"]]
    List<String> k1=new ArrayList<>();k1.add("name");k1.add("bob");
    List<String> k2=new ArrayList<>();k2.add("age");k2.add("two");
    List<List<String>> know=new ArrayList<>();know.add(k1);know.add(k2);


    String s2="hi(name)";
    //[["a","b"]]

    List<String> k3=new ArrayList<>();k3.add("a");k3.add("b");
    List<List<String>> know2=new ArrayList<>();know2.add(k3);
    new LeetCode_1807().evaluate(s2,know2);
  }


  public String evaluate(String s, List<List<String>> knowledge) {
    Map<String,String> lookupList=new HashMap<>();

    for(List<String> keyValList : knowledge) {
      lookupList.put(keyValList.get(0),keyValList.get(1));

    }
    String notFound=null;
    System.out.println(lookupList);
    StringBuilder out=new StringBuilder();
    for(int i =0;i<s.length();) {
      if(s.charAt(i)=='(') {
        int indexOfEndBrack=s.indexOf(')',i);
        if(indexOfEndBrack!=-1)
        {
          String key = s.substring(i+1, s.indexOf(')', i));
          i=indexOfEndBrack+1;
          if (lookupList.containsKey(key))
          {
            out.append(lookupList.get(key));
          }
          else
          {
            out.append("?");
          }
        } else {
          out.append(s.charAt(i++));
        }
      } else {
        out.append(s.charAt(i++));
      }
    }
    System.out.println(out.toString());
    return out.toString();
  }
}
