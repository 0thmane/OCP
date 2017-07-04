/*
	TODO:
		1. Add more Enums
		2. Move getRandomType to a Generic
*/

import java.util.*;

public enum SpaceshipType {
	// (fuelLimit, crewLimit)
	SHUTTLE(50, 5),
	LIGHT_CARGO(250, 45),
	HEAVY_CARGO(1250, 100),
	DESTROYER(4000, 500),
	CRUISER(2500, 250),
	MARINE_LANDER(7000, 175),
	CORVETTE(1750, 100);

	public final int FUEL_LIMIT;
	public final int CREW_LIMIT;

	private static Random random = new Random();

	private SpaceshipType(int fuelLimit, int crewLimit) {
		this.FUEL_LIMIT = fuelLimit;
		this.CREW_LIMIT = crewLimit;
	}
}