/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.File;
/*     */ import javax.swing.JOptionPane;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class thehandler
/*     */   implements ActionListener
/*     */ {
/*     */   private thehandler() {}
/*     */   
/*     */   public void actionPerformed(ActionEvent e) {
/* 386 */     System.out.println("e.getSource(): " + e.getSource());
/* 387 */     System.out.println("e.getActionCommand(): " + e.getActionCommand());
/* 388 */     System.out.println("patchTextField.getText(): " + windowNunc.this.patchTextField.getText());
/*     */     
/* 390 */     if (e.getSource() == windowNunc.this.menuItemHelp) {
/* 391 */       JOptionPane.showMessageDialog(windowNunc.this.contentPane, "NuncPatcher beta v0.3" + windowNunc.newLine + "Time: " + windowNunc.currentTime());
/*     */ 
/*     */     
/*     */     }
/* 395 */     else if (e.getSource() == windowNunc.this.openButtonDir) {
/* 396 */       int returnVal = windowNunc.this.fc.showOpenDialog(windowNunc.this);
/*     */       
/* 398 */       if (returnVal == 0) {
/*     */ 
/*     */         
/* 401 */         windowNunc.openDir = windowNunc.this.fc.getSelectedFile();
/*     */ 
/*     */         
/* 404 */         windowNunc.logTextArea.setText(null);
/*     */         
/* 406 */         windowNunc.this.showDirTextField.setText(windowNunc.openDir.getPath().substring(0, windowNunc.openDir.getPath().lastIndexOf("\\")));
/* 407 */         System.out.println("showDirTextField: " + windowNunc.this.showDirTextField.getText());
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 414 */       windowNunc.logTextArea.setCaretPosition(windowNunc.logTextArea.getDocument().getLength());
/*     */     
/*     */     }
/* 417 */     else if (windowNunc.this.patchTextField.equals(e.getSource())) {
/* 418 */       windowNunc.logTextArea.setText("patchTextField: " + windowNunc.this.patchTextField.getText());
/* 419 */       windowNunc.patchName = windowNunc.this.patchTextField.getText();
/*     */ 
/*     */       
/* 422 */       if ("".equals(windowNunc.saveDir) || windowNunc.saveDir == null) {
/* 423 */         boolean success; System.out.println("saveDirDir is null!");
/*     */         try {
/* 425 */           windowNunc.saveDir = new File(windowNunc.this.saveTextField.getText());
/* 426 */           System.out.println("SaveDir " + windowNunc.saveDir.getPath());
/*     */         } finally {
/* 428 */           System.out.println("Ne morem napolnit saveDir!");
/*     */           
/* 430 */           boolean bool = (new File(String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.patchName)).mkdirs();
/* 431 */           windowNunc.saveDir = new File(String.valueOf(windowNunc.this.showDirTextField.getText()) + "\\" + windowNunc.patchName);
/* 432 */           windowNunc.this.saveTextField.setText(windowNunc.saveDir.getPath());
/* 433 */           System.out.println("SaveDir " + windowNunc.saveDir.getPath());
/*     */         }
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 439 */     else if (windowNunc.this.saveButtonDir.equals(e.getSource())) {
/* 440 */       int returnVal = windowNunc.this.fc.showOpenDialog(windowNunc.this);
/*     */       
/* 442 */       if (returnVal == 0) {
/*     */ 
/*     */         
/* 445 */         windowNunc.saveDir = windowNunc.this.fc.getSelectedFile();
/*     */ 
/*     */         
/* 448 */         windowNunc.logTextArea.setText(null);
/*     */         
/* 450 */         windowNunc.this.saveTextField.setText(windowNunc.saveDir.getPath());
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 456 */       windowNunc.logTextArea.setCaretPosition(windowNunc.logTextArea.getDocument().getLength());
/*     */     
/*     */     }
/* 459 */     else if (windowNunc.this.bazeList.equals(e.getSource())) {
/* 460 */       System.out.println("izbrana vrednost je " + windowNunc.this.bazeList.getSelectedItem() + " index: " + windowNunc.this.bazeList.getSelectedIndex());
/* 461 */       windowNunc.this.izbranaBaza = windowNunc.this.bazeList.getSelectedIndex();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 467 */     else if (windowNunc.patch.equals(e.getSource())) {
/*     */       
/* 469 */       System.out.println("gumb Patch");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 477 */       System.out.println("saveDirDir final is null!");
/*     */       
/* 479 */       windowNunc.saveDir = new File(windowNunc.this.saveTextField.getText());
/*     */ 
/*     */       
/* 482 */       boolean success = (new File(windowNunc.this.saveTextField.getText())).mkdirs();
/* 483 */       System.out.println("SaveDir " + windowNunc.saveDir.getPath());
/*     */       
/* 485 */       if ("".equals(windowNunc.saveDir) || windowNunc.saveDir == null || windowNunc.saveDir.getPath().equals("")) {
/* 486 */         System.out.println("Ne morem napolnit saveDir! Provam iz saveTextField");
/* 487 */         System.out.println("showDirTextField.getText() je " + windowNunc.this.showDirTextField.getText());
/* 488 */         success = (new File(String.valueOf(windowNunc.this.showDirTextField.getText()) + "\\" + windowNunc.patchName)).mkdirs();
/* 489 */         windowNunc.saveDir = new File(String.valueOf(windowNunc.this.showDirTextField.getText()) + "\\" + windowNunc.patchName);
/* 490 */         windowNunc.this.saveTextField.setText(windowNunc.saveDir.getPath());
/* 491 */         System.out.println("saveTextField " + windowNunc.this.saveTextField.getText());
/* 492 */         System.out.println("saveDir " + windowNunc.saveDir.getPath());
/*     */       } 
/*     */ 
/*     */       
/* 496 */       if (windowNunc.saveDir.getPath().equals("\\null")) {
/* 497 */         System.out.println("saveDir je null, ne naredi nic.");
/* 498 */         windowNunc.saveDir = null;
/* 499 */         windowNunc.this.saveTextField.setText("");
/*     */       
/*     */       }
/* 502 */       else if (!"".equals(windowNunc.saveDir) && windowNunc.saveDir != null) {
/* 503 */         ExecSysCommand exeSysCom = new ExecSysCommand(windowNunc.this.baze[windowNunc.this.izbranaBaza], windowNunc.saveDir.getPath());
/* 504 */         Thread bazePatch = new Thread(exeSysCom);
/* 505 */         bazePatch.start();
/*     */ 
/*     */ 
/*     */       
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 515 */     else if (windowNunc.go.equals(e.getSource())) {
/*     */       
/* 517 */       System.out.println("Handle button GO!");
/* 518 */       windowNunc.saveDir = null;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 523 */       windowNunc.patchName = windowNunc.this.patchTextField.getText();
/* 524 */       System.out.println("patchName " + windowNunc.patchName);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 529 */       System.out.println("openDir is null!");
/*     */       
/*     */       try {
/* 532 */         windowNunc.openDir = new File(windowNunc.this.showDirTextField.getText());
/*     */       } finally {
/* 534 */         System.out.println("Ne morem napolnit openDir!");
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 541 */       if ("".equals(windowNunc.patchName) || windowNunc.patchName == null || !windowNunc.openDir.exists()) {
/* 542 */         System.out.println("Manjka nek obvezni pogoj!");
/* 543 */         JOptionPane.showMessageDialog(null, "Manjka nek obvezni pogoj!");
/*     */       }
/*     */       else {
/*     */         
/* 547 */         System.out.println("openDir.getPath(): " + windowNunc.openDir.getPath());
/* 548 */         System.out.println("windowNunc.config[0]: " + windowNunc.config[0]);
/* 549 */         windowNunc.this.stringDirTextField = windowNunc.this.showDirTextField.getText();
/* 550 */         System.out.println("showDirTextField: " + windowNunc.this.showDirTextField.getText());
/* 551 */         System.out.println("stringDirTextField: " + windowNunc.this.stringDirTextField);
/* 552 */         if (windowNunc.config[0].equals("n") || windowNunc.config[0].equals("N"))
/*     */         {
/* 554 */           windowNunc.this.stringDirTextField = windowNunc.this.stringDirTextField.substring(0, windowNunc.this.stringDirTextField.lastIndexOf("\\"));
/*     */         }
/* 556 */         System.out.println("showDirTextField: " + windowNunc.this.showDirTextField.getText());
/* 557 */         System.out.println("stringDirTextField: " + windowNunc.this.stringDirTextField);
/*     */ 
/*     */         
/* 560 */         if ("".equals(windowNunc.saveDir) || windowNunc.saveDir == null) {
/*     */           
/* 562 */           System.out.println("saveDirDir final is null!");
/*     */           
/* 564 */           windowNunc.saveDir = new File(windowNunc.this.saveTextField.getText());
/*     */ 
/*     */           
/* 567 */           boolean success = (new File(windowNunc.this.saveTextField.getText())).mkdirs();
/* 568 */           System.out.println("SaveDir " + windowNunc.saveDir.getPath());
/*     */           
/* 570 */           if ("".equals(windowNunc.saveDir) || windowNunc.saveDir == null || windowNunc.saveDir.getPath().equals("")) {
/* 571 */             System.out.println("Ne morem napolnit saveDir! Provam iz saveTextField1");
/* 572 */             System.out.println("showDirTextField1.getText() je " + windowNunc.this.stringDirTextField);
/* 573 */             success = (new File(String.valueOf(windowNunc.this.stringDirTextField) + "\\" + windowNunc.patchName)).mkdirs();
/* 574 */             windowNunc.saveDir = new File(String.valueOf(windowNunc.this.stringDirTextField) + "\\" + windowNunc.patchName);
/* 575 */             windowNunc.this.saveTextField.setText(windowNunc.saveDir.getPath());
/* 576 */             System.out.println("SaveDir " + windowNunc.saveDir.getPath());
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 584 */         windowNunc.appendLogTextArea("Create pozeni.sql" + windowNunc.newLine);
/* 585 */         windowNunc.pozeniFile.createPozeni(windowNunc.openDir.getPath(), windowNunc.patchName);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 591 */         windowNunc.appendLogTextArea("Copy files from " + windowNunc.openDir.getPath() + " to patch " + windowNunc.patchName + windowNunc.newLine);
/* 592 */         windowNunc.this.folder = new File(windowNunc.openDir.getPath());
/* 593 */         windowNunc.files = windowNunc.this.folder.listFiles();
/* 594 */         windowNunc.filenames = new String[windowNunc.files.length];
/* 595 */         windowNunc.compile_files = new File[windowNunc.files.length];
/* 596 */         for (int i = 0; i < windowNunc.files.length; i++) {
/* 597 */           if (windowNunc.files[i].isFile()) {
/*     */             
/* 599 */             windowNunc.filenames[i] = windowNunc.files[i].getName();
/* 600 */             System.out.println("copy file: " + windowNunc.filenames[i]);
/* 601 */             CopyFile.copyfile(String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.filenames[i], String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.filenames[i]);
/* 602 */             System.out.println("copied file: " + windowNunc.filenames[i]);
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 608 */         System.out.println("Prevedi reporte in forme");
/*     */         
/* 610 */         Finalize compileForm = new Finalize();
/* 611 */         compileForm.execute();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Cloud\OneDrive - IN2 d.o.o. Koper\janus_razvoj\MARSIKAJ\NuncPatchMaker\NuncPatchMaker_07_09_2017.jar!\windowNunc$thehandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */