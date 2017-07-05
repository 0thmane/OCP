import java.util.*;

public class Q4	{
	public static void main(String[] args) {
		ArrayDeque<String> greetings = new ArrayDeque<String>();

		// Push will make this structure act as LIFO
		// 		Use offer for FIFO
		greetings.push("hello");
		greetings.push("hi");
		greetings.push("ola");

		greetings.pop();
		greetings.peek();

		while (greetings.peek() != null) {
			System.out.println(greetings.pop());
		}
	}
}