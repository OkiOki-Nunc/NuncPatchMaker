import java.io.File;
import java.io.InputStream;

public class CopyFile {
  public static void copyfile(String srFile, String dtFile) {
    try {
      if (srFile.equals(dtFile)) {
        return;
      }
      
      File f1 = new File(srFile);
      File f2 = new File(dtFile);
      InputStream in = new FileInputStream(f1);




      
      OutputStream out = new FileOutputStream(f2);
      
      byte[] buf = new byte[1024];
      int len;
      while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
      }
      in.close();
      out.close();
      System.out.println("File copied.");
    }
    catch (FileNotFoundException ex) {
      System.out.println(String.valueOf(ex.getMessage()) + " in the specified directory.");
      System.exit(0);
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    } 
  }
}