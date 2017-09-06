import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class SpaceshipDao {
  private static final String FILENAME = "db/SpaceshipsDB.csv";
  private static final String FIELD_DELIMITER = ",";
  private static final File spaceshipDb = new File(FILENAME);

  public SpaceshipDao() {
    if (!spaceshipDbExists()) {
      try {
          createSpaceshipDb();
      } catch (IOException e) {
        throw new RuntimeException("Error occured in SpaceshipDao initialization");
      }
    }
  }

  // TODO
  public static boolean writeShip(Spaceship newShip) throws ShipExistsException {
    boolean success = false;

    if (readShip(newShip.ID) != null) {
      throw new ShipExistsException();
    }

    // Write the ship to db

    return success;
  }

  // TODO
  public static Spaceship readShip(int ID) {
    Spaceship storedSpaceship = null;

    return storedSpaceship;
  }

  // TODO
  public static void writeAll(List<Spaceship> shipList) {}

  // TODO
  public static List<Spaceship> readAll() {
    List<Spaceship> allShips = new ArrayList<>();

    return allShips;
  }

  private boolean spaceshipDbExists() {
    return spaceshipDb.exists();
  }

  private void createSpaceshipDb() throws IOException {
    spaceshipDb.createNewFile();
  }

  // TODO
  private String strSpaceshipRepresentation(Spaceship spaceship) {
    String strRepresentation = "";

    return strRepresentation;
  }

  // TODO
  private Spaceship parseStrSpaceshipRepresentation(String strSpaceshipRepresentation) {
    Spaceship resultingSpaceship = null;

    return resultingSpaceship;
  }
}
