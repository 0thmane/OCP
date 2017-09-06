import java.io.Console;

public class ConsoleExample {
  private static final String PROMPT = "#:";

  public static void main(String[] args) {
    Console console = System.console();

    if (console != null) {
      String username = console.readLine("Username: ");
      char[] password = console.readPassword("Password: ");

      console.writer().println ("You entered the following credentials: " + username + ":" + String.valueOf(password));
    }
  }
}
