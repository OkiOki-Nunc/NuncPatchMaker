/*    */ import java.io.BufferedReader;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStreamReader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExecSysCommand
/*    */   implements Runnable
/*    */ {
/*    */   String baza;
/*    */   String path;
/*    */   
/*    */   ExecSysCommand(String baza, String path) {
/* 15 */     this.baza = baza;
/* 16 */     this.path = path;
/*    */   }
/*    */ 
/*    */   
/*    */   public void patch(String baza, String path) {
/*    */     try {
/* 22 */       windowNunc.patch.setEnabled(false);
/* 23 */       windowNunc.go.setEnabled(false);
/*    */ 
/*    */       
/* 26 */       System.out.println("sqlplus.exe " + baza + " @\"" + path + "\\pozeni1.sql\"");
/* 27 */       Process p = Runtime.getRuntime().exec("sqlplus.exe " + baza + " @" + path + "\\pozeni1.sql");
/*    */       
/* 29 */       BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
/* 30 */       String line = reader.readLine();
/* 31 */       String log = new String("baza = " + baza + windowNunc.newLine);
/* 32 */       log = String.valueOf(log) + "Path = " + path + windowNunc.newLine;
/* 33 */       log = String.valueOf(log) + windowNunc.newLine;
/*    */       
/* 35 */       while (line != null) {
/*    */         
/* 37 */         System.out.println(line);
/* 38 */         windowNunc.appendLogTextArea(line);
/* 39 */         windowNunc.appendLogTextArea(windowNunc.newLine);
/*    */ 
/*    */         
/* 42 */         log = String.valueOf(log) + line + windowNunc.newLine;
/* 43 */         line = reader.readLine();
/*    */       } 
/* 45 */       WriteTextFile.create(String.valueOf(path) + "\\" + getBase(baza) + ".log", log);
/* 46 */       System.out.println("Gotof si!");
/*    */     
/*    */     }
/* 49 */     catch (IOException iOException) {}
/*    */ 
/*    */     
/* 52 */     windowNunc.patch.setEnabled(true);
/* 53 */     windowNunc.go.setEnabled(true);
/* 54 */     System.out.println("Done");
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getBase(String s) {
/* 59 */     String base = null;
/* 60 */     int i = s.lastIndexOf('@');
/*    */     
/* 62 */     if (i > 0 && i < s.length() - 1) {
/* 63 */       base = s.substring(i + 1).toLowerCase();
/*    */     }
/* 65 */     if (base == null) {
/* 66 */       return "";
/*    */     }
/* 68 */     return base;
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 73 */     System.out.println("Runnable " + this.baza + " @ " + this.path);
/* 74 */     windowNunc.pozeniFile.createPozeni1(this.path);
/* 75 */     patch(this.baza, this.path);
/* 76 */     windowNunc.deletefile(String.valueOf(this.path) + "\\pozeni1.sql");
/*    */   }
/*    */ }


/* Location:              C:\Cloud\OneDrive - IN2 d.o.o. Koper\janus_razvoj\MARSIKAJ\NuncPatchMaker\NuncPatchMaker_07_09_2017.jar!\ExecSysCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */