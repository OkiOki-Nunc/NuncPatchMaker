/*    */ import java.io.BufferedReader;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.FileReader;
/*    */ import java.io.IOException;
/*    */ import java.io.LineNumberReader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReadTextFile
/*    */ {
/*    */   public static void read(String fileName, StringBuilder sb) {
/* 13 */     int numLinesFile = count(fileName);
/* 14 */     int currNumLunes = 0;
/* 15 */     System.out.println("Število vrstic " + numLinesFile);
/*    */     
/* 17 */     BufferedReader br = null;
/*    */     
/*    */     try {
/* 20 */       br = new BufferedReader(new FileReader(fileName));
/* 21 */     } catch (FileNotFoundException e) {
/* 22 */       e.printStackTrace();
/*    */     } 
/*    */ 
/*    */     
/*    */     try {
/* 27 */       String line = null;
/*    */       try {
/* 29 */         line = br.readLine();
/* 30 */       } catch (IOException e) {
/* 31 */         e.printStackTrace();
/*    */       } 
/*    */ 
/*    */       
/* 35 */       currNumLunes++;
/* 36 */       while (line != null && currNumLunes <= numLinesFile) {
/* 37 */         sb.append(line);
/* 38 */         System.out.println(String.valueOf(currNumLunes) + " line " + line);
/* 39 */         sb.append("\n");
/*    */         try {
/* 41 */           line = br.readLine();
/* 42 */         } catch (IOException e) {
/* 43 */           e.printStackTrace();
/*    */         } 
/*    */       } 
/*    */     } finally {
/*    */       
/*    */       try {
/* 49 */         br.close();
/* 50 */       } catch (IOException e) {
/* 51 */         e.printStackTrace();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public static int count(String fileName) {
/* 57 */     LineNumberReader lr = null;
/*    */     try {
/* 59 */       lr = new LineNumberReader(new FileReader(fileName));
/* 60 */     } catch (FileNotFoundException e1) {
/*    */       
/* 62 */       e1.printStackTrace();
/*    */     } 
/*    */     
/* 65 */     int cnt = 0;
/* 66 */     String lineRead = ""; try { do {
/*    */       
/* 68 */       } while ((lineRead = lr.readLine()) != null);
/*    */        }
/*    */     
/* 71 */     catch (IOException e)
/*    */     
/* 73 */     { e.printStackTrace(); }
/*    */ 
/*    */     
/* 76 */     cnt = lr.getLineNumber();
/*    */     try {
/* 78 */       lr.close();
/* 79 */     } catch (IOException e) {
/*    */       
/* 81 */       e.printStackTrace();
/*    */     } 
/* 83 */     return cnt;
/*    */   }
/*    */ }


/* Location:              C:\Cloud\OneDrive - IN2 d.o.o. Koper\janus_razvoj\MARSIKAJ\NuncPatchMaker\NuncPatchMaker_07_09_2017.jar!\ReadTextFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */