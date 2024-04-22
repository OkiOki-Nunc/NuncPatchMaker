/*    */ import java.io.File;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CopyOfCompileForm
/*    */   implements Runnable
/*    */ {
/*    */   public void compile() {
/* 11 */     windowNunc.go.setEnabled(false);
/* 12 */     windowNunc.patch.setEnabled(false);
/* 13 */     for (int i = 0; i < windowNunc.files.length; i++) {
/* 14 */       if (windowNunc.files[i].isFile()) {
/* 15 */         System.out.println("windowNunc.getExtension(windowNunc.files[i])==.fmb or .rdf " + windowNunc.getExtension(windowNunc.files[i]));
/* 16 */         if (windowNunc.getExtension(windowNunc.files[i]).equals("fmb") || windowNunc.getExtension(windowNunc.files[i]).equals("rdf")) {
/* 17 */           windowNunc.filenames[i] = windowNunc.files[i].getName();
/*    */           
/* 19 */           CopyFile.copyfile(String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.filenames[i], "Z:\\prevedi_za_popravek\\" + windowNunc.filenames[i]);
/* 20 */           windowNunc.compile_files[i] = new File("Z:\\prevedi_za_popravek\\" + windowNunc.filenames[i]);
/* 21 */           System.out.println("f: " + windowNunc.filenames[i]);
/*    */           
/* 23 */           windowNunc.appendLogTextArea("Compile " + windowNunc.compile_files[i].getName());
/*    */ 
/*    */           
/* 26 */           while (windowNunc.compile_files[i].exists()) {
/*    */             
/* 28 */             System.out.println("f: " + windowNunc.filenames[i] + " waito waito");
/*    */             
/* 30 */             windowNunc.appendLogTextArea(".");
/*    */             try {
/* 32 */               Thread.sleep(1000L);
/* 33 */             } catch (InterruptedException interruptedException) {}
/*    */           } 
/*    */ 
/*    */ 
/*    */           
/* 38 */           if (windowNunc.getExtension(windowNunc.files[i]).equals("fmb")) {
/* 39 */             System.out.println("f: " + windowNunc.getFileName(windowNunc.files[i]) + ".fmx");
/* 40 */             windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".rep" + " to " + windowNunc.openDir.getPath() + windowNunc.newLine);
/* 41 */             CopyFile.copyfile("Z:\\prevedi_za_popravek\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx", String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx");
/* 42 */             windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".fmx" + " to " + windowNunc.saveDir.getPath() + windowNunc.newLine);
/* 43 */             CopyFile.copyfile("Z:\\prevedi_za_popravek\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx", String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx");
/*    */           }
/* 45 */           else if (windowNunc.getExtension(windowNunc.files[i]).equals("rdf")) {
/* 46 */             System.out.println("f: " + windowNunc.getFileName(windowNunc.files[i]) + ".fmx");
/* 47 */             windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".rep" + " to " + windowNunc.openDir.getPath() + windowNunc.newLine);
/* 48 */             CopyFile.copyfile("Z:\\prevedi_za_popravek\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep", String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep");
/* 49 */             windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".rep" + " to " + windowNunc.saveDir.getPath() + windowNunc.newLine);
/* 50 */             CopyFile.copyfile("Z:\\prevedi_za_popravek\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep", String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep");
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/* 55 */     windowNunc.go.setEnabled(true);
/* 56 */     windowNunc.patch.setEnabled(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void run() {
/* 61 */     compile();
/* 62 */     windowNunc.compileFormFinished = true;
/*    */   }
/*    */ }


/* Location:              C:\Cloud\OneDrive - IN2 d.o.o. Koper\janus_razvoj\MARSIKAJ\NuncPatchMaker\NuncPatchMaker_07_09_2017.jar!\CopyOfCompileForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */