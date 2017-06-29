import java.util.*;

class Duck implements Comparable<Duck> {
	private String name;
	private int weight;

	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return this.name + " " + this.weight;
	}

	public int compareTo(Duck d) {
		return this.name.compareTo(d.name);
	}

	public int getWeight() {
		return this.weight;
	}

	public String getName() {
		return this.name;
	}
}

class DuckHelper {
	public static int compareByWeight(Duck d1, Duck d2) {
		return d1.getWeight() - d2.getWeight();
	}

	public static int compareByName(Duck d1, Duck d2) {
		return d1.getName().compareTo(d2.getName());
	}
}

public class Comparisson {
	public static void main(String[] args) {
		List<Duck> ducks = new ArrayList<>();
		ducks.add(new Duck("Quack!", 2));
		ducks.add(new Duck("Puddles", 3));

		Collections.sort(ducks); // Via the compareTo method

		System.out.println(ducks);

		// ----------------------------------------------------------------------------------------
		
		ducks.add(new Duck("Abraham", 1));

		System.out.println("Some ducks: " + ducks);

		Comparator<Duck> byWeight = (d1, d2) -> d1.getWeight() - d2.getWeight();
		Collections.sort(ducks, byWeight);

		System.out.println("Some sorted ducks: " + ducks);

		// ----------------------------------------------------------------------------------------

		Comparator<Duck> byName = DuckHelper::compareByName;
		Collections.sort(ducks, byName);

		System.out.println("\nDucks sorted by name: " + ducks);
	}
}