import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class windowNunc
  extends JFrame
{
  JPanel contentPane = null;
  
  JScrollPane scrollPane;
  
  JButton openButtonDir;
  
  JTextField showDirTextField;
  
  String stringDirTextField;
  
  JLabel patchTextLabel;
  
  JTextField patchTextField;
  
  JButton saveButtonDir;
  
  JTextField saveTextField;
  
  static JTextArea logTextArea;
  
  static JButton go;
  JComboBox bazeList;
  JMenuBar menuBar;
  JMenu menuHelp;
  JMenuItem menuItemHelp;
  String[] imeBaze;
  String[] baze;
  int izbranaBaza;
  static String[] config;
  static File[] files;
  static File[] compile_files;
  static String[] filenames;
  File folder;
  static JButton patch;
  JFileChooser fc;
  static ZipFiles zip;
  static String filesInZip;
  static String patchName;
  static File openDir;
  static File saveDir;
  static File zipFile;
  static String newLine = System.getProperty("line.separator");
  
  static String path = System.getProperty("user.dir");

  
  static boolean compileFormFinished = false;

  
  static Pozeni pozeniFile = new Pozeni();

  
  static String getExtension(File f) {
    String ext = null;
    String s = f.getName();
    int i = s.lastIndexOf('.');
    
    if (i > 0 && i < s.length() - 1) {
      ext = s.substring(i + 1).toLowerCase();
    }
    if (ext == null)
      return ""; 
    return ext;
  }

  
  static String getFileName(File f) {
    String ext = null;
    String s = f.getName();
    int i = s.lastIndexOf('.');
    
    if (i > 0 && i < s.length() - 1) {
      ext = s.substring(0, i).toLowerCase();
    }
    if (ext == null) {
      return "";
    }
    return ext;
  }

  
  static String getBazeName(String s) {
    String ext = null;
    int i = s.indexOf(';');
    
    if (i > 0 && i < s.length() - 1) {
      ext = s.substring(0, i).toLowerCase();
    }
    if (ext == null) {
      return "";
    }
    return ext;
  }

  
  static String getConnectionString(String s) {
    String ext = null;
    int i = s.indexOf(';');
    
    if (i > 0 && i < s.length() - 1) {
      ext = s.substring(i + 1).toLowerCase();
    }
    if (ext == null) {
      return "";
    }
    return ext;
  }
  
  static void deletefile(String file) {
    File f1 = new File(file);
    boolean success = f1.delete();
    if (!success) {
      System.out.println("Deletion failed.");
    } else {
      System.out.println("File deleted.");
    } 
  }
  
  static String currentTime() {
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    
    cal.getTime();
    String currTimeString = sdf.format(cal.getTime());
    System.out.println("Current time " + currTimeString);
    return currTimeString;
  }
  
  static void appendLogTextArea(String string) {
    logTextArea.append(string);
    logTextArea.setCaretPosition(logTextArea.getDocument().getLength());
  }

  
  public windowNunc() {
    super("NuncPatcher");
    setLayout(new FlowLayout());
    
    setContentPane(createContentPane());
  }


  
  public Container createContentPane() {
    this.contentPane = new JPanel(new BorderLayout());


    
    thehandler handler = new thehandler(null);

    
    this.menuBar = new JMenuBar();
    this.menuHelp = new JMenu("Help");

    
    this.menuBar.add(Box.createHorizontalGlue());
    this.menuBar.add(this.menuHelp);
    this.menuItemHelp = new JMenuItem("About");
    this.menuHelp.add(this.menuItemHelp);
    this.menuItemHelp.addActionListener(handler);
    setJMenuBar(this.menuBar);

    
    JPanel directoryPanel = new JPanel();
    this.openButtonDir = new JButton("Open dir.");
    this.openButtonDir.addActionListener(handler);
    GridBagLayout gridbag = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();

    
    c.fill = 2;
    c.gridwidth = 2;
    c.gridheight = 3;
    c.insets = new Insets(0, 5, 0, 0);
    
    c.weightx = 0.0D;
    c.weighty = 0.0D;
    
    directoryPanel.setLayout(gridbag);
    directoryPanel.add(this.openButtonDir, c);

    
    this.showDirTextField = new JTextField();
    c.weightx = 1.0D;
    c.weighty = 0.0D;
    c.gridwidth = 0;
    directoryPanel.add(this.showDirTextField, c);


    
    this.patchTextLabel = new JLabel("Patch: ");
    this.patchTextLabel.setLabelFor(this.patchTextField);
    c.weightx = 0.0D;
    c.weighty = 0.0D;
    c.gridwidth = -1;
    directoryPanel.add(this.patchTextLabel, c);
    
    this.patchTextField = new JTextField("", 10);
    this.patchTextField.addActionListener(handler);
    c.weightx = 0.0D;
    c.weighty = 0.0D;
    c.gridwidth = 0;
    c.fill = 2;
    directoryPanel.add(this.patchTextField, c);

    
    this.saveButtonDir = new JButton("Save dir.");
    this.saveButtonDir.addActionListener(handler);
    c.weightx = 0.0D;
    c.weighty = 0.0D;
    c.gridwidth = -1;
    directoryPanel.add(this.saveButtonDir, c);
    
    this.saveTextField = new JTextField("", 10);
    c.weightx = 0.0D;
    c.weighty = 0.0D;
    c.gridwidth = 0;
    c.fill = 2;
    directoryPanel.add(this.saveTextField, c);
    
    System.out.println("PATH: " + path);
    
    StringBuilder sb = new StringBuilder();
    StringBuilder sbConfig = new StringBuilder();
    
    ReadTextFile.read(String.valueOf(path) + "\\baze.ini", sb);

    
    BufferedReader bufReader = new BufferedReader(new StringReader(sb.toString()));
    
    String line = null;
    
    System.out.println("Št. baz " + (sb.toString().split("\r\n|\r|\n")).length);
    this.imeBaze = new String[(sb.toString().split("\r\n|\r|\n")).length];
    this.baze = new String[(sb.toString().split("\r\n|\r|\n")).length];
    
    try {
      int i = 0;
      while ((line = bufReader.readLine()) != null) {
        
        System.out.println("Baze: " + getBazeName(line));
        System.out.println("ConnString: " + getConnectionString(line));
        this.imeBaze[i] = getBazeName(line);
        this.baze[i] = getConnectionString(line);
        i++;
      } 
    } catch (IOException e) {
      e.printStackTrace();
    } 
    
    this.bazeList = new JComboBox<String>(this.imeBaze);
    directoryPanel.add(this.bazeList, c);
    
    this.bazeList.addActionListener(handler);

    
    ReadTextFile.read(String.valueOf(path) + "\\config.ini", sbConfig);
    bufReader = new BufferedReader(new StringReader(sbConfig.toString()));
    config = new String[(sbConfig.toString().split("\r\n|\r|\n")).length];
    
    try {
      int i = 0;
      while ((line = bufReader.readLine()) != null) {
        
        System.out.println("congif name: " + getBazeName(line));
        System.out.println("congif value: " + getConnectionString(line));
        config[i] = getConnectionString(line);
        i++;
      } 
    } catch (IOException e) {
      e.printStackTrace();
    } 

    
    JPanel goPanel = new JPanel();
    goPanel.setLayout(gridbag);
    go = new JButton("GO!");
    go.addActionListener(handler);
    c.weightx = 0.0D;
    c.weighty = 0.0D;
    c.gridwidth = -1;
    
    goPanel.add(go, c);

    
    JPanel patchPanel = new JPanel();
    patchPanel.setLayout(gridbag);
    patch = new JButton("Patch");







    
    patch.addActionListener(handler);
    patchPanel.add(patch, c);
    
    JPanel logPanel = new JPanel();
    logTextArea = new JTextArea("Hello!" + newLine);
    logTextArea.setEditable(false);
    
    logTextArea.setLineWrap(true);
    logTextArea.setWrapStyleWord(true);



    
    JScrollPane areaScrollPane = new JScrollPane(logTextArea);
    areaScrollPane.setVerticalScrollBarPolicy(
        22);
    areaScrollPane.setPreferredSize(new Dimension(470, 320));
    areaScrollPane.setBorder(
        BorderFactory.createCompoundBorder(
          BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Log area"), 
            BorderFactory.createEmptyBorder(5, 5, 5, 5)), 
          areaScrollPane.getBorder()));
    
    logPanel.add(areaScrollPane, 
        "Center");


    
    this.contentPane.add(directoryPanel, "First");
    this.contentPane.add(goPanel, "Center");
    this.contentPane.add(patchPanel, "After");
    this.contentPane.add(logPanel, "Last");
    directoryPanel.setBorder(
        BorderFactory.createCompoundBorder(
          BorderFactory.createTitledBorder("Parameters"), 
          BorderFactory.createEmptyBorder(5, 5, 5, 5)));

    
    this.contentPane.setBorder(
        BorderFactory.createCompoundBorder(
          BorderFactory.createTitledBorder(""), 
          BorderFactory.createEmptyBorder(5, 5, 5, 5)));

    
    this.fc = new JFileChooser();
    this.fc.setFileSelectionMode(1);
    
    return this.contentPane;
  }
  
  private class thehandler
    implements ActionListener {
    public void actionPerformed(ActionEvent e) {
      System.out.println("e.getSource(): " + e.getSource());
      System.out.println("e.getActionCommand(): " + e.getActionCommand());
      System.out.println("patchTextField.getText(): " + windowNunc.this.patchTextField.getText());
      
      if (e.getSource() == windowNunc.this.menuItemHelp) {
        JOptionPane.showMessageDialog(windowNunc.this.contentPane, "NuncPatcher beta v0.3" + windowNunc.newLine + "Time: " + windowNunc.currentTime());

      
      }
      else if (e.getSource() == windowNunc.this.openButtonDir) {
        int returnVal = windowNunc.this.fc.showOpenDialog(windowNunc.this);
        
        if (returnVal == 0) {

          
          windowNunc.openDir = windowNunc.this.fc.getSelectedFile();

          
          windowNunc.logTextArea.setText(null);
          
          windowNunc.this.showDirTextField.setText(windowNunc.openDir.getPath().substring(0, windowNunc.openDir.getPath().lastIndexOf("\\")));
          System.out.println("showDirTextField: " + windowNunc.this.showDirTextField.getText());
        } 




        
        windowNunc.logTextArea.setCaretPosition(windowNunc.logTextArea.getDocument().getLength());
      
      }
      else if (windowNunc.this.patchTextField.equals(e.getSource())) {
        windowNunc.logTextArea.setText("patchTextField: " + windowNunc.this.patchTextField.getText());
        windowNunc.patchName = windowNunc.this.patchTextField.getText();

        
        if ("".equals(windowNunc.saveDir) || windowNunc.saveDir == null) {
          boolean success; System.out.println("saveDirDir is null!");
          try {
            windowNunc.saveDir = new File(windowNunc.this.saveTextField.getText());
            System.out.println("SaveDir " + windowNunc.saveDir.getPath());
          } finally {
            System.out.println("Ne morem napolnit saveDir!");
            
            boolean bool = (new File(String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.patchName)).mkdirs();
            windowNunc.saveDir = new File(String.valueOf(windowNunc.this.showDirTextField.getText()) + "\\" + windowNunc.patchName);
            windowNunc.this.saveTextField.setText(windowNunc.saveDir.getPath());
            System.out.println("SaveDir " + windowNunc.saveDir.getPath());
          }
        
        }
      
      }
      else if (windowNunc.this.saveButtonDir.equals(e.getSource())) {
        int returnVal = windowNunc.this.fc.showOpenDialog(windowNunc.this);
        
        if (returnVal == 0) {

          
          windowNunc.saveDir = windowNunc.this.fc.getSelectedFile();

          
          windowNunc.logTextArea.setText(null);
          
          windowNunc.this.saveTextField.setText(windowNunc.saveDir.getPath());
        } 



        
        windowNunc.logTextArea.setCaretPosition(windowNunc.logTextArea.getDocument().getLength());
      
      }
      else if (windowNunc.this.bazeList.equals(e.getSource())) {
        System.out.println("izbrana vrednost je " + windowNunc.this.bazeList.getSelectedItem() + " index: " + windowNunc.this.bazeList.getSelectedIndex());
        windowNunc.this.izbranaBaza = windowNunc.this.bazeList.getSelectedIndex();



      
      }
      else if (windowNunc.patch.equals(e.getSource())) {
        
        System.out.println("gumb Patch");






        
        System.out.println("saveDirDir final is null!");
        
        windowNunc.saveDir = new File(windowNunc.this.saveTextField.getText());

        
        boolean success = (new File(windowNunc.this.saveTextField.getText())).mkdirs();
        System.out.println("SaveDir " + windowNunc.saveDir.getPath());
        
        if ("".equals(windowNunc.saveDir) || windowNunc.saveDir == null || windowNunc.saveDir.getPath().equals("")) {
          System.out.println("Ne morem napolnit saveDir! Provam iz saveTextField");
          System.out.println("showDirTextField.getText() je " + windowNunc.this.showDirTextField.getText());
          success = (new File(String.valueOf(windowNunc.this.showDirTextField.getText()) + "\\" + windowNunc.patchName)).mkdirs();
          windowNunc.saveDir = new File(String.valueOf(windowNunc.this.showDirTextField.getText()) + "\\" + windowNunc.patchName);
          windowNunc.this.saveTextField.setText(windowNunc.saveDir.getPath());
          System.out.println("saveTextField " + windowNunc.this.saveTextField.getText());
          System.out.println("saveDir " + windowNunc.saveDir.getPath());
        } 

        
        if (windowNunc.saveDir.getPath().equals("\\null")) {
          System.out.println("saveDir je null, ne naredi nic.");
          windowNunc.saveDir = null;
          windowNunc.this.saveTextField.setText("");
        
        }
        else if (!"".equals(windowNunc.saveDir) && windowNunc.saveDir != null) {
          ExecSysCommand exeSysCom = new ExecSysCommand(windowNunc.this.baze[windowNunc.this.izbranaBaza], windowNunc.saveDir.getPath());
          Thread bazePatch = new Thread(exeSysCom);
          bazePatch.start();


        
        }



      
      }
      else if (windowNunc.go.equals(e.getSource())) {
        
        System.out.println("Handle button GO!");
        windowNunc.saveDir = null;



        
        windowNunc.patchName = windowNunc.this.patchTextField.getText();
        System.out.println("patchName " + windowNunc.patchName);



        
        System.out.println("openDir is null!");
        
        try {
          windowNunc.openDir = new File(windowNunc.this.showDirTextField.getText());
        } finally {
          System.out.println("Ne morem napolnit openDir!");
        } 




        
        if ("".equals(windowNunc.patchName) || windowNunc.patchName == null || !windowNunc.openDir.exists()) {
          System.out.println("Manjka nek obvezni pogoj!");
          JOptionPane.showMessageDialog(null, "Manjka nek obvezni pogoj!");
        }
        else {
          
          System.out.println("openDir.getPath(): " + windowNunc.openDir.getPath());
          System.out.println("windowNunc.config[0]: " + windowNunc.config[0]);
          windowNunc.this.stringDirTextField = windowNunc.this.showDirTextField.getText();
          System.out.println("showDirTextField: " + windowNunc.this.showDirTextField.getText());
          System.out.println("stringDirTextField: " + windowNunc.this.stringDirTextField);
          if (windowNunc.config[0].equals("n") || windowNunc.config[0].equals("N"))
          {
            windowNunc.this.stringDirTextField = windowNunc.this.stringDirTextField.substring(0, windowNunc.this.stringDirTextField.lastIndexOf("\\"));
          }
          System.out.println("showDirTextField: " + windowNunc.this.showDirTextField.getText());
          System.out.println("stringDirTextField: " + windowNunc.this.stringDirTextField);

          
          if ("".equals(windowNunc.saveDir) || windowNunc.saveDir == null) {
            
            System.out.println("saveDirDir final is null!");
            
            windowNunc.saveDir = new File(windowNunc.this.saveTextField.getText());

            
            boolean success = (new File(windowNunc.this.saveTextField.getText())).mkdirs();
            System.out.println("SaveDir " + windowNunc.saveDir.getPath());
            
            if ("".equals(windowNunc.saveDir) || windowNunc.saveDir == null || windowNunc.saveDir.getPath().equals("")) {
              System.out.println("Ne morem napolnit saveDir! Provam iz saveTextField1");
              System.out.println("showDirTextField1.getText() je " + windowNunc.this.stringDirTextField);
              success = (new File(String.valueOf(windowNunc.this.stringDirTextField) + "\\" + windowNunc.patchName)).mkdirs();
              windowNunc.saveDir = new File(String.valueOf(windowNunc.this.stringDirTextField) + "\\" + windowNunc.patchName);
              windowNunc.this.saveTextField.setText(windowNunc.saveDir.getPath());
              System.out.println("SaveDir " + windowNunc.saveDir.getPath());
            } 
          } 




          
          windowNunc.appendLogTextArea("Create pozeni.sql" + windowNunc.newLine);
          windowNunc.pozeniFile.createPozeni(windowNunc.openDir.getPath(), windowNunc.patchName);




          
          windowNunc.appendLogTextArea("Copy files from " + windowNunc.openDir.getPath() + " to patch " + windowNunc.patchName + windowNunc.newLine);
          windowNunc.this.folder = new File(windowNunc.openDir.getPath());
          windowNunc.files = windowNunc.this.folder.listFiles();
          windowNunc.filenames = new String[windowNunc.files.length];
          windowNunc.compile_files = new File[windowNunc.files.length];
          for (int i = 0; i < windowNunc.files.length; i++) {
            if (windowNunc.files[i].isFile()) {
              
              windowNunc.filenames[i] = windowNunc.files[i].getName();
              System.out.println("copy file: " + windowNunc.filenames[i]);
              CopyFile.copyfile(String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.filenames[i], String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.filenames[i]);
              System.out.println("copied file: " + windowNunc.filenames[i]);
            } 
          } 


          
          System.out.println("Prevedi reporte in forme");
          
          Finalize compileForm = new Finalize();
          compileForm.execute();
        } 
      } 
    }
    
    private thehandler() {}
  }
}