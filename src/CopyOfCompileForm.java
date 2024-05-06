import java.io.File;

public class CopyOfCompileForm
  implements Runnable
{
  public void compile() {
    windowNunc.go.setEnabled(false);
    windowNunc.patch.setEnabled(false);
    for (int i = 0; i < windowNunc.files.length; i++) {
      if (windowNunc.files[i].isFile()) {
        System.out.println("windowNunc.getExtension(windowNunc.files[i])==.fmb or .rdf " + windowNunc.getExtension(windowNunc.files[i]));
        if (windowNunc.getExtension(windowNunc.files[i]).equals("fmb") || windowNunc.getExtension(windowNunc.files[i]).equals("rdf")) {
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
            CopyFile.copyfile("Z:\\prevedi_za_popravek\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx", String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx");
            windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".fmx" + " to " + windowNunc.saveDir.getPath() + windowNunc.newLine);
            CopyFile.copyfile("Z:\\prevedi_za_popravek\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx", String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".fmx");
          }
          else if (windowNunc.getExtension(windowNunc.files[i]).equals("rdf")) {
            System.out.println("f: " + windowNunc.getFileName(windowNunc.files[i]) + ".fmx");
            windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".rep" + " to " + windowNunc.openDir.getPath() + windowNunc.newLine);
            CopyFile.copyfile("Z:\\prevedi_za_popravek\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep", String.valueOf(windowNunc.openDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep");
            windowNunc.appendLogTextArea("Copy " + windowNunc.getFileName(windowNunc.files[i]) + ".rep" + " to " + windowNunc.saveDir.getPath() + windowNunc.newLine);
            CopyFile.copyfile("Z:\\prevedi_za_popravek\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep", String.valueOf(windowNunc.saveDir.getPath()) + "\\" + windowNunc.getFileName(windowNunc.files[i]) + ".rep");
          } 
        } 
      } 
    } 
    windowNunc.go.setEnabled(true);
    windowNunc.patch.setEnabled(true);
  }

  
  public void run() {
    compile();
    windowNunc.compileFormFinished = true;
  }
}