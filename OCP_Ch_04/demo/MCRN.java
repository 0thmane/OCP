import java.util.*;
import java.util.stream.Stream;

public final class MCRN {
	private Map<Integer, Spaceship> marsNavy = new HashMap<>();

	private String fleetAdmiral;
	private String fleetCommander;
	private String civilianCommander; 

	private Random random = new Random();

	public MCRN(String fleetAdmiral, String fleetCommander, String civilianCommander,
			int numRandomShips) {
		this.setFleetAdmiral(fleetAdmiral);
		this.setFleetCommander(fleetCommander);
		this.setCivilianCommander(civilianCommander);
		this.generateNavy(numRandomShips);
	}

	// Refactored
	public void generateNavy(int numShips) {
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

	public boolean addShip(Spaceship newShip) {
		if (!(newShip instanceof Spaceship)) {
			throw new IllegalArgumentException("Cannot add an object that isn't a Spaceship" + 
				" to navy fleet.");
		} else if (newShip == null) {
			throw new IllegalArgumentException("Cannot add null to navy fleet.");
		}

		if (this.marsNavy.containsKey(newShip.ID)) {
			return false;
		}

		this.marsNavy.put(newShip.ID, newShip);

		return true;
	}

	public void setFleetAdmiral(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("Invalid fleet admiral name");
		}

		this.fleetAdmiral = name;
	}

	public String getFleetAdmiral() {
		return this.fleetAdmiral;
	}

	public void setFleetCommander(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("Invalid fleet admiral name");
		}

		this.fleetCommander = name;
	}

	public String getFleetCommander() {
		return this.fleetCommander;
	}

	public void setCivilianCommander(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("Invalid fleet admiral name");
		}

		this.civilianCommander = name;
	}

	public String getCivilianCommander() {
		return this.civilianCommander;
	}

	// Refactored
	public List<Spaceship> callEvacuationShips(int evacuatePeople, LocationType dispatchFrom) {
		Collection<Spaceship> marsNavyList = this.marsNavy.values();
		List<Spaceship> potentialRescueShips = new ArrayList<>();
		List<Spaceship> desiredRescueShips = new ArrayList<>();

		Comparator<Spaceship> byCapacity = (ship1, ship2) -> ship2.crewCapacity - ship1.crewCapacity;

		int rescueCapacity = 0;

		marsNavyList
			.stream()
			.filter(ship -> ship.getLocation().equals(dispatchFrom))
			.sorted(byCapacity)
			.forEach(potentialRescueShips::add);


		// This loop can be replaces with takeWhile in Java 9
		for (Spaceship ship : potentialRescueShips) {
			if (rescueCapacity < evacuatePeople) {
				desiredRescueShips.add(ship);
				rescueCapacity += ship.crewCapacity;
			}
		}

		System.out.println("\nTotal rescue capacity: " + rescueCapacity + "\n");

		return desiredRescueShips;
	}

	@Override
	public String toString() {
		StringBuilder strRepresentation = new StringBuilder();

		strRepresentation.append("\n\tFLEET REGISTRAR\n");
		strRepresentation.append("\n\tCivilian Commander: \t" + this.civilianCommander);
		strRepresentation.append("\n\tFleet Admiral: \t\t" + this.fleetAdmiral);
		strRepresentation.append("\n\tFleet Commander: \t" + this.fleetCommander + "\n\n");

		marsNavy.forEach((key, ship) -> strRepresentation.append("\n\t" + ship));

		return strRepresentation.toString();
	}
}