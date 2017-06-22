interface LivesInOcean {
	public void makeSound();
}

class Mammal {
	public int age = 0;

	public boolean hasHair() {
		System.out.println("No hair");
		return false;
	}

	public void printAge() {
		System.out.println(this.age);
	}
}

class Dolphin extends Mammal implements LivesInOcean {
	public int age = 10;

	public void makeSound() {
		System.out.println("whistle");
	}

	public boolean likesToPlay() {
		System.out.println("Likes to play");
		return true;
	}

	public void printAge() {
		System.out.println(this.age);
	}
}

class Whale extends Mammal implements LivesInOcean {
	public void makeSound() {
		System.out.println("sing");
	}
}

class Oceanographer {
	public void checkSound(LivesInOcean animal) {
		animal.makeSound();
	}
}

public class Polymorphism {
	public static void main(String[] args){
		Dolphin dolphin = new Dolphin();
		Whale whale = new Whale();
		Oceanographer oceanographer = new Oceanographer();

		oceanographer.checkSound(dolphin);
		oceanographer.checkSound(whale);

		// ------------------------------------------------------

		whale.hasHair();

		Mammal mammal = whale;
		mammal.hasHair();

		mammal.printAge();

		LivesInOcean lio = dolphin;
		lio.makeSound();

		Dolphin dolphin2 = new Dolphin();
		dolphin2.printAge();

		// ------------------------------------------------------

		
	}
}