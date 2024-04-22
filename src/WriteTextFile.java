/*    */ import java.io.Writer;
/*    */ 
/*    */ public class WriteTextFile {
/*    */   public static void create(String fileName, String inText) {
/*  5 */     Writer output = null;
/*    */     
/*  7 */     File file = new File(fileName);
/*    */     try {
/*  9 */       output = new BufferedWriter(new FileWriter(file));
/* 10 */       output.write(inText);
/* 11 */       output.close();
/* 12 */     } catch (IOException e) {
/*    */       
/* 14 */       e.printStackTrace();
/*    */     } 
/*    */     
/* 17 */     System.out.println("Your file has been written");
/*    */   }
/*    */ }


/* Location:              C:\Cloud\OneDrive - IN2 d.o.o. Koper\janus_razvoj\MARSIKAJ\NuncPatchMaker\NuncPatchMaker_07_09_2017.jar!\WriteTextFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */