public class SpaceshipBuilder {
	private SpaceshipType spaceshipType;
	private LocationType locationType;
	private int id;
	private int fuel;

	private String name;
	
	public SpaceshipBuilder setSpaceshipType(SpaceshipType spaceshipType) {
		this.spaceshipType = spaceshipType;

		return this;
	}

	public SpaceshipBuilder setLocationType(LocationType locationType) {
		this.locationType = locationType;

		return this;
	}

	public SpaceshipBuilder setId(int id) {
		this.id = id;

		return this;
	}

	public SpaceshipBuilder setFuel(int fuel) {
		this.fuel = fuel;

		return this;
	}

	public SpaceshipBuilder setName(String name) {
		this.name = name;

		return this;
	}

	public Spaceship build() {
		return new Spaceship(name, fuel, id, spaceshipType, locationType);
	}
}