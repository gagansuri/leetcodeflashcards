package com.iamgagansuri.usefulcode;

import java.io.*;
import java.util.*;
import java.util.zip.*;

public class ZipMultipleFiles
{


    public static void main(String[] args) throws IOException
    {
      List<String> srcFiles = Arrays.asList("/Users/ga001su/Spectrum_Precisely/dq-core/products/standardization/runtime/src/test/resources/cdq-standardization/cdq-Standardization-base.db"
              , "/Users/ga001su/Spectrum_Precisely/dq-core/products/standardization/runtime/src/test/resources/cdq-standardization/cdq-Standardization-base.lg");
      FileOutputStream fos = new FileOutputStream("/Users/ga001su/Spectrum_Precisely/dq-core/products/standardization/runtime/src/test/resources/cdq-standardization/test.zip");
      ZipOutputStream zipOut = new ZipOutputStream(fos);
      for (String srcFile : srcFiles) {
        File fileToZip = new File(srcFile);
        FileInputStream fis = new FileInputStream(fileToZip);
        ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
        zipOut.putNextEntry(zipEntry);

        byte[] bytes = new byte[1024];
        int length;
        while((length = fis.read(bytes)) >= 0) {
          zipOut.write(bytes, 0, length);
        }
        fis.close();
      }
      zipOut.close();
      fos.close();
    }


}
