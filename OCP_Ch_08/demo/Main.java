import java.util.Random;
import java.util.stream.Stream;

import java.io.Console;

public class Main {

  private static Random random = new Random();
  private static Console console = System.console();
  private static SpaceshipDao spaceshipDao = new SpaceshipDao();

  private static Spaceship generateShip(String shipName) {
    int randomShipId = random.nextInt(1000);

    return generateShip(shipName, randomShipId);
	}

  private static Spaceship generateShip(String shipName, int shipId) {
    SpaceshipType randomShipType = EnumController.getRandomEnum(SpaceshipType.class);
    LocationType randomLocationType = EnumController.getRandomEnum(LocationType.class);

    Spaceship newShip = new SpaceshipBuilder()
        .setSpaceshipType(randomShipType)
        .setLocationType(randomLocationType)
        .setId(shipId)
        .setName(shipName)
        .build();

    return newShip;
  }

  private static void storeRandomShips(int numShips, int idLimit) {
    Stream.generate(() -> generateShip("MCRN Confusing"))
			.filter(ship -> ship.ID < idLimit)
			.limit(numShips)
			.forEach(ship -> {
        try {
          spaceshipDao.writeShip(ship);
        } catch (ShipExistsException e) {
          // That's fine...
        }
      });
  }

  public static void runDemo() {
    try {
      Spaceship roci = generateShip("MCRN Rocinante", 0);
      spaceshipDao.writeShip(roci);
    } catch (ShipExistsException e) {}

    Spaceship storedRoci = spaceshipDao.readShip(roci.ID);
    console.writer().println(storedRoci);
  }

  public static void main(String[] args) {
    runDemo();
  }
}
