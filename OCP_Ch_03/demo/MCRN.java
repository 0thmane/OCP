import java.util.*;

public final class MCRN {
	private Map<Integer, Spaceship> marsNavy = new HashMap<>();

	private String fleetAdmiral;
	private String fleetCommander;
	private String civilianCommander; 

	private Random random = new Random();

	public MCRN(String fleetAdmiral, String fleetCommander, String civilianCommander) {
		this(fleetAdmiral, fleetCommander, civilianCommander, 0);
	}

	public MCRN(String fleetAdmiral, String fleetCommander, String civilianCommander,
			int numRandomShips) {
		this.setFleetAdmiral(fleetAdmiral);
		this.setFleetCommander(fleetCommander);
		this.setCivilianCommander(civilianCommander);
		this.generateNavy(numRandomShips);
	}

	public void generateNavy(int numShips) {
		for (int i = 0; i < numShips; i++) {
			int randomShipId = random.nextInt(100000);
			SpaceshipType randomSpaceshipType = EnumController.getRandomEnum(SpaceshipType.class);
			LocationType randomLocationType = EnumController.getRandomEnum(LocationType.class);

			if (randomShipId < 1000) {
				i--;
			} else {
				Spaceship randomShip = new SpaceshipBuilder()
					.setSpaceshipType(randomSpaceshipType)
					.setLocationType(randomLocationType)
					.setId(randomShipId)
					.setFuel(randomSpaceshipType.getFuelLimit())
					.setName("HMS_Confusing")
					.build();

				boolean successfulInsert = addShip(randomShip);

				if (!successfulInsert) {
					i--;
				}
			}
		}
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

	public List<Spaceship> callEvacuationShips(int evacuatePeople, LocationType dispatchFrom) {
		Collection<Spaceship> marsNavyList = this.marsNavy.values();
		List<Spaceship> rescueShips = new ArrayList<>();

		int rescueCapacity = 0;

		for (Spaceship ship : marsNavyList) {
			if (ship.getLocation().equals(dispatchFrom)) {
				if (rescueCapacity > evacuatePeople) {
					break;
				} else {
					rescueShips.add(ship);
					rescueCapacity += ship.crewCapacity;
				}
			}
		}

		Comparator<Spaceship> byCapacity = (ship1, ship2) -> ship2.crewCapacity - ship1.crewCapacity;

		Collections.sort(rescueShips, byCapacity);

		System.out.println("\nTotal rescue capacity: " + rescueCapacity + "\n");

		return rescueShips;
	}

	@Override
	public String toString() {
		StringBuilder strRepresentation = new StringBuilder();

		strRepresentation.append("\n\tFLEET REGISTRAR\n");
		strRepresentation.append("\n\tCivilian Commander: \t" + this.civilianCommander);
		strRepresentation.append("\n\tFleet Admiral: \t\t" + this.fleetAdmiral);
		strRepresentation.append("\n\tFleet Commander: \t" + this.fleetCommander + "\n\n");

		marsNavy.forEach((key, ship) -> strRepresentation.append("\n\t" + ship));

		/* Alternative
		for (Map.Entry<Integer, Spaceship> ship : marsNavy.entrySet()) {
			strRepresentation.append("\n\t" + ship.getValue());
		}
		*/

		return strRepresentation.toString();
	}
}