import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Pozeni
  extends windowNunc
{
  public void createPozeni(String path, String patchName) {
    System.out.println("createPozeni() " + path);
    String pozeni = "";
    this.folder = new File(path);
    files = this.folder.listFiles();
    filenames = new String[files.length];
    int files_exist = 0;
    
    pozeni = String.valueOf(pozeni) + "-- Created by NuncPatcher" + newLine;
    pozeni = String.valueOf(pozeni) + newLine;
    
    pozeni = String.valueOf(pozeni) + "SPOOL \"" + patchName + ".lst\"" + newLine;
    pozeni = String.valueOf(pozeni) + newLine;
    
    System.out.println("filenames: ");
    
    int i;
    for (i = 0; i < files.length; i++) {
      if (files[i].isFile()) {
        System.out.println("getExtension(files[i])==.pks " + getExtension(files[i]));
        if (getExtension(files[i]).equals("pks")) {
          filenames[i] = files[i].getName();
          pozeni = String.valueOf(pozeni) + "Prompt " + filenames[i] + newLine;
          pozeni = String.valueOf(pozeni) + "@@" + filenames[i] + newLine;
          System.out.println("f: " + filenames[i]);
          files_exist++;
        } 
      } 
    } 

    
    for (i = 0; i < files.length; i++) {
      if (files[i].isFile()) {
        System.out.println("getExtension(files[i])==.pkb " + getExtension(files[i]));
        if (getExtension(files[i]).equals("pkb")) {
          filenames[i] = files[i].getName();
          pozeni = String.valueOf(pozeni) + "Prompt " + filenames[i] + newLine;
          pozeni = String.valueOf(pozeni) + "@@" + filenames[i] + newLine;
          System.out.println("f: " + filenames[i]);
          files_exist++;
        } 
      } 
    } 

    
    for (i = 0; i < files.length; i++) {
      if (files[i].isFile() && (
        getExtension(files[i]).equals("sql") || getExtension(files[i]).equals("trg"))) {
        filenames[i] = files[i].getName();
        pozeni = String.valueOf(pozeni) + "Prompt " + filenames[i] + newLine;
        pozeni = String.valueOf(pozeni) + "@@" + filenames[i] + newLine;
        System.out.println("f: " + filenames[i]);
        files_exist++;
      } 
    } 

    
    pozeni = String.valueOf(pozeni) + newLine;
    pozeni = String.valueOf(pozeni) + "SPOOL OFF";
    
    if (files_exist > 0) {
      WriteTextFile.create(String.valueOf(path) + "\\pozeni.sql", pozeni);
    }
  }



  
  public void createPozeni1(String path) {
    String pozeni1 = "";
    System.out.println("path " + path);
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(String.valueOf(path) + "\\pozeni.sql"));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } 
    String line = null;
    try {
      line = br.readLine();
    } catch (IOException e) {
      
      e.printStackTrace();
    } 
    while (line != null) {
      
      System.out.println(line);
      pozeni1 = String.valueOf(pozeni1) + line + windowNunc.newLine;
      try {
        line = br.readLine();
      } catch (IOException e) {
        
        e.printStackTrace();
      } 
    } 








    
    Alter_invalid_skr alterInvalid = new Alter_invalid_skr();
    alterInvalid.create();
    
    pozeni1 = String.valueOf(pozeni1) + windowNunc.newLine;
    
    pozeni1 = String.valueOf(pozeni1) + "@\"" + windowNunc.path + "\\alter_invalid1.skr\"" + windowNunc.newLine;
    
    pozeni1 = String.valueOf(pozeni1) + "@\"" + windowNunc.path + "\\alter_invalid.sql\"" + windowNunc.newLine;
    pozeni1 = String.valueOf(pozeni1) + windowNunc.newLine;
    pozeni1 = String.valueOf(pozeni1) + "exit" + windowNunc.newLine;
    System.out.println("pozeni1: " + pozeni1);
    
    WriteTextFile.create(String.valueOf(path) + "\\pozeni1.sql", pozeni1);
  }
}
