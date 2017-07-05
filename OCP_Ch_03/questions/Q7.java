import java.util.*;

public class Q7 {
	public static void main(String[] args) {
		// Sorts in descending order, 
		Set<Number> numbers = new HashSet<>();
		numbers.add(new Integer(86));
		numbers.add(75);
		numbers.add(null);
		numbers.add(309L);
		numbers.add(4);

		Iterator iter = numbers.iterator();

		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}