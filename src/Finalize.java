import java.io.File;
import javax.swing.SwingWorker;

public class Finalize
  extends SwingWorker<String, Object>
{
  public void compile() {
    windowNunc.go.setEnabled(false);
    windowNunc.patch.setEnabled(false);
    for (int i = 0; i < windowNunc.files.length; i++) {
      if (windowNunc.files[i].isFile()) {
        System.out.println("windowNunc.getExtension(windowNunc.files[i])==.fmb or .rdf " + windowNunc.getExtension(windowNunc.files[i]));
        if (windowNunc.getExtension(windowNunc.files[i]).equals("fmb") || windowNunc.getExtension(windowNunc.files[i]).equals("rdf") || windowNunc.getExtension(windowNunc.files[i]).equals("mmb")) {
          windowNunc.filenames[i] = windowNunc.files[i].getName();
          
          CopyFile.copyfile(String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.filenames[i], "Z:\\prevedi_za_popravek\\" + windowNunc.filenames[i]);
          windowNunc.compile_files[i] = new File("Z:\\prevedi_za_popravek\\" + windowNunc.filenames[i]);
          System.out.println("f: " + windowNunc.filenames[i]);
          
          windowNunc.appendLogTextArea("Compile " + windowNunc.compile_files[i].getName());

          
          while (windowNunc.compile_files[i].exists()) {
            
            System.out.println("f: " + windowNunc.filenames[i] + " waito waito");
            
            windowNunc.appendLogTextArea(".");
            try {
              Thread.sleep(1000L);
            } catch (InterruptedException interruptedException) {}
          } 


          
          if (windowNunc.getExtension(windowNunc.files[i]).equals("fmb")) {
            System.out.println("f: " + windowNunc.getFileName(windowNunc.files[i]) + ".fmx");
            windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".rep" + " to " + windowNunc.openDir.getPath() + windowNunc.newLine);
            CopyFile.copyfile("Z:\\prevedi_za_popravek\\prevedeno\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx", String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx");
            windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".fmx" + " to " + windowNunc.saveDir.getPath() + windowNunc.newLine);
            CopyFile.copyfile("Z:\\prevedi_za_popravek\\prevedeno\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx", String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx");
          }
          else if (windowNunc.getExtension(windowNunc.files[i]).equals("rdf")) {
            System.out.println("f: " + windowNunc.getFileName(windowNunc.files[i]) + ".rep");
            windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".rep" + " to " + windowNunc.openDir.getPath() + windowNunc.newLine);
            CopyFile.copyfile("Z:\\prevedi_za_popravek\\prevedeno\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep", String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep");
            windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".rep" + " to " + windowNunc.saveDir.getPath() + windowNunc.newLine);
            CopyFile.copyfile("Z:\\prevedi_za_popravek\\prevedeno\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep", String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep");
          }
          else if (windowNunc.getExtension(windowNunc.files[i]).equals("mmb")) {
            System.out.println("f: " + windowNunc.getFileName(windowNunc.files[i]) + ".mmx");
            windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".mmx" + " to " + windowNunc.openDir.getPath() + windowNunc.newLine);
            CopyFile.copyfile("Z:\\prevedi_za_popravek\\prevedeno\\" + windowNunc.getFileName(windowNunc.files[i]) + ".mmx", String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".mmx");
            windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".mmx" + " to " + windowNunc.saveDir.getPath() + windowNunc.newLine);
            CopyFile.copyfile("Z:\\prevedi_za_popravek\\prevedeno\\" + windowNunc.getFileName(windowNunc.files[i]) + ".mmx", String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + "mmx");
          } 
        } 
      } 
    } 
    windowNunc.go.setEnabled(true);
    windowNunc.patch.setEnabled(true);
  }
  
  public void zip() {
    ZipFiles zip = null;
    
    zip = new ZipFiles(windowNunc.openDir.getPath(), windowNunc.patchName);

    
    windowNunc.appendLogTextArea("Zip patch files " + windowNunc.openDir.getPath() + "\\" + windowNunc.patchName + ".zip" + windowNunc.newLine);
    windowNunc.zipFile = new File(String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.patchName + ".zip");
    System.out.println("zipFile path: " + windowNunc.zipFile.getPath());
    System.out.println("zipFile abs path: " + windowNunc.zipFile.getAbsolutePath());
    windowNunc.filesInZip = zip.FilesInZip(windowNunc.zipFile.getPath());
  }







  
  public void copy() {
    System.out.println("Kopiraj fajle iz " + windowNunc.zipFile.getPath() + " v " + windowNunc.saveDir.getPath() + "\\" + windowNunc.patchName + ".zip");
    windowNunc.appendLogTextArea("Copy " + windowNunc.zipFile.getPath() + " to " + windowNunc.saveDir.getPath() + "\\" + windowNunc.patchName + ".zip" + windowNunc.newLine);
    CopyFile.copyfile(windowNunc.zipFile.getPath(), String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.patchName + ".zip");
    
    System.out.println(windowNunc.saveDir.getPath().substring(0, windowNunc.saveDir.getPath().lastIndexOf("\\")));
  }



  
  public void delete() {
    if (!windowNunc.openDir.getPath().equals(windowNunc.saveDir.getPath())) {

      
      System.out.println("Brisi " + windowNunc.zipFile.getPath());
      windowNunc.appendLogTextArea("Delete " + windowNunc.zipFile.getPath() + windowNunc.newLine);
      windowNunc.deletefile(windowNunc.zipFile.getPath());
      System.out.println("Brisi " + windowNunc.openDir.getPath() + "\\pozeni.sql");
      windowNunc.appendLogTextArea("Delete " + windowNunc.openDir.getPath() + "\\pozeni.sql" + windowNunc.newLine);
      windowNunc.deletefile(String.valueOf(windowNunc.openDir.getPath()) + "\\pozeni.sql");

      
      for (int i = 0; i < windowNunc.files.length; i++) {
        if (windowNunc.files[i].isFile()) {
          System.out.println("getExtension(files[i])==.fmb or .rdf " + windowNunc.getExtension(windowNunc.files[i]));
          if (windowNunc.getExtension(windowNunc.files[i]).equals("fmx") || windowNunc.getExtension(windowNunc.files[i]).equals("rep") || windowNunc.getExtension(windowNunc.files[i]).equals("mmx")) {
            System.out.println("Brisi " + windowNunc.openDir.getPath() + "\\" + windowNunc.files[i].getName());
            windowNunc.appendLogTextArea("Delete " + windowNunc.openDir.getPath() + "\\" + windowNunc.files[i].getName() + windowNunc.newLine);
            windowNunc.deletefile(String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.files[i].getName());
          } 
        } 
      } 
    } 
  }



  
  protected String doInBackground() throws Exception {
    zip();
    copy();
    delete();
    return "D";
  }
}