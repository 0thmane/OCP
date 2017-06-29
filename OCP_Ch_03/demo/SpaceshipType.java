/*
	TODO:
		1. Add more Enums
		2. Move getRandomType to a Generic
*/

import java.util.*;

public enum SpaceshipType {
	SHUTTLE(0, 0),
	LIGHT_CARGO(0, 0),
	HEAVY_CARGO(0, 0),
	DESTROYER(0, 0),
	CRUISER(0, 0),
	MARINE_LANDER(0, 0),
	CORVETTE(0, 0);

	public final int FUEL_LIMIT;
	public final int CREW_LIMIT;

	private Random random = new Random();

	private SpaceshipType(int fuelLimit, int crewLimit) {
		this.FUEL_LIMIT = fuelLimit;
		this.CREW_LIMIT = crewLimit;
	}

	public SpaceshipType getRandomType() {
		LocationType[] spaceshipTypes = LocationType.values();
		int numTypes = spaceshipTypes.length;

		int randomShip = random.nextInt(numTypes);

		return spaceshipTypes[randomShip];
	}
}