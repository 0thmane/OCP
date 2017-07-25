package src.main.java;

import java.util.*;

public class Spaceship implements Comparable<Spaceship> {
	public final SpaceshipType type;
	public final int crewCapacity;
	public final int fuelCapacity;
	public final int ID;

	private String name;
	private int fuel;
	private LocationType location;

	public Spaceship(String name, int startingFuel, int id, SpaceshipType type, 
			LocationType location) {
		this.type = type;
		this.crewCapacity = type.getCrewLimit();
		this.fuelCapacity = type.getFuelLimit();

		this.ID = id;

		this.location = location;

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
		int emptyFuelCapacity = this.fuelCapacity - this.fuel;

		if (fuelAmount < 0) {
			throw new IllegalArgumentException("Cannot add negative fuel.");
		} else if(fuelAmount > emptyFuelCapacity) {
			this.fuel = this.fuelCapacity;
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
		if (this.crewCapacity > spaceship.crewCapacity) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public String toString() {
		StringBuilder strRepresentation = new StringBuilder();

		strRepresentation.append("Ship type: " + this.type);
		strRepresentation.append("\tName: " + this.name);
		strRepresentation.append("\tID: " + this.ID);
		strRepresentation.append("\tCapacity: " + this.crewCapacity);
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

		thisStrRep.append(this.type);
		thisStrRep.append(this.ID);

		otherStrRep.append(spaceship.type);
		otherStrRep.append(spaceship.ID);

		return thisStrRep.toString().equals(otherStrRep.toString());
	}

	@Override
	public int hashCode() {
		int hashCode = 1;
		
		hashCode = hashCode * 5 + this.type.hashCode();
		hashCode = hashCode * 3 + new String("" + this.ID).hashCode();

		return hashCode;
	}
}