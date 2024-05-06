import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipFiles
{
  String[] filenames;
  File[] files;
  byte[] buf = new byte[1024];


  
  public ZipFiles(String dirName, String fileName) {
    try {
      String outFilename = String.valueOf(dirName) + "\\" + fileName + ".zip";
      File outFile = new File(outFilename);
      System.out.println("Zip FileName " + outFilename);
      ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFilename));

      
      String path = dirName;
      System.out.println("path1 " + path);
      
      File folder = new File(path);
      this.files = folder.listFiles();
      this.filenames = new String[this.files.length];
      int i;
      for (i = 0; i < this.files.length; i++) {
        
        if (this.files[i].isFile()) {
          this.filenames[i] = this.files[i].getName();
          System.out.println("filenames in ZIP: " + this.filenames[i]);
        } 
      } 




      
      for (i = 0; i < this.files.length; i++) {
        if (this.files[i].isFile() && this.files[i].compareTo(outFile) != 0) {

          
          System.out.println("for FileInputStream: " + this.files[i].getPath());
          FileInputStream in = new FileInputStream(this.files[i].getPath());



          
          out.putNextEntry(new ZipEntry(this.files[i].getName()));


          
          int max = 0; int len;
          while ((len = in.read(this.buf)) > 0) {
            max++;



            
            out.write(this.buf, 0, len);
          } 

          
          out.closeEntry();
          in.close();
        } 
      } 

      
      out.close();
    } catch (IOException iOException) {}
  }


  
  public String FilesInZip(String s) {
    String zipEntryName = null;

    
    try {
      ZipFile zf = new ZipFile(s);

      
      for (Enumeration<? extends ZipEntry> entries = zf.entries(); entries.hasMoreElements();)
      {
        zipEntryName = String.valueOf(zipEntryName) + " " + ((ZipEntry)entries.nextElement()).getName();
      }
      zf.close();
    } catch (IOException iOException) {}
    
    return zipEntryName;
  }
}