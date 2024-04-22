/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Pozeni
/*     */   extends windowNunc
/*     */ {
/*     */   public void createPozeni(String path, String patchName) {
/*  14 */     System.out.println("createPozeni() " + path);
/*  15 */     String pozeni = "";
/*  16 */     this.folder = new File(path);
/*  17 */     files = this.folder.listFiles();
/*  18 */     filenames = new String[files.length];
/*  19 */     int files_exist = 0;
/*     */     
/*  21 */     pozeni = String.valueOf(pozeni) + "-- Created by NuncPatcher" + newLine;
/*  22 */     pozeni = String.valueOf(pozeni) + newLine;
/*     */     
/*  24 */     pozeni = String.valueOf(pozeni) + "SPOOL \"" + patchName + ".lst\"" + newLine;
/*  25 */     pozeni = String.valueOf(pozeni) + newLine;
/*     */     
/*  27 */     System.out.println("filenames: ");
/*     */     
/*     */     int i;
/*  30 */     for (i = 0; i < files.length; i++) {
/*  31 */       if (files[i].isFile()) {
/*  32 */         System.out.println("getExtension(files[i])==.pks " + getExtension(files[i]));
/*  33 */         if (getExtension(files[i]).equals("pks")) {
/*  34 */           filenames[i] = files[i].getName();
/*  35 */           pozeni = String.valueOf(pozeni) + "Prompt " + filenames[i] + newLine;
/*  36 */           pozeni = String.valueOf(pozeni) + "@@" + filenames[i] + newLine;
/*  37 */           System.out.println("f: " + filenames[i]);
/*  38 */           files_exist++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  44 */     for (i = 0; i < files.length; i++) {
/*  45 */       if (files[i].isFile()) {
/*  46 */         System.out.println("getExtension(files[i])==.pkb " + getExtension(files[i]));
/*  47 */         if (getExtension(files[i]).equals("pkb")) {
/*  48 */           filenames[i] = files[i].getName();
/*  49 */           pozeni = String.valueOf(pozeni) + "Prompt " + filenames[i] + newLine;
/*  50 */           pozeni = String.valueOf(pozeni) + "@@" + filenames[i] + newLine;
/*  51 */           System.out.println("f: " + filenames[i]);
/*  52 */           files_exist++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  58 */     for (i = 0; i < files.length; i++) {
/*  59 */       if (files[i].isFile() && (
/*  60 */         getExtension(files[i]).equals("sql") || getExtension(files[i]).equals("trg"))) {
/*  61 */         filenames[i] = files[i].getName();
/*  62 */         pozeni = String.valueOf(pozeni) + "Prompt " + filenames[i] + newLine;
/*  63 */         pozeni = String.valueOf(pozeni) + "@@" + filenames[i] + newLine;
/*  64 */         System.out.println("f: " + filenames[i]);
/*  65 */         files_exist++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  70 */     pozeni = String.valueOf(pozeni) + newLine;
/*  71 */     pozeni = String.valueOf(pozeni) + "SPOOL OFF";
/*     */     
/*  73 */     if (files_exist > 0) {
/*  74 */       WriteTextFile.create(String.valueOf(path) + "\\pozeni.sql", pozeni);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void createPozeni1(String path) {
/*  82 */     String pozeni1 = "";
/*  83 */     System.out.println("path " + path);
/*  84 */     BufferedReader br = null;
/*     */     try {
/*  86 */       br = new BufferedReader(new FileReader(String.valueOf(path) + "\\pozeni.sql"));
/*  87 */     } catch (FileNotFoundException e) {
/*  88 */       e.printStackTrace();
/*     */     } 
/*  90 */     String line = null;
/*     */     try {
/*  92 */       line = br.readLine();
/*  93 */     } catch (IOException e) {
/*     */       
/*  95 */       e.printStackTrace();
/*     */     } 
/*  97 */     while (line != null) {
/*     */       
/*  99 */       System.out.println(line);
/* 100 */       pozeni1 = String.valueOf(pozeni1) + line + windowNunc.newLine;
/*     */       try {
/* 102 */         line = br.readLine();
/* 103 */       } catch (IOException e) {
/*     */         
/* 105 */         e.printStackTrace();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 117 */     Alter_invalid_skr alterInvalid = new Alter_invalid_skr();
/* 118 */     alterInvalid.create();
/*     */     
/* 120 */     pozeni1 = String.valueOf(pozeni1) + windowNunc.newLine;
/*     */     
/* 122 */     pozeni1 = String.valueOf(pozeni1) + "@\"" + windowNunc.path + "\\alter_invalid1.skr\"" + windowNunc.newLine;
/*     */     
/* 124 */     pozeni1 = String.valueOf(pozeni1) + "@\"" + windowNunc.path + "\\alter_invalid.sql\"" + windowNunc.newLine;
/* 125 */     pozeni1 = String.valueOf(pozeni1) + windowNunc.newLine;
/* 126 */     pozeni1 = String.valueOf(pozeni1) + "exit" + windowNunc.newLine;
/* 127 */     System.out.println("pozeni1: " + pozeni1);
/*     */     
/* 129 */     WriteTextFile.create(String.valueOf(path) + "\\pozeni1.sql", pozeni1);
/*     */   }
/*     */ }


/* Location:              C:\Cloud\OneDrive - IN2 d.o.o. Koper\janus_razvoj\MARSIKAJ\NuncPatchMaker\NuncPatchMaker_07_09_2017.jar!\Pozeni.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */