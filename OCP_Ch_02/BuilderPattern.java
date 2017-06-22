import java.util.*;

final class Canine {
	private final String species;
	private final int age;
	private List<String> favoriteFoods;

	public Canine(String species, int age, List<String> favoriteFoods) {
		this.species = species;
		this.age = age;

		if (favoriteFoods == null) {
			throw new RuntimeException("favoriteFoods is required.");
		}

		this.favoriteFoods = new ArrayList<String>(favoriteFoods);
	}

	public String getSpecies() {
		return this.species;
	}

	public int getAge() {
		return this.age;
	}

	public int getFavoriteFodoCount() {
		return this.favoriteFoods.size();
	}

	public String getFavoriteFood(int index) {
		return this.favoriteFoods.get(index);
	}

	@Override
	public String toString() {
		String strRepresentation = "";

		strRepresentation += species + " " + age + " " + favoriteFoods;

		return strRepresentation;
	}
}

class CanineBuilder {
	private String species;
	private int age;
	private List<String> favoriteFoods;

	public CanineBuilder setAge(int age) {
		this.age = age;
		return this;
	}

	public CanineBuilder setSpecies(String species) {
		this.species = species;
		return this;
	}

	public CanineBuilder setFavoriteFoods(List<String> favoriteFoods) {
		this.favoriteFoods = favoriteFoods;
		return this;
	}

	public Canine build() {
		return new Canine(species, age, favoriteFoods);
	}
}

public class BuilderPattern {
	public static void main(String[] args) {
		CanineBuilder canineBuilder = new CanineBuilder();

		canineBuilder
			.setAge(5)
			.setSpecies("Husky")
			.setFavoriteFoods(Arrays.asList("baguette"));

		Canine husky = canineBuilder.build();

		Canine laika = new CanineBuilder()
			.setFavoriteFoods(Arrays.asList("dog treats"))
			.setSpecies("Sheppard")
			.build();

		System.out.println(laika);
	}
}