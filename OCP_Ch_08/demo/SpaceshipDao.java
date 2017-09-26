import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.io.File;
import java.io.IOException;

public class SpaceshipDao {

  private static final String DB_LOCATION = "db/";
  private static final String EXTENSION = ".sp";

  private SpaceshipDao() {}

  public static boolean existsShip(int id) {
    boolean exists = false;

    File potentialFile = new File(DB_LOCATION + String.valueOf(id) + EXTENSION);
    exists = potentialFile.exists();

    return exists;
  }

  public static boolean writeShip(Spaceship newShip, boolean overwrite) throws ShipExistsException {
    boolean success = false;

    if (existsShip(newShip.ID) & !overwrite) {
      throw new ShipExistsException();
    }

    serializeShip(newShip);

    return success;
  }

  public static Spaceship readShip(int id) throws ShipNotFoundException {
    Spaceship storedSpaceship = null;

    if (existsShip(newShip.ID)) {
      File potentialFile = new File(DB_LOCATION + String.valueOf(id) + EXTENSION);
      storedSpaceship = deserializeShip(potentialFile);
    } else {
      throw new ShipNotFoundException();
    }

    return storedSpaceship;
  }

  public static boolean deleteShip(int id) {
    boolean success = false;

    if (existsShip(newShip.ID)) {
      File shipFile = new File(DB_LOCATION + String.valueOf(id) + EXTENSION);
      shipFile.delete();
    } else {
      throw new RuntimeException("Ship with id " + id + "could not be found.");
    }

    return success;
  }

  // TODO
  public static void writeAll(List<Spaceship> shipList, boolean overwrite) {
    List<Spaceship> allShips = new ArrayList<>();

    for (Spaceship ship : allShips) {
      writeShip(ship, overwrite);
    }

    return allShips;
  }

  // TODO
  public static List<Spaceship> readAll() throws ShipExistsException {
    List<Spaceship> allShips = new ArrayList<>();

    File root = new File(DB_LOCATION);

    return allShips;
  }

  // TODO
  private static boolean serializeShip(Spaceship ship) {
    boolean success = false;

    return success;
  }

  // TODO
  private static Spaceship deserializeShip(int shipFile) {
    Spaceship ship = null;

    return ship;
  }
}
