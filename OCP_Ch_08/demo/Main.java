public class Main {
  private void generateShip(String shipName) {
    // TODO: Refactor to not use Stream
		Stream.generate(
			() -> new SpaceshipBuilder()
				.setSpaceshipType(EnumController.getRandomEnum(SpaceshipType.class))
				.setLocationType(EnumController.getRandomEnum(LocationType.class))
				.setId(random.nextInt(100000))
				.setName("HMS_Confusing")
				.build())
			.filter(ship -> ship.ID > 1000)
			.limit(numShips)
			.forEach(this::addShip);
	}

  private void runDemo() {}

  public static void main(String[] args) {
    runDemo();
  }
}
