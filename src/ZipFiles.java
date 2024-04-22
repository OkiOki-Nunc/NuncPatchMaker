/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Enumeration;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ZipFiles
/*     */ {
/*     */   String[] filenames;
/*     */   File[] files;
/*  21 */   byte[] buf = new byte[1024];
/*     */ 
/*     */ 
/*     */   
/*     */   public ZipFiles(String dirName, String fileName) {
/*     */     try {
/*  27 */       String outFilename = String.valueOf(dirName) + "\\" + fileName + ".zip";
/*  28 */       File outFile = new File(outFilename);
/*  29 */       System.out.println("Zip FileName " + outFilename);
/*  30 */       ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFilename));
/*     */ 
/*     */       
/*  33 */       String path = dirName;
/*  34 */       System.out.println("path1 " + path);
/*     */       
/*  36 */       File folder = new File(path);
/*  37 */       this.files = folder.listFiles();
/*  38 */       this.filenames = new String[this.files.length];
/*     */       int i;
/*  40 */       for (i = 0; i < this.files.length; i++) {
/*     */         
/*  42 */         if (this.files[i].isFile()) {
/*  43 */           this.filenames[i] = this.files[i].getName();
/*  44 */           System.out.println("filenames in ZIP: " + this.filenames[i]);
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  52 */       for (i = 0; i < this.files.length; i++) {
/*  53 */         if (this.files[i].isFile() && this.files[i].compareTo(outFile) != 0) {
/*     */ 
/*     */           
/*  56 */           System.out.println("for FileInputStream: " + this.files[i].getPath());
/*  57 */           FileInputStream in = new FileInputStream(this.files[i].getPath());
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  62 */           out.putNextEntry(new ZipEntry(this.files[i].getName()));
/*     */ 
/*     */ 
/*     */           
/*  66 */           int max = 0; int len;
/*  67 */           while ((len = in.read(this.buf)) > 0) {
/*  68 */             max++;
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*  73 */             out.write(this.buf, 0, len);
/*     */           } 
/*     */ 
/*     */           
/*  77 */           out.closeEntry();
/*  78 */           in.close();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  83 */       out.close();
/*  84 */     } catch (IOException iOException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String FilesInZip(String s) {
/*  90 */     String zipEntryName = null;
/*     */ 
/*     */     
/*     */     try {
/*  94 */       ZipFile zf = new ZipFile(s);
/*     */ 
/*     */       
/*  97 */       for (Enumeration<? extends ZipEntry> entries = zf.entries(); entries.hasMoreElements();)
/*     */       {
/*  99 */         zipEntryName = String.valueOf(zipEntryName) + " " + ((ZipEntry)entries.nextElement()).getName();
/*     */       }
/* 101 */       zf.close();
/* 102 */     } catch (IOException iOException) {}
/*     */     
/* 104 */     return zipEntryName;
/*     */   }
/*     */ }


/* Location:              C:\Cloud\OneDrive - IN2 d.o.o. Koper\janus_razvoj\MARSIKAJ\NuncPatchMaker\NuncPatchMaker_07_09_2017.jar!\ZipFiles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */