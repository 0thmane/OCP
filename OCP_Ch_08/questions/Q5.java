import java.io.Console;
import java.io.Writer;
import java.io.IOException;

public class Q5 {
  public static void main(String[] args) throws IOException {
    String line;
    Console c = System.console();
    Writer w = c.writer();
    if ((line = c.readLine()) != null)
      w.append(line);
    w.flush();
  }
}
