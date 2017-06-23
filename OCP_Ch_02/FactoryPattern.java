abstract class Food {
	private int quantity;

	public Food(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public abstract void consumed();
}

class Hay extends Food {
	public Hay(int quantity) {
		super(quantity);
	}

	public void consumed() {
		System.out.println("Hay eaten: " + getQuantity());
	}
}

class Pellets extends Food {
	public Pellets(int quantity) {
		super(quantity);
	}

	public void consumed() {
		System.out.println("Pellets eaten: " + getQuantity());
	}
}

class Fish extends Food {
	public Fish(int quantity) {
		super(quantity);
	}

	public void consumed() {
		System.out.println("Fish eaten: " + getQuantity());
	}
}

class FoodFactory {
	public static Food getFood(String animalName) {
		switch(animalName) {
			case "zebra": 
				return new Hay(100);
			case "rabbit":
				return new Pellets(5);
			case "goat":
				return new Pellets(30);
			case "polar bear":
				return new Fish(10);
		}

		throw new UnsupportedOperationException("Unsupported animal: " + animalName);
	}
}

public class FactoryPattern {
	public static void main(String[] args) {
		final Food food = FoodFactory.getFood("goat");
		food.consumed();
	}
}