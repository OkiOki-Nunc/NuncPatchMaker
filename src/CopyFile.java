/*    */ import java.io.File;
/*    */ import java.io.InputStream;
/*    */ 
/*    */ public class CopyFile {
/*    */   public static void copyfile(String srFile, String dtFile) {
/*    */     try {
/*  7 */       if (srFile.equals(dtFile)) {
/*    */         return;
/*    */       }
/*    */       
/* 11 */       File f1 = new File(srFile);
/* 12 */       File f2 = new File(dtFile);
/* 13 */       InputStream in = new FileInputStream(f1);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 19 */       OutputStream out = new FileOutputStream(f2);
/*    */       
/* 21 */       byte[] buf = new byte[1024];
/*    */       int len;
/* 23 */       while ((len = in.read(buf)) > 0) {
/* 24 */         out.write(buf, 0, len);
/*    */       }
/* 26 */       in.close();
/* 27 */       out.close();
/* 28 */       System.out.println("File copied.");
/*    */     }
/* 30 */     catch (FileNotFoundException ex) {
/* 31 */       System.out.println(String.valueOf(ex.getMessage()) + " in the specified directory.");
/* 32 */       System.exit(0);
/*    */     }
/* 34 */     catch (IOException e) {
/* 35 */       System.out.println(e.getMessage());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Cloud\OneDrive - IN2 d.o.o. Koper\janus_razvoj\MARSIKAJ\NuncPatchMaker\NuncPatchMaker_07_09_2017.jar!\CopyFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */