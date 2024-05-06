import java.io.Writer;

public class WriteTextFile {
  public static void create(String fileName, String inText) {
    Writer output = null;
    
    File file = new File(fileName);
    try {
      output = new BufferedWriter(new FileWriter(file));
      output.write(inText);
      output.close();
    } catch (IOException e) {
      
      e.printStackTrace();
    } 
    
    System.out.println("Your file has been written");
  }
}