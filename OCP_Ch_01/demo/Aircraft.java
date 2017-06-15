import java.lang.Math;

public abstract class Aircraft {
	public static final String TYPE = "";
	public static final String ID = "";

	public static final int FUEL_CAPACITY = 0;
	public static final int FUEL_RATE = 0;
	public static final int MIN_TAKEOFF_TIME = 0;

	public int currentFuel = 0;

	public int getFuel() {
		return this.currentFuel;
	}

	public int addFuel() {
		if (this.fullyFuelled()) return 0;

		int fuelingTime = 0;
		int requiredFuel = this.FUEL_CAPACITY - this.currentFuel;

		fuelingTime = Math.round(requiredFuel / this.FUEL_RATE);

		return fuelingTime;
	}

	public boolean fullyFuelled() {
		return this.currentFuel == this.FUEL_CAPACITY;
	}

	public String toString() {
		String strRepresentation = "";

		strRepresentation += "Type: " + this.TYPE;
		strRepresentation += " ID: " + this.ID;
		strRepresentation += " FUEL: " + this.currentFuel + " / " + this.FUEL_CAPACITY;

		return strRepresentation;
	}

	public String toHash() {
		String strHash = "";

		return strHash;
	}

	public int scramble() {
		int scrambleTime = this.addFuel() + this.MIN_TAKEOFF_TIME;

		return scrambleTime;
	}
}