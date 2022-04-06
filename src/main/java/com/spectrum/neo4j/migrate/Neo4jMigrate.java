package com.spectrum.neo4j.migrate;

//package com.pb.spectrum.common.upgrade.database.neo4j;

import java.io.*;
import java.nio.file.*;
import java.util.Comparator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Neo4jMigrate
{
  public static void main(String[] args)
  {
    // 1. source path where neo4j zip file is repository_43
    // 2. from unzipped folder repository_43 go to bin and run the command
    // 3. ./neo4j-admin copy sourcepath and
    // 4. from the repository_43/logs open the log file and read the index logs inside a String list
    // 5. start ./neo4j console
    // 6. connect to database and run the commands to create indexes
    // 7. stop the database
    // 8. rename the original folder containing the database version 3.5
    // 9. rename the new database folder to repository
    // 10.
    try
    {
      String neo4j35RepositoryPath = "/Users/ga001su/Spectrum_Precisely/Neo4j_Migrate/3.5/repository";
      String neo4j43ZipPath = "/Users/ga001su/Spectrum_Precisely/Neo4j_Migrate/4.3/repository_4.3.zip";
      migrate(neo4j35RepositoryPath, neo4j43ZipPath);
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new RuntimeException("Failed run neo4j migration.");
    }
  }

  private static void migrate(String neo4j35RepositoryPath, String neo4j43ZipPath) throws Exception
  {
    //unzip neo4j 4.3 to this path
    String folderName="repository_4.3";
    //enable this
    //String neo4j43RepositoryFolderPath = unzip(neo4j43ZipPath);
    String neo4j43RepositoryFolderPath = "/Users/ga001su/Spectrum_Precisely/Neo4j_Migrate/4.3";

    // start the neo4j-admin copy command from neo4j43RepositoryFolderPath taking the bin path
    int result=runNeo4jAdminCopy(neo4j43RepositoryFolderPath+System.getProperty("file.separator")+folderName, neo4j35RepositoryPath);
    System.out.println("result of neo4j copy"+result);
    //Process neo4jDbCopy = startneo4jconsole(neo4j43RepositoryFolderPath);
    //int result = neo4jDbCopy.waitFor();
    //step 1 complete
    // step 2 extract index commands from the log
  }

  private static int runNeo4jAdminCopy(String neo4j4_3Folder, String neo4j3_5RepositoryFolder) throws Exception
  {
    //TODO : check for windows
    File neo4AdminCommand=new File(neo4j4_3Folder+System.getProperty("file.separator")+"bin"+System.getProperty("file.separator")+"neo4j-admin");
    neo4AdminCommand.setExecutable(true);
    String neo4jCommand = neo4j4_3Folder+System.getProperty("file.separator")+"bin"+System.getProperty("file.separator")+"neo4j-admin copy --from-path ";
    String neo4jDatabasePath =
            neo4j3_5RepositoryFolder + System.getProperty("file.separator") + "data" + System.getProperty("file.separator") + "databases"
                    + System.getProperty("file.separator") + "graphdb";
    String neo4jAdmincopyCommand = neo4jCommand + neo4jDatabasePath + " --to-database=graphdb";
    System.out.println("final  command :"+neo4jAdmincopyCommand);
    final Process process = Runtime.getRuntime().exec(neo4jAdmincopyCommand);
    new Thread(new Runnable() {
      public void run() {
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line = null;

        try {
          while ((line = input.readLine()) != null)
            System.out.println(line);
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }).start();
    int exitValue=process.waitFor();
    if(exitValue==0) {
      System.out.println("successfuly migrated the database");
    } else {
      System.out.println("not able to migrate neo4j database");
    }
    return exitValue;
  }

  private static Process startneo4jconsole(String folderPath) throws Exception
  {
    String neo4jCommand = "./neo4j console";
    String binPath = folderPath + System.getProperty("file.separator") + "bin" + System.getProperty("file.separator") + neo4jCommand;
    Runtime rt = Runtime.getRuntime();
    Process process = rt.exec("binPath");
    return process;
  }

  private static String unzip(String zipFilePath) throws Exception
  {
    File neo4j43ZipFile = new File(zipFilePath);
    String unzipFolder = neo4j43ZipFile.getParentFile().toString();//+ System.getProperty("file.separator") + folderName;
    cleanDirectory(unzipFolder);
    System.out.println(neo4j43ZipFile.getParentFile());
    //String neo4j43FolderPath=zipFilePath.substring(0,zipFilePath.lastIndexOf())
    //Step 1 : Create destination path from the given destFilePath
    File unzipDirectory = new File(unzipFolder);

    Path destination = Paths.get(unzipFolder).normalize();
    FileInputStream fis = new FileInputStream(neo4j43ZipFile);
    ZipInputStream zis = new ZipInputStream(fis);

    ZipEntry zipEntry = zis.getNextEntry();
    while (zipEntry != null)
    {
      Path path = destination.resolve(zipEntry.getName()).normalize();
      if (!path.startsWith(destination))
      {
        System.out.println("Invalid Zip Entry");
      }
      if (zipEntry.isDirectory())
      {
        Files.createDirectory(path);
      }
      else
      {
        BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(path));
        byte[] bytes = new byte[1024];
        while (zis.read(bytes) >= 0)
        {
          bos.write(bytes, 0, bytes.length);
        }
        bos.close();
      }
      zis.closeEntry();
      zipEntry = zis.getNextEntry();
    }
    zis.close();
    fis.close();
    return unzipFolder;
  }

  private static void cleanDirectory(String unzipPath) throws Exception
  {
    File directory = new File(unzipPath);
    if (!directory.exists())
    {
      directory.mkdir();
    }
   /* else
    {
      Files.walk(directory.toPath())
              .sorted(Comparator.reverseOrder())
              .filter(s->!s.endsWith(".zip"))
              .map(Path::toFile)
              .forEach(File::delete);
    }*/
  }
}
