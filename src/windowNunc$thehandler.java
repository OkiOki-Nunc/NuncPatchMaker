import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JOptionPane;

class thehandler
  implements ActionListener
{
  private thehandler() {}
  
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
}