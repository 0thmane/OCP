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

		
	}
}