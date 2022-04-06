package com.iamgagansuri.usefulcode;

public class CrashJVMCode{
//"public class ThreadLimitChecker{
public static void main(String[] args)
{
  int count = 0;
  while (true)
  {
    count++;
    new Thread(new Runnable()
    {
      public void run()
      {
        try
        {
          Thread.sleep(10000000);
        }
        catch (InterruptedException e)
        {
        }
      }
    }).start();
    System.out.println("Thread #:" + count);
  }
}
}

       // Read more: https://www.java67.com/2016/10/javalangoutofmemoryerror-unable-to-create-new-native-thread-in-java-solution.html#ixzz7DBgrprc5"