/*     */ import java.awt.BorderLayout;
/*     */ import java.awt.Container;
/*     */ import java.awt.Dimension;
/*     */ import java.awt.FlowLayout;
/*     */ import java.awt.GridBagConstraints;
/*     */ import java.awt.GridBagLayout;
/*     */ import java.awt.Insets;
/*     */ import java.awt.event.ActionEvent;
/*     */ import java.awt.event.ActionListener;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.StringReader;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import javax.swing.BorderFactory;
/*     */ import javax.swing.Box;
/*     */ import javax.swing.JButton;
/*     */ import javax.swing.JComboBox;
/*     */ import javax.swing.JFileChooser;
/*     */ import javax.swing.JFrame;
/*     */ import javax.swing.JLabel;
/*     */ import javax.swing.JMenu;
/*     */ import javax.swing.JMenuBar;
/*     */ import javax.swing.JMenuItem;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.JPanel;
/*     */ import javax.swing.JScrollPane;
/*     */ import javax.swing.JTextArea;
/*     */ import javax.swing.JTextField;
/*     */ 
/*     */ public class windowNunc
/*     */   extends JFrame
/*     */ {
/*  35 */   JPanel contentPane = null;
/*     */   
/*     */   JScrollPane scrollPane;
/*     */   
/*     */   JButton openButtonDir;
/*     */   
/*     */   JTextField showDirTextField;
/*     */   
/*     */   String stringDirTextField;
/*     */   
/*     */   JLabel patchTextLabel;
/*     */   
/*     */   JTextField patchTextField;
/*     */   
/*     */   JButton saveButtonDir;
/*     */   
/*     */   JTextField saveTextField;
/*     */   
/*     */   static JTextArea logTextArea;
/*     */   
/*     */   static JButton go;
/*     */   JComboBox bazeList;
/*     */   JMenuBar menuBar;
/*     */   JMenu menuHelp;
/*     */   JMenuItem menuItemHelp;
/*     */   String[] imeBaze;
/*     */   String[] baze;
/*     */   int izbranaBaza;
/*     */   static String[] config;
/*     */   static File[] files;
/*     */   static File[] compile_files;
/*     */   static String[] filenames;
/*     */   File folder;
/*     */   static JButton patch;
/*     */   JFileChooser fc;
/*     */   static ZipFiles zip;
/*     */   static String filesInZip;
/*     */   static String patchName;
/*     */   static File openDir;
/*     */   static File saveDir;
/*     */   static File zipFile;
/*  76 */   static String newLine = System.getProperty("line.separator");
/*     */   
/*  78 */   static String path = System.getProperty("user.dir");
/*     */ 
/*     */   
/*     */   static boolean compileFormFinished = false;
/*     */ 
/*     */   
/*  84 */   static Pozeni pozeniFile = new Pozeni();
/*     */ 
/*     */   
/*     */   static String getExtension(File f) {
/*  88 */     String ext = null;
/*  89 */     String s = f.getName();
/*  90 */     int i = s.lastIndexOf('.');
/*     */     
/*  92 */     if (i > 0 && i < s.length() - 1) {
/*  93 */       ext = s.substring(i + 1).toLowerCase();
/*     */     }
/*  95 */     if (ext == null)
/*  96 */       return ""; 
/*  97 */     return ext;
/*     */   }
/*     */ 
/*     */   
/*     */   static String getFileName(File f) {
/* 102 */     String ext = null;
/* 103 */     String s = f.getName();
/* 104 */     int i = s.lastIndexOf('.');
/*     */     
/* 106 */     if (i > 0 && i < s.length() - 1) {
/* 107 */       ext = s.substring(0, i).toLowerCase();
/*     */     }
/* 109 */     if (ext == null) {
/* 110 */       return "";
/*     */     }
/* 112 */     return ext;
/*     */   }
/*     */ 
/*     */   
/*     */   static String getBazeName(String s) {
/* 117 */     String ext = null;
/* 118 */     int i = s.indexOf(';');
/*     */     
/* 120 */     if (i > 0 && i < s.length() - 1) {
/* 121 */       ext = s.substring(0, i).toLowerCase();
/*     */     }
/* 123 */     if (ext == null) {
/* 124 */       return "";
/*     */     }
/* 126 */     return ext;
/*     */   }
/*     */ 
/*     */   
/*     */   static String getConnectionString(String s) {
/* 131 */     String ext = null;
/* 132 */     int i = s.indexOf(';');
/*     */     
/* 134 */     if (i > 0 && i < s.length() - 1) {
/* 135 */       ext = s.substring(i + 1).toLowerCase();
/*     */     }
/* 137 */     if (ext == null) {
/* 138 */       return "";
/*     */     }
/* 140 */     return ext;
/*     */   }
/*     */   
/*     */   static void deletefile(String file) {
/* 144 */     File f1 = new File(file);
/* 145 */     boolean success = f1.delete();
/* 146 */     if (!success) {
/* 147 */       System.out.println("Deletion failed.");
/*     */     } else {
/* 149 */       System.out.println("File deleted.");
/*     */     } 
/*     */   }
/*     */   
/*     */   static String currentTime() {
/* 154 */     Calendar cal = Calendar.getInstance();
/* 155 */     SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
/*     */ 
/*     */     
/* 158 */     cal.getTime();
/* 159 */     String currTimeString = sdf.format(cal.getTime());
/* 160 */     System.out.println("Current time " + currTimeString);
/* 161 */     return currTimeString;
/*     */   }
/*     */   
/*     */   static void appendLogTextArea(String string) {
/* 165 */     logTextArea.append(string);
/* 166 */     logTextArea.setCaretPosition(logTextArea.getDocument().getLength());
/*     */   }
/*     */ 
/*     */   
/*     */   public windowNunc() {
/* 171 */     super("NuncPatcher");
/* 172 */     setLayout(new FlowLayout());
/*     */     
/* 174 */     setContentPane(createContentPane());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Container createContentPane() {
/* 180 */     this.contentPane = new JPanel(new BorderLayout());
/*     */ 
/*     */ 
/*     */     
/* 184 */     thehandler handler = new thehandler(null);
/*     */ 
/*     */     
/* 187 */     this.menuBar = new JMenuBar();
/* 188 */     this.menuHelp = new JMenu("Help");
/*     */ 
/*     */     
/* 191 */     this.menuBar.add(Box.createHorizontalGlue());
/* 192 */     this.menuBar.add(this.menuHelp);
/* 193 */     this.menuItemHelp = new JMenuItem("About");
/* 194 */     this.menuHelp.add(this.menuItemHelp);
/* 195 */     this.menuItemHelp.addActionListener(handler);
/* 196 */     setJMenuBar(this.menuBar);
/*     */ 
/*     */     
/* 199 */     JPanel directoryPanel = new JPanel();
/* 200 */     this.openButtonDir = new JButton("Open dir.");
/* 201 */     this.openButtonDir.addActionListener(handler);
/* 202 */     GridBagLayout gridbag = new GridBagLayout();
/* 203 */     GridBagConstraints c = new GridBagConstraints();
/*     */ 
/*     */     
/* 206 */     c.fill = 2;
/* 207 */     c.gridwidth = 2;
/* 208 */     c.gridheight = 3;
/* 209 */     c.insets = new Insets(0, 5, 0, 0);
/*     */     
/* 211 */     c.weightx = 0.0D;
/* 212 */     c.weighty = 0.0D;
/*     */     
/* 214 */     directoryPanel.setLayout(gridbag);
/* 215 */     directoryPanel.add(this.openButtonDir, c);
/*     */ 
/*     */     
/* 218 */     this.showDirTextField = new JTextField();
/* 219 */     c.weightx = 1.0D;
/* 220 */     c.weighty = 0.0D;
/* 221 */     c.gridwidth = 0;
/* 222 */     directoryPanel.add(this.showDirTextField, c);
/*     */ 
/*     */ 
/*     */     
/* 226 */     this.patchTextLabel = new JLabel("Patch: ");
/* 227 */     this.patchTextLabel.setLabelFor(this.patchTextField);
/* 228 */     c.weightx = 0.0D;
/* 229 */     c.weighty = 0.0D;
/* 230 */     c.gridwidth = -1;
/* 231 */     directoryPanel.add(this.patchTextLabel, c);
/*     */     
/* 233 */     this.patchTextField = new JTextField("", 10);
/* 234 */     this.patchTextField.addActionListener(handler);
/* 235 */     c.weightx = 0.0D;
/* 236 */     c.weighty = 0.0D;
/* 237 */     c.gridwidth = 0;
/* 238 */     c.fill = 2;
/* 239 */     directoryPanel.add(this.patchTextField, c);
/*     */ 
/*     */     
/* 242 */     this.saveButtonDir = new JButton("Save dir.");
/* 243 */     this.saveButtonDir.addActionListener(handler);
/* 244 */     c.weightx = 0.0D;
/* 245 */     c.weighty = 0.0D;
/* 246 */     c.gridwidth = -1;
/* 247 */     directoryPanel.add(this.saveButtonDir, c);
/*     */     
/* 249 */     this.saveTextField = new JTextField("", 10);
/* 250 */     c.weightx = 0.0D;
/* 251 */     c.weighty = 0.0D;
/* 252 */     c.gridwidth = 0;
/* 253 */     c.fill = 2;
/* 254 */     directoryPanel.add(this.saveTextField, c);
/*     */     
/* 256 */     System.out.println("PATH: " + path);
/*     */     
/* 258 */     StringBuilder sb = new StringBuilder();
/* 259 */     StringBuilder sbConfig = new StringBuilder();
/*     */     
/* 261 */     ReadTextFile.read(String.valueOf(path) + "\\baze.ini", sb);
/*     */ 
/*     */     
/* 264 */     BufferedReader bufReader = new BufferedReader(new StringReader(sb.toString()));
/*     */     
/* 266 */     String line = null;
/*     */     
/* 268 */     System.out.println("Št. baz " + (sb.toString().split("\r\n|\r|\n")).length);
/* 269 */     this.imeBaze = new String[(sb.toString().split("\r\n|\r|\n")).length];
/* 270 */     this.baze = new String[(sb.toString().split("\r\n|\r|\n")).length];
/*     */     
/*     */     try {
/* 273 */       int i = 0;
/* 274 */       while ((line = bufReader.readLine()) != null) {
/*     */         
/* 276 */         System.out.println("Baze: " + getBazeName(line));
/* 277 */         System.out.println("ConnString: " + getConnectionString(line));
/* 278 */         this.imeBaze[i] = getBazeName(line);
/* 279 */         this.baze[i] = getConnectionString(line);
/* 280 */         i++;
/*     */       } 
/* 282 */     } catch (IOException e) {
/* 283 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 286 */     this.bazeList = new JComboBox<String>(this.imeBaze);
/* 287 */     directoryPanel.add(this.bazeList, c);
/*     */     
/* 289 */     this.bazeList.addActionListener(handler);
/*     */ 
/*     */     
/* 292 */     ReadTextFile.read(String.valueOf(path) + "\\config.ini", sbConfig);
/* 293 */     bufReader = new BufferedReader(new StringReader(sbConfig.toString()));
/* 294 */     config = new String[(sbConfig.toString().split("\r\n|\r|\n")).length];
/*     */     
/*     */     try {
/* 297 */       int i = 0;
/* 298 */       while ((line = bufReader.readLine()) != null) {
/*     */         
/* 300 */         System.out.println("congif name: " + getBazeName(line));
/* 301 */         System.out.println("congif value: " + getConnectionString(line));
/* 302 */         config[i] = getConnectionString(line);
/* 303 */         i++;
/*     */       } 
/* 305 */     } catch (IOException e) {
/* 306 */       e.printStackTrace();
/*     */     } 
/*     */ 
/*     */     
/* 310 */     JPanel goPanel = new JPanel();
/* 311 */     goPanel.setLayout(gridbag);
/* 312 */     go = new JButton("GO!");
/* 313 */     go.addActionListener(handler);
/* 314 */     c.weightx = 0.0D;
/* 315 */     c.weighty = 0.0D;
/* 316 */     c.gridwidth = -1;
/*     */     
/* 318 */     goPanel.add(go, c);
/*     */ 
/*     */     
/* 321 */     JPanel patchPanel = new JPanel();
/* 322 */     patchPanel.setLayout(gridbag);
/* 323 */     patch = new JButton("Patch");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 332 */     patch.addActionListener(handler);
/* 333 */     patchPanel.add(patch, c);
/*     */     
/* 335 */     JPanel logPanel = new JPanel();
/* 336 */     logTextArea = new JTextArea("Hello!" + newLine);
/* 337 */     logTextArea.setEditable(false);
/*     */     
/* 339 */     logTextArea.setLineWrap(true);
/* 340 */     logTextArea.setWrapStyleWord(true);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 345 */     JScrollPane areaScrollPane = new JScrollPane(logTextArea);
/* 346 */     areaScrollPane.setVerticalScrollBarPolicy(
/* 347 */         22);
/* 348 */     areaScrollPane.setPreferredSize(new Dimension(470, 320));
/* 349 */     areaScrollPane.setBorder(
/* 350 */         BorderFactory.createCompoundBorder(
/* 351 */           BorderFactory.createCompoundBorder(
/* 352 */             BorderFactory.createTitledBorder("Log area"), 
/* 353 */             BorderFactory.createEmptyBorder(5, 5, 5, 5)), 
/* 354 */           areaScrollPane.getBorder()));
/*     */     
/* 356 */     logPanel.add(areaScrollPane, 
/* 357 */         "Center");
/*     */ 
/*     */ 
/*     */     
/* 361 */     this.contentPane.add(directoryPanel, "First");
/* 362 */     this.contentPane.add(goPanel, "Center");
/* 363 */     this.contentPane.add(patchPanel, "After");
/* 364 */     this.contentPane.add(logPanel, "Last");
/* 365 */     directoryPanel.setBorder(
/* 366 */         BorderFactory.createCompoundBorder(
/* 367 */           BorderFactory.createTitledBorder("Parameters"), 
/* 368 */           BorderFactory.createEmptyBorder(5, 5, 5, 5)));
/*     */ 
/*     */     
/* 371 */     this.contentPane.setBorder(
/* 372 */         BorderFactory.createCompoundBorder(
/* 373 */           BorderFactory.createTitledBorder(""), 
/* 374 */           BorderFactory.createEmptyBorder(5, 5, 5, 5)));
/*     */ 
/*     */     
/* 377 */     this.fc = new JFileChooser();
/* 378 */     this.fc.setFileSelectionMode(1);
/*     */     
/* 380 */     return this.contentPane;
/*     */   }
/*     */   
/*     */   private class thehandler
/*     */     implements ActionListener {
/*     */     public void actionPerformed(ActionEvent e) {
/* 386 */       System.out.println("e.getSource(): " + e.getSource());
/* 387 */       System.out.println("e.getActionCommand(): " + e.getActionCommand());
/* 388 */       System.out.println("patchTextField.getText(): " + windowNunc.this.patchTextField.getText());
/*     */       
/* 390 */       if (e.getSource() == windowNunc.this.menuItemHelp) {
/* 391 */         JOptionPane.showMessageDialog(windowNunc.this.contentPane, "NuncPatcher beta v0.3" + windowNunc.newLine + "Time: " + windowNunc.currentTime());
/*     */ 
/*     */       
/*     */       }
/* 395 */       else if (e.getSource() == windowNunc.this.openButtonDir) {
/* 396 */         int returnVal = windowNunc.this.fc.showOpenDialog(windowNunc.this);
/*     */         
/* 398 */         if (returnVal == 0) {
/*     */ 
/*     */           
/* 401 */           windowNunc.openDir = windowNunc.this.fc.getSelectedFile();
/*     */ 
/*     */           
/* 404 */           windowNunc.logTextArea.setText(null);
/*     */           
/* 406 */           windowNunc.this.showDirTextField.setText(windowNunc.openDir.getPath().substring(0, windowNunc.openDir.getPath().lastIndexOf("\\")));
/* 407 */           System.out.println("showDirTextField: " + windowNunc.this.showDirTextField.getText());
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 414 */         windowNunc.logTextArea.setCaretPosition(windowNunc.logTextArea.getDocument().getLength());
/*     */       
/*     */       }
/* 417 */       else if (windowNunc.this.patchTextField.equals(e.getSource())) {
/* 418 */         windowNunc.logTextArea.setText("patchTextField: " + windowNunc.this.patchTextField.getText());
/* 419 */         windowNunc.patchName = windowNunc.this.patchTextField.getText();
/*     */ 
/*     */         
/* 422 */         if ("".equals(windowNunc.saveDir) || windowNunc.saveDir == null) {
/* 423 */           boolean success; System.out.println("saveDirDir is null!");
/*     */           try {
/* 425 */             windowNunc.saveDir = new File(windowNunc.this.saveTextField.getText());
/* 426 */             System.out.println("SaveDir " + windowNunc.saveDir.getPath());
/*     */           } finally {
/* 428 */             System.out.println("Ne morem napolnit saveDir!");
/*     */             
/* 430 */             boolean bool = (new File(String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.patchName)).mkdirs();
/* 431 */             windowNunc.saveDir = new File(String.valueOf(windowNunc.this.showDirTextField.getText()) + "\\" + windowNunc.patchName);
/* 432 */             windowNunc.this.saveTextField.setText(windowNunc.saveDir.getPath());
/* 433 */             System.out.println("SaveDir " + windowNunc.saveDir.getPath());
/*     */           }
/*     */         
/*     */         }
/*     */       
/*     */       }
/* 439 */       else if (windowNunc.this.saveButtonDir.equals(e.getSource())) {
/* 440 */         int returnVal = windowNunc.this.fc.showOpenDialog(windowNunc.this);
/*     */         
/* 442 */         if (returnVal == 0) {
/*     */ 
/*     */           
/* 445 */           windowNunc.saveDir = windowNunc.this.fc.getSelectedFile();
/*     */ 
/*     */           
/* 448 */           windowNunc.logTextArea.setText(null);
/*     */           
/* 450 */           windowNunc.this.saveTextField.setText(windowNunc.saveDir.getPath());
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 456 */         windowNunc.logTextArea.setCaretPosition(windowNunc.logTextArea.getDocument().getLength());
/*     */       
/*     */       }
/* 459 */       else if (windowNunc.this.bazeList.equals(e.getSource())) {
/* 460 */         System.out.println("izbrana vrednost je " + windowNunc.this.bazeList.getSelectedItem() + " index: " + windowNunc.this.bazeList.getSelectedIndex());
/* 461 */         windowNunc.this.izbranaBaza = windowNunc.this.bazeList.getSelectedIndex();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 467 */       else if (windowNunc.patch.equals(e.getSource())) {
/*     */         
/* 469 */         System.out.println("gumb Patch");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 477 */         System.out.println("saveDirDir final is null!");
/*     */         
/* 479 */         windowNunc.saveDir = new File(windowNunc.this.saveTextField.getText());
/*     */ 
/*     */         
/* 482 */         boolean success = (new File(windowNunc.this.saveTextField.getText())).mkdirs();
/* 483 */         System.out.println("SaveDir " + windowNunc.saveDir.getPath());
/*     */         
/* 485 */         if ("".equals(windowNunc.saveDir) || windowNunc.saveDir == null || windowNunc.saveDir.getPath().equals("")) {
/* 486 */           System.out.println("Ne morem napolnit saveDir! Provam iz saveTextField");
/* 487 */           System.out.println("showDirTextField.getText() je " + windowNunc.this.showDirTextField.getText());
/* 488 */           success = (new File(String.valueOf(windowNunc.this.showDirTextField.getText()) + "\\" + windowNunc.patchName)).mkdirs();
/* 489 */           windowNunc.saveDir = new File(String.valueOf(windowNunc.this.showDirTextField.getText()) + "\\" + windowNunc.patchName);
/* 490 */           windowNunc.this.saveTextField.setText(windowNunc.saveDir.getPath());
/* 491 */           System.out.println("saveTextField " + windowNunc.this.saveTextField.getText());
/* 492 */           System.out.println("saveDir " + windowNunc.saveDir.getPath());
/*     */         } 
/*     */ 
/*     */         
/* 496 */         if (windowNunc.saveDir.getPath().equals("\\null")) {
/* 497 */           System.out.println("saveDir je null, ne naredi nic.");
/* 498 */           windowNunc.saveDir = null;
/* 499 */           windowNunc.this.saveTextField.setText("");
/*     */         
/*     */         }
/* 502 */         else if (!"".equals(windowNunc.saveDir) && windowNunc.saveDir != null) {
/* 503 */           ExecSysCommand exeSysCom = new ExecSysCommand(windowNunc.this.baze[windowNunc.this.izbranaBaza], windowNunc.saveDir.getPath());
/* 504 */           Thread bazePatch = new Thread(exeSysCom);
/* 505 */           bazePatch.start();
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 515 */       else if (windowNunc.go.equals(e.getSource())) {
/*     */         
/* 517 */         System.out.println("Handle button GO!");
/* 518 */         windowNunc.saveDir = null;
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 523 */         windowNunc.patchName = windowNunc.this.patchTextField.getText();
/* 524 */         System.out.println("patchName " + windowNunc.patchName);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 529 */         System.out.println("openDir is null!");
/*     */         
/*     */         try {
/* 532 */           windowNunc.openDir = new File(windowNunc.this.showDirTextField.getText());
/*     */         } finally {
/* 534 */           System.out.println("Ne morem napolnit openDir!");
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 541 */         if ("".equals(windowNunc.patchName) || windowNunc.patchName == null || !windowNunc.openDir.exists()) {
/* 542 */           System.out.println("Manjka nek obvezni pogoj!");
/* 543 */           JOptionPane.showMessageDialog(null, "Manjka nek obvezni pogoj!");
/*     */         }
/*     */         else {
/*     */           
/* 547 */           System.out.println("openDir.getPath(): " + windowNunc.openDir.getPath());
/* 548 */           System.out.println("windowNunc.config[0]: " + windowNunc.config[0]);
/* 549 */           windowNunc.this.stringDirTextField = windowNunc.this.showDirTextField.getText();
/* 550 */           System.out.println("showDirTextField: " + windowNunc.this.showDirTextField.getText());
/* 551 */           System.out.println("stringDirTextField: " + windowNunc.this.stringDirTextField);
/* 552 */           if (windowNunc.config[0].equals("n") || windowNunc.config[0].equals("N"))
/*     */           {
/* 554 */             windowNunc.this.stringDirTextField = windowNunc.this.stringDirTextField.substring(0, windowNunc.this.stringDirTextField.lastIndexOf("\\"));
/*     */           }
/* 556 */           System.out.println("showDirTextField: " + windowNunc.this.showDirTextField.getText());
/* 557 */           System.out.println("stringDirTextField: " + windowNunc.this.stringDirTextField);
/*     */ 
/*     */           
/* 560 */           if ("".equals(windowNunc.saveDir) || windowNunc.saveDir == null) {
/*     */             
/* 562 */             System.out.println("saveDirDir final is null!");
/*     */             
/* 564 */             windowNunc.saveDir = new File(windowNunc.this.saveTextField.getText());
/*     */ 
/*     */             
/* 567 */             boolean success = (new File(windowNunc.this.saveTextField.getText())).mkdirs();
/* 568 */             System.out.println("SaveDir " + windowNunc.saveDir.getPath());
/*     */             
/* 570 */             if ("".equals(windowNunc.saveDir) || windowNunc.saveDir == null || windowNunc.saveDir.getPath().equals("")) {
/* 571 */               System.out.println("Ne morem napolnit saveDir! Provam iz saveTextField1");
/* 572 */               System.out.println("showDirTextField1.getText() je " + windowNunc.this.stringDirTextField);
/* 573 */               success = (new File(String.valueOf(windowNunc.this.stringDirTextField) + "\\" + windowNunc.patchName)).mkdirs();
/* 574 */               windowNunc.saveDir = new File(String.valueOf(windowNunc.this.stringDirTextField) + "\\" + windowNunc.patchName);
/* 575 */               windowNunc.this.saveTextField.setText(windowNunc.saveDir.getPath());
/* 576 */               System.out.println("SaveDir " + windowNunc.saveDir.getPath());
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 584 */           windowNunc.appendLogTextArea("Create pozeni.sql" + windowNunc.newLine);
/* 585 */           windowNunc.pozeniFile.createPozeni(windowNunc.openDir.getPath(), windowNunc.patchName);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 591 */           windowNunc.appendLogTextArea("Copy files from " + windowNunc.openDir.getPath() + " to patch " + windowNunc.patchName + windowNunc.newLine);
/* 592 */           windowNunc.this.folder = new File(windowNunc.openDir.getPath());
/* 593 */           windowNunc.files = windowNunc.this.folder.listFiles();
/* 594 */           windowNunc.filenames = new String[windowNunc.files.length];
/* 595 */           windowNunc.compile_files = new File[windowNunc.files.length];
/* 596 */           for (int i = 0; i < windowNunc.files.length; i++) {
/* 597 */             if (windowNunc.files[i].isFile()) {
/*     */               
/* 599 */               windowNunc.filenames[i] = windowNunc.files[i].getName();
/* 600 */               System.out.println("copy file: " + windowNunc.filenames[i]);
/* 601 */               CopyFile.copyfile(String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.filenames[i], String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.filenames[i]);
/* 602 */               System.out.println("copied file: " + windowNunc.filenames[i]);
/*     */             } 
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 608 */           System.out.println("Prevedi reporte in forme");
/*     */           
/* 610 */           Finalize compileForm = new Finalize();
/* 611 */           compileForm.execute();
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     private thehandler() {}
/*     */   }
/*     */ }


/* Location:              C:\Cloud\OneDrive - IN2 d.o.o. Koper\janus_razvoj\MARSIKAJ\NuncPatchMaker\NuncPatchMaker_07_09_2017.jar!\windowNunc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */