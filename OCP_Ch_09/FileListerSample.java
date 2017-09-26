import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.stream.Collectors;
import java.io.IOException;

public class FileListerSample {

  private static void printHiddenFiles(Path path) throws IOException {}


  public static void main(String[] args) {
    try {
      printHiddenFiles(Paths.get("FileListerSample.java"));
    } catch (IOException io) {
      System.out.println("IOException: " + io);
    } catch (Exception e) {
      System.out.println("Exception: " + e);
    }
  }
}
