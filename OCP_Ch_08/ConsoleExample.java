import java.util.Arrays;

import java.io.Console;
import java.io.IOException;

public class ConsoleExample {
  private static final String PROMPT = "#:";

  private static Console console = System.console();

  private static void userInfoEcho() {
    if (console != null) {
      String username = console.readLine("Username: ");
      char[] password = console.readPassword("Password: ");

      console.writer().println("You entered the following credentials: " + username + ":" + String.valueOf(password));
    }
  }

  private static boolean resetPassword() throws NumberFormatException, IOException {
    boolean newPasswordValid = false;

    char[] oldPassword = console.readPassword("Old password: ");
    char[] newPassword = console.readPassword("New password: ");
    char[] newPasswordConfirmed = console.readPassword("New password again: ");

    newPasswordValid = Arrays.equals(newPassword, newPasswordConfirmed);

    secureSensativeArrays(oldPassword, newPassword, newPasswordConfirmed);

    console.flush(); // Ensure there's nothing left in the buffer

    return newPasswordValid;
  }

  private static void secureSensativeArrays(char[]... sensativeArrays) {
    for (char[] sensativeArray : sensativeArrays) {
      if (sensativeArray != null) {
        for (int i = 0; i < sensativeArray.length; i++) {
          sensativeArray[i] = 'x';
        }
      }
    }
  }

  public static void main(String[] args) {
    try {
      String comment = resetPassword() ? "\nPassword updated.\n" : "\nNew password missmatch.\n";
      console.writer().println(comment);
    } catch(IOException e) {}
  }
}
