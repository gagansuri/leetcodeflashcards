package com.iamgagansuri.spectrum;
import java.util.*;
import java.io.*;

public class ReadfileBasedonExtension
{

  public static void main(String[] args)
  {
    File dir = new File("/Users/ga001su/Spectrum_Precisely/dq-core/services/artifact-repository-service/spring-boot/refdata/com/precisely/refdata/matching/tablemgt/standardization-1.0");
    File files = dir.listFiles((d, name) -> name.endsWith(".db"))[0];


  }
}
