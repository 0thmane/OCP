import java.util.*;

public class MCRNBuilder {
	private Map<Integer, Spaceship> marsNavy = new HashMap<>();

	private String fleetAdmiral;
	private String fleetCommander;
	private String civilianCommander;

	private int shipLimit;

	public MCRNBuilder setFleetAdmiral(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("Invalid fleet admiral name");
		}

		this.fleetAdmiral = name;

		return this;
	}

	public MCRNBuilder setFleetCommander(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("Invalid fleet admiral name");
		}

		this.fleetCommander = name;

		return this;
	}

	public MCRNBuilder setCivilianCommander(String name) {
		if (name == null || name.length() == 0) {
			throw new IllegalArgumentException("Invalid fleet admiral name");
		}

		this.civilianCommander = name;

		return this;
	}

	public MCRNBuilder setShipLimit(int limit) {
		if (limit < 0) {
			throw new IllegalArgumentException("Ship limit must be at least 0");
		}

		this.shipLimit = limit;

		return this;
	}

	public MCRN build() {
		return new MCRN(fleetAdmiral, fleetCommander, civilianCommander, shipLimit);
	}
}