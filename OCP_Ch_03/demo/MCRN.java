/*
	TODO:
		1. Implement Spaceship comparators based on 
			- Capacity
		3. Constructors
*/

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
			int randomShipId = random.nextInt(10000);

			Spaceship randomShip = new Spaceship("HMS_Confusing", 0, randomShipId);

			boolean successfulInsert = addShip(randomShip);

			if (!successfulInsert) {
				i--;
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

	public SortedMap<Integer, Spaceship> callEvacuationShips(int evacuatePeople, 
			LocationType dispatchFrom) {
		SortedMap<Integer, Spaceship> evacuationShips = new TreeMap<>();

		/*
		for (Map.Entry<Integer, Spaceship> someShip : marsNavy.entrySet()) {
			evacuationShips.put(someShip);
		}
		*/

		for (Integer key : this.marsNavy.keySet()) {
			
		}

		return evacuationShips;
	}

	@Override
	public String toString() {
		String strRepresentation = "";

		for (Integer shipID : marsNavy.keySet()) {
			strRepresentation += "\n\t" + marsNavy.get(shipID);
		}

		return strRepresentation;
	}
}