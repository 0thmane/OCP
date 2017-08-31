import java.io.File;
import java.io.IOException;

public class SpaceshipDao {
  private static final String FILENAME = "SpaceshipsDB.csv";
  private static final String FIELD_DELIMITER = ",";
  private static final File spaceshipDb = new File(FILENAME);

  public void SpaceshipDao() throws IOException {
    if (!spaceshipDbExists()) {
      createSpaceshipDb();
    }
  }

  // TODO
  public static boolean writeShip(Spaceship newShip) {
    boolean success = false;

    return success;
  }

  // TODO
  public static Spaceship readShip(int ID) {
    Spaceship storedSpaceship = null;

    return storedSpaceship;
  }

  private boolean spaceshipDbExists() {
    return spaceshipDb.exists();
  }

  // TODO
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
