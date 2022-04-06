package com.iamgagansuri.study.java8;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;
public class Java8Featues
{

  public static void main(String[] args)
  {
    List<String> lsit=Stream.of(1,2,3,4,5).map(a->a+"x").collect(Collectors.toList());

  }
}
