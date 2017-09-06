import java.io.File;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileWriter;

import java.io.IOException;

public class PrintWriterSample {
  public static void main(String[] args) {
    File source = new File("data/zoo.log");

    try (PrintWriter out = new PrintWriter(
          new BufferedWriter(
            new FileWriter(source)
          )
        )) {
      out.print("Today's weather is: ");
      out.println("Sunny");
      out.print("Today's temperature at the zoo is: ");
      out.print(1/3.0);
      out.println('C');
      out.format("It has rained 10.12 inches this year");
      out.println();
      out.printf("It may rain 21.2 more inches this year");
    } catch (IOException e) {}
  }
}
