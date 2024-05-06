import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecSysCommand
  implements Runnable
{
  String baza;
  String path;
  
  ExecSysCommand(String baza, String path) {
    this.baza = baza;
    this.path = path;
  }

  
  public void patch(String baza, String path) {
    try {
      windowNunc.patch.setEnabled(false);
      windowNunc.go.setEnabled(false);

      
      System.out.println("sqlplus.exe " + baza + " @\"" + path + "\\pozeni1.sql\"");
      Process p = Runtime.getRuntime().exec("sqlplus.exe " + baza + " @" + path + "\\pozeni1.sql");
      
      BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
      String line = reader.readLine();
      String log = new String("baza = " + baza + windowNunc.newLine);
      log = String.valueOf(log) + "Path = " + path + windowNunc.newLine;
      log = String.valueOf(log) + windowNunc.newLine;
      
      while (line != null) {
        
        System.out.println(line);
        windowNunc.appendLogTextArea(line);
        windowNunc.appendLogTextArea(windowNunc.newLine);

        
        log = String.valueOf(log) + line + windowNunc.newLine;
        line = reader.readLine();
      } 
      WriteTextFile.create(String.valueOf(path) + "\\" + getBase(baza) + ".log", log);
      System.out.println("Gotof si!");
    
    }
    catch (IOException iOException) {}

    
    windowNunc.patch.setEnabled(true);
    windowNunc.go.setEnabled(true);
    System.out.println("Done");
  }

  
  public static String getBase(String s) {
    String base = null;
    int i = s.lastIndexOf('@');
    
    if (i > 0 && i < s.length() - 1) {
      base = s.substring(i + 1).toLowerCase();
    }
    if (base == null) {
      return "";
    }
    return base;
  }

  
  public void run() {
    System.out.println("Runnable " + this.baza + " @ " + this.path);
    windowNunc.pozeniFile.createPozeni1(this.path);
    patch(this.baza, this.path);
    windowNunc.deletefile(String.valueOf(this.path) + "\\pozeni1.sql");
  }
}