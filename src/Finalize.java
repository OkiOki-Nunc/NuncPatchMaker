/*     */ import java.io.File;
/*     */ import javax.swing.SwingWorker;
/*     */ 
/*     */ 
/*     */ public class Finalize
/*     */   extends SwingWorker<String, Object>
/*     */ {
/*     */   public void compile() {
/*   9 */     windowNunc.go.setEnabled(false);
/*  10 */     windowNunc.patch.setEnabled(false);
/*  11 */     for (int i = 0; i < windowNunc.files.length; i++) {
/*  12 */       if (windowNunc.files[i].isFile()) {
/*  13 */         System.out.println("windowNunc.getExtension(windowNunc.files[i])==.fmb or .rdf " + windowNunc.getExtension(windowNunc.files[i]));
/*  14 */         if (windowNunc.getExtension(windowNunc.files[i]).equals("fmb") || windowNunc.getExtension(windowNunc.files[i]).equals("rdf") || windowNunc.getExtension(windowNunc.files[i]).equals("mmb")) {
/*  15 */           windowNunc.filenames[i] = windowNunc.files[i].getName();
/*     */           
/*  17 */           CopyFile.copyfile(String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.filenames[i], "Z:\\prevedi_za_popravek\\" + windowNunc.filenames[i]);
/*  18 */           windowNunc.compile_files[i] = new File("Z:\\prevedi_za_popravek\\" + windowNunc.filenames[i]);
/*  19 */           System.out.println("f: " + windowNunc.filenames[i]);
/*     */           
/*  21 */           windowNunc.appendLogTextArea("Compile " + windowNunc.compile_files[i].getName());
/*     */ 
/*     */           
/*  24 */           while (windowNunc.compile_files[i].exists()) {
/*     */             
/*  26 */             System.out.println("f: " + windowNunc.filenames[i] + " waito waito");
/*     */             
/*  28 */             windowNunc.appendLogTextArea(".");
/*     */             try {
/*  30 */               Thread.sleep(1000L);
/*  31 */             } catch (InterruptedException interruptedException) {}
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/*  36 */           if (windowNunc.getExtension(windowNunc.files[i]).equals("fmb")) {
/*  37 */             System.out.println("f: " + windowNunc.getFileName(windowNunc.files[i]) + ".fmx");
/*  38 */             windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".rep" + " to " + windowNunc.openDir.getPath() + windowNunc.newLine);
/*  39 */             CopyFile.copyfile("Z:\\prevedi_za_popravek\\prevedeno\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx", String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx");
/*  40 */             windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".fmx" + " to " + windowNunc.saveDir.getPath() + windowNunc.newLine);
/*  41 */             CopyFile.copyfile("Z:\\prevedi_za_popravek\\prevedeno\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx", String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx");
/*     */           }
/*  43 */           else if (windowNunc.getExtension(windowNunc.files[i]).equals("rdf")) {
/*  44 */             System.out.println("f: " + windowNunc.getFileName(windowNunc.files[i]) + ".rep");
/*  45 */             windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".rep" + " to " + windowNunc.openDir.getPath() + windowNunc.newLine);
/*  46 */             CopyFile.copyfile("Z:\\prevedi_za_popravek\\prevedeno\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep", String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep");
/*  47 */             windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".rep" + " to " + windowNunc.saveDir.getPath() + windowNunc.newLine);
/*  48 */             CopyFile.copyfile("Z:\\prevedi_za_popravek\\prevedeno\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep", String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep");
/*     */           }
/*  50 */           else if (windowNunc.getExtension(windowNunc.files[i]).equals("mmb")) {
/*  51 */             System.out.println("f: " + windowNunc.getFileName(windowNunc.files[i]) + ".mmx");
/*  52 */             windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".mmx" + " to " + windowNunc.openDir.getPath() + windowNunc.newLine);
/*  53 */             CopyFile.copyfile("Z:\\prevedi_za_popravek\\prevedeno\\" + windowNunc.getFileName(windowNunc.files[i]) + ".mmx", String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".mmx");
/*  54 */             windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".mmx" + " to " + windowNunc.saveDir.getPath() + windowNunc.newLine);
/*  55 */             CopyFile.copyfile("Z:\\prevedi_za_popravek\\prevedeno\\" + windowNunc.getFileName(windowNunc.files[i]) + ".mmx", String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + "mmx");
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  60 */     windowNunc.go.setEnabled(true);
/*  61 */     windowNunc.patch.setEnabled(true);
/*     */   }
/*     */   
/*     */   public void zip() {
/*  65 */     ZipFiles zip = null;
/*     */     
/*  67 */     zip = new ZipFiles(windowNunc.openDir.getPath(), windowNunc.patchName);
/*     */ 
/*     */     
/*  70 */     windowNunc.appendLogTextArea("Zip patch files " + windowNunc.openDir.getPath() + "\\" + windowNunc.patchName + ".zip" + windowNunc.newLine);
/*  71 */     windowNunc.zipFile = new File(String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.patchName + ".zip");
/*  72 */     System.out.println("zipFile path: " + windowNunc.zipFile.getPath());
/*  73 */     System.out.println("zipFile abs path: " + windowNunc.zipFile.getAbsolutePath());
/*  74 */     windowNunc.filesInZip = zip.FilesInZip(windowNunc.zipFile.getPath());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void copy() {
/*  85 */     System.out.println("Kopiraj fajle iz " + windowNunc.zipFile.getPath() + " v " + windowNunc.saveDir.getPath() + "\\" + windowNunc.patchName + ".zip");
/*  86 */     windowNunc.appendLogTextArea("Copy " + windowNunc.zipFile.getPath() + " to " + windowNunc.saveDir.getPath() + "\\" + windowNunc.patchName + ".zip" + windowNunc.newLine);
/*  87 */     CopyFile.copyfile(windowNunc.zipFile.getPath(), String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.patchName + ".zip");
/*     */     
/*  89 */     System.out.println(windowNunc.saveDir.getPath().substring(0, windowNunc.saveDir.getPath().lastIndexOf("\\")));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void delete() {
/*  96 */     if (!windowNunc.openDir.getPath().equals(windowNunc.saveDir.getPath())) {
/*     */ 
/*     */       
/*  99 */       System.out.println("Brisi " + windowNunc.zipFile.getPath());
/* 100 */       windowNunc.appendLogTextArea("Delete " + windowNunc.zipFile.getPath() + windowNunc.newLine);
/* 101 */       windowNunc.deletefile(windowNunc.zipFile.getPath());
/* 102 */       System.out.println("Brisi " + windowNunc.openDir.getPath() + "\\pozeni.sql");
/* 103 */       windowNunc.appendLogTextArea("Delete " + windowNunc.openDir.getPath() + "\\pozeni.sql" + windowNunc.newLine);
/* 104 */       windowNunc.deletefile(String.valueOf(windowNunc.openDir.getPath()) + "\\pozeni.sql");
/*     */ 
/*     */       
/* 107 */       for (int i = 0; i < windowNunc.files.length; i++) {
/* 108 */         if (windowNunc.files[i].isFile()) {
/* 109 */           System.out.println("getExtension(files[i])==.fmb or .rdf " + windowNunc.getExtension(windowNunc.files[i]));
/* 110 */           if (windowNunc.getExtension(windowNunc.files[i]).equals("fmx") || windowNunc.getExtension(windowNunc.files[i]).equals("rep") || windowNunc.getExtension(windowNunc.files[i]).equals("mmx")) {
/* 111 */             System.out.println("Brisi " + windowNunc.openDir.getPath() + "\\" + windowNunc.files[i].getName());
/* 112 */             windowNunc.appendLogTextArea("Delete " + windowNunc.openDir.getPath() + "\\" + windowNunc.files[i].getName() + windowNunc.newLine);
/* 113 */             windowNunc.deletefile(String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.files[i].getName());
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String doInBackground() throws Exception {
/* 124 */     zip();
/* 125 */     copy();
/* 126 */     delete();
/* 127 */     return "D";
/*     */   }
/*     */ }


/* Location:              C:\Cloud\OneDrive - IN2 d.o.o. Koper\janus_razvoj\MARSIKAJ\NuncPatchMaker\NuncPatchMaker_07_09_2017.jar!\Finalize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */