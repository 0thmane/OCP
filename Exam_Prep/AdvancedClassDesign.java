import java.util.Random;
import java.util.stream.Stream;

public class AdvancedClassDesign {
  public static void main(String[] args) {
    Warship warship = (Warship) ShipFactory.getShip(ShipType.WARSHIP);
    Random random = new Random();

    Stream.generate(
        () -> new WarshipBuilder()
                .withId(random.nextInt(100))
                .withShipType(ShipType.WARSHIP)
                .build())
      .limit(10)
      .forEach(System.out::println);
  }
}

// ======================================================================================================================================
enum ShipType {
  SAILBOAT,
  WARSHIP
}

// ======================================================================================================================================
abstract class Ship {}

// ======================================================================================================================================
class Warship extends Sailboat {
  public Warship(int id, ShipType shipType) {
    super(id, shipType);
  }
}

// ======================================================================================================================================
class Sailboat extends Ship {
  private final int id;
  private final ShipType shipType;
  private String name;
  private Engine engine;

  public Sailboat(int id, ShipType shipType) {
    this.id = id;
    this.shipType = shipType;
  }

  public int getId() {
    return this.id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public ShipType getShipType() {
    return this.shipType;
  }

  @Override
  public String toString() {
    String strRep = "Ship with id: " + this.id + " of type: " + this.shipType;

    return strRep;
  }

  static class Engine {
    private double powerOutput = 12.45;

    public double getPowerOutput() {
      return powerOutput;
    }
  }
}

// ======================================================================================================================================
class WarshipBuilder {
  private int id;
  private String name;
  private ShipType shipType;

  public WarshipBuilder withId(int id) {
    this.id = id;
    return this;
  }

  public WarshipBuilder withName(String name) {
    this.name = name;
    return this;
  }

  public WarshipBuilder withShipType(ShipType shipType) {
    this.shipType = shipType;
    return this;
  }

  public Warship build() {
    Warship newShip = new Warship(id, shipType);
    newShip.setName(name);

    return newShip;
  }
}

// ======================================================================================================================================
class ShipFactory {
  private static Random random = new Random();

  public static Ship getShip(ShipType shipType) {
    switch (shipType) {
      case SAILBOAT:
        return new Sailboat(random.nextInt(9999), shipType);
      case WARSHIP:
        return new Warship(random.nextInt(9999), shipType);
      default:
        throw new RuntimeException();
    }
  }
}
