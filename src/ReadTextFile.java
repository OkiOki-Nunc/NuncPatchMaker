import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class ReadTextFile
{
  public static void read(String fileName, StringBuilder sb) {
    int numLinesFile = count(fileName);
    int currNumLunes = 0;
    System.out.println("Število vrstic " + numLinesFile);
    
    BufferedReader br = null;
    
    try {
      br = new BufferedReader(new FileReader(fileName));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } 

    
    try {
      String line = null;
      try {
        line = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
      } 

      
      currNumLunes++;
      while (line != null && currNumLunes <= numLinesFile) {
        sb.append(line);
        System.out.println(String.valueOf(currNumLunes) + " line " + line);
        sb.append("\n");
        try {
          line = br.readLine();
        } catch (IOException e) {
          e.printStackTrace();
        } 
      } 
    } finally {
      
      try {
        br.close();
      } catch (IOException e) {
        e.printStackTrace();
      } 
    } 
  }
  
  public static int count(String fileName) {
    LineNumberReader lr = null;
    try {
      lr = new LineNumberReader(new FileReader(fileName));
    } catch (FileNotFoundException e1) {
      
      e1.printStackTrace();
    } 
    
    int cnt = 0;
    String lineRead = ""; try { do {
      
      } while ((lineRead = lr.readLine()) != null);
       }
    
    catch (IOException e)
    
    { e.printStackTrace(); }

    
    cnt = lr.getLineNumber();
    try {
      lr.close();
    } catch (IOException e) {
      
      e.printStackTrace();
    } 
    return cnt;
  }
}