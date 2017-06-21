interface LivesInOcean {
	public void makeSound();
}

class Dolphin implements LivesInOcean {
	public void makeSound() {
		System.out.println("whistle");
	}
}

class Whale implements LivesInOcean {
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
	}
}