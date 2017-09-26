import java.nio.file.Path;
import java.nio.file.Paths;

public class FilePathSample {
  private static void printPathInfo(Path path) {
    System.out.println("Filename is: " + path.getFileName());
    System.out.println("Root is: " + path.getRoot());

    Path currentParent = path;

    while((currentParent = currentParent.getParent()) != null) {
      System.out.println("    Current parent is: " + currentParent);
    }
  }

  public static void main(String[] args) {
    printPathInfo(Paths.get("/FilePathSample.java"));
  }
}
