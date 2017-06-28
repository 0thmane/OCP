import java.util.*;

class A {}

class B {}

class Submarine {
	private String name = "test";

	@Override
	public String toString() {
		return this.name;
	}
}

public class Bounds {
	public static void main(String[] args) {
		// Unbounded 	- Immutable
		List<?> unboundedList = new ArrayList<String>();

		// Upper Bound 	- Immutable
		List<? extends Exception> upperBoundedList = new ArrayList<RuntimeException>();

		// Lower Bound 	- Immutable
		List<? super Exception> lowerBoundedList = new ArrayList<Object>();

		// ----------------------------------------------------------------------------------------
		
		List<Submarine> someSubList = Arrays.asList(new Submarine());

		printList(someSubList);

		// ----------------------------------------------------------------------------------------


	}

	private static void printList(List<?> list) {
		for (Object x : list) {
			System.out.println(x);
		}
	}

	private <T> T method1(List<? extends T> list) {
		return list.get(0);
	}

	private <X> void method2(List<? extends B> list) {}
}