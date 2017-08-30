import java.util.*;

public enum SpaceshipType {
	// TYPE_NAME(fuelLimit, crewLimit)
	SHUTTLE(50, 5),
	LIGHT_CARGO(250, 45),
	MEDIUM_CARGO(750, 75),
	HEAVY_CARGO(1250, 100),
	DESTROYER(4000, 500),
	CRUISER(2500, 250),
	TROOP_LANDER(7000, 175),
	CORVETTE(1750, 100);

	private int fuelLimit;
	private int crewLimit;

	private SpaceshipType(int fuelLimit, int crewLimit) {
		this.fuelLimit = fuelLimit;
		this.crewLimit = crewLimit;
	}

	public int getFuelLimit() {
		return this.fuelLimit;
	}

	public int getCrewLimit() {
		return this.crewLimit;
	}
}
