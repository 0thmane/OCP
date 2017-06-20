public class Swimmer {
	enum AnimalClasses {
		MAMMAL, BIRD, REPTILE, AMPHIBIAN, INVERTEBRATE,
		FISH {
			public boolean hasFins() {return true;}
		};

		// Compiler error: Cannot instantiate abstract enums, each would have to override this method
		//public abstract boolean hasFins();

		public boolean hasFins() {
			return true;
		}
	}

	public static void main(String[] args) {
		System.out.println(AnimalClasses.FISH);
		System.out.println(AnimalClasses.FISH.ordinal());
		System.out.println(AnimalClasses.FISH.hasFins());
		System.out.println(AnimalClasses.BIRD.hasFins());
	}
}