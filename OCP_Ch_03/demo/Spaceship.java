import java.util.*;

public class Spaceship implements Comparable<Spaceship> {
	public final SpaceshipType TYPE;
	public final int CREW_CAPACITY;
	public final int ID;
	public final int FUEL_CAPACITY;

	private String name;
	private int fuel;
	private LocationType location;

	public Spaceship(String name, int startingFuel, int id) {
		this.TYPE = EnumController.getRandomEnum(SpaceshipType.class);
		this.CREW_CAPACITY = TYPE.CREW_LIMIT;
		this.FUEL_CAPACITY = TYPE.FUEL_LIMIT;

		this.ID = id;

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
		StringBuilder strRepresentation = new StringBuilder();

		strRepresentation.append("Ship type: " + this.TYPE);
		strRepresentation.append("\tName: " + this.name);
		strRepresentation.append("\tID: " + this.ID);
		strRepresentation.append("\tCapacity: " + this.CREW_CAPACITY);
		strRepresentation.append("\tLocation: " + getLocation());

		return strRepresentation.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Spaceship)) return false;
	
		if (this == obj) return true;

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
		int hashCode = 1;
		
		hashCode = hashCode * 5 + this.TYPE.hashCode();
		hashCode = hashCode * 3 + new String("" + this.ID).hashCode();

		return hashCode;
	}
}