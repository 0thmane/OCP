import java.util.*;

public class Spaceship implements Comparable<Spaceship> {
	public final SpaceshipType TYPE;
	public final int CREW_CAPACITY;
	public final int ID;
	public final int FUEL_CAPACITY;

	private String name;
	private int fuel;
	private LocationType location;

	public Spaceship(String name, int startingFuel, int ID) {
		this.TYPE = EnumController.getRandomEnum(SpaceshipType.class);
		this.CREW_CAPACITY = TYPE.CREW_LIMIT;
		this.FUEL_CAPACITY = TYPE.FUEL_LIMIT;

		this.ID = ID;

		this.location = EnumController.getRandomEnum(LocationType.class);

		this.name = name;

		addFuel(startingFuel);
	}

	public String getName() {
		return this.name;
	}

	public int getFuel() {
		return this.fuel;
	}

	public void addFuel(int fuelAmount) {
		int emptyFuelCapacity = this.FUEL_CAPACITY - this.fuel;

		if (fuelAmount < 0) {
			throw new IllegalArgumentException("Cannot add negative fuel.");
		} else if(fuelAmount > emptyFuelCapacity) {
			this.fuel = this.FUEL_CAPACITY;
		} else {
			this.fuel += fuelAmount;
		}
	}

	public LocationType getLocation() {
		return this.location;
	}

	public void setLocation(LocationType location) {
		if (location == null) {
			throw new IllegalArgumentException("Location cannot be empty.");
		}
		
		this.location = location;
	}

	public int compareTo(Spaceship spaceship) {
		if (this.CREW_CAPACITY > spaceship.CREW_CAPACITY) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		String strRepresentation = "";

		strRepresentation += "Ship type: " + this.TYPE;
		strRepresentation += " Name: " + this.name;
		strRepresentation += " Location: " + getLocation();
		strRepresentation += " Capacity: " + this.CREW_CAPACITY;

		return strRepresentation;
	}

	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Spaceship)) return false;
	
		Spaceship spaceship = (Spaceship) obj;
		
		StringBuilder thisStrRep = new StringBuilder();
		StringBuilder otherStrRep = new StringBuilder();

		thisStrRep.append(this.TYPE);
		thisStrRep.append(this.ID);

		otherStrRep.append(spaceship.TYPE);
		otherStrRep.append(spaceship.ID);

		return thisStrRep.toString().equals(otherStrRep.toString());
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		String strRepresentation = this.ID + this.name + this.location;

		return strRepresentation.hashCode();
	}
}