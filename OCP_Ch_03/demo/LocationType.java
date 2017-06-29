/*
	TODO:
		1. Move getRandomType to a Generic
*/

import java.util.*;

public enum LocationType {
	MERCURY("Mercury"),
	VENUS("Venus"),
	EARTH("Earth"),
	MARS("Mars"),
	JUPITER("Jupiter"),
	SATURN("Saturn"),
	URANUS("Uranus"),
	NEPTUNE("Neptune"),
	PLUTO("Pluto"),
	IN_TRANSIT("In transit"),
	CLASSIFIED("Classified");

	private Random random = new Random();

	public String location;

	private LocationType(String location) {
		this.location = location;
	}

	public LocationType getRandomType() {
		LocationType[] locationTypes = LocationType.values();
		int numLocations = locationTypes.length;

		int randomLocation = random.nextInt(numLocations);

		return locationTypes[randomLocation];
	}

	@Override
	public String toString() {
		return this.location;
	}
}