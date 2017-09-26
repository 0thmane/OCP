import java.io.File;

public class FileManipulator {
  private static final String DB_LOCATION = "data/";
  private static final String EXTENSION = ".data";

  public FileManipulator() {
    File dbFolder = new File(DB_LOCATION);

    if (!dbFolder.exists()) {
      dbFolder.mkdir();
    }
  }

  private boolean existsFile(String filename) {
    File potentialFile = new File(DB_LOCATION + filename + EXTENSION);
    return potentialFile.exists();
  }

  public static void main(String[] args) {
    FileManipulator fileManipulator = new FileManipulator();
    System.out.println();
  }
}
