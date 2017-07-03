/*
	TODO:
		1. Create Class
		2. Create unique variables
			- Type (ENUM)
			- Name
			- ID number
		3. Create dynamic variables
			- Location
			- Fuel
		4. Encapsulation methods for all variables
		5. Implement compareTo
		6. Implement comparators based on 
			- Location
			- Capacity
			- Fuel
		7. Implements equals() & hashCode()
		8. Implement toString()
*/

import java.util.*;

public class Spaceship {
	public final SpaceshipType TYPE;
	public final int CREW_CAPACITY;
	public final int ID;
	public final int FUEL_CAPACITY;

	private String name;
	private int fuel;
	private LocationType location;

	private Random random = new Random();

	// TODO : CONSTRUCTTORS
	public Spaceship(String name, int startingFuel) {
		this.TYPE = SpaceshipType.getRandomType();
		this.CREW_CAPACITY = TYPE.CREW_LIMIT;
		this.FUEL_CAPACITY = TYPE.FUEL_LIMIT;

		this.ID = random.nextInt(100000);

		this.location = LocationType.getRandomType();

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
}