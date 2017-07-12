import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Streams {
	private static Optional<Double> average(int... scores) {
		if (scores.length == 0) return Optional.empty();

		int sum = 0;

		for (int score : scores) {
			sum += score;
		}

		return Optional.of((double) sum / scores.length);
	}

	public static void main(String[] args) {

		// ----------------------------------------------------------------------------------------
		System.out.println("--------------------------------------");

		List<String> someList = new ArrayList<>();
		someList.add("hello");
		someList.add("world");

		someList.forEach(System.out::println);

		// ----------------------------------------------------------------------------------------
		System.out.println("--------------------------------------");

		Predicate<? super String> predicate = s -> s.startsWith("g");
		Stream<String> stream1 = Stream.generate(() -> "growl!");
		Stream<String> stream2 = Stream.generate(() -> "growl!");
		boolean b1 = stream1.limit(1).anyMatch(predicate); // Will hang without limit
		boolean b2 = stream2.limit(1).allMatch(predicate); // Will hang without limit
		System.out.println(b1 + " " + b2);

		// ----------------------------------------------------------------------------------------
		System.out.println("--------------------------------------");

		Predicate<? super String> predicate2 = s -> s.length() > 3;
		Stream<String> stream3 = Stream.iterate("-", (s) -> s + s);
		boolean b3 = stream3.noneMatch(predicate2);		// Terminal operation

		// Cannot use above stream, it's been destroyed
		//boolean b4 = stream3.anyMatch(predicate2); 	

		System.out.println(b1 + " " + b2);

		// ----------------------------------------------------------------------------------------
		System.out.println("--------------------------------------");
		
		Optional<Double> someDouble = average(50, 555);
		someDouble.ifPresent(System.out::println);
	}
}