@FunctionalInterface
interface CheckTrait {
	public boolean test(Animal a);
}

class Animal {
	private String name;
	private String species;
	private boolean canHop;
	private boolean canSwim;

	public Animal(String speciesName, boolean hopper, boolean swimmer) {
		species = speciesName;
		canHop = hopper;
		canSwim = swimmer;
	}

	public boolean canHop() {
		return canHop;
	}

	public boolean canSwim() {
		return canSwim;
	}

	public String getSpecies() {
		return species;
	}

	@Override
	public String toString() {
		return species;
	}

	@Override
	public boolean equals(Object inputAnimal) {
		if (! (inputAnimal instanceof Animal)) return false;

		Animal otherAnimal = (Animal) inputAnimal;

		if (otherAnimal.name.equals(this.name) & otherAnimal.getSpecies().equals(this.species)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		String strRep = this.name + this.species;
		int hashCode = strRep.hashCode();

		return hashCode;
	}
}

public class InterfaceDesign {
	private static void print(Animal animal, CheckTrait trait) {
		if (trait.test(animal)) {
			System.out.println(animal);
		}
	}

	public static void main(String[] args) {
		System.out.println("InterfaceDesign...");
		print(new Animal("fish", false, true), a -> a.canHop());
		print(new Animal("kangaroo", true, false), a -> a.canHop());	// should print kangaroo
	}
}