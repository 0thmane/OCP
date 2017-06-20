import java.util.*;
import java.lang.Math;

public class Airforce {

	public final String COUNTRY_CODE;

	private List<Aircraft> aircraftList = new ArrayList<>();

	public Airforce(String countryCode, int aircraftLimit) throws InvalidCountryCodeException {
		if (countryCode.length() > 2) {
			throw new InvalidCountryCodeException("Invalid country code, must be 2 chars.");
		}

		this.COUNTRY_CODE = countryCode;
		this.createAndAddAircraft(aircraftLimit);
	}

	public boolean addAircraft(Aircraft newAircraft) {
		boolean insertSuccess = false;

		if (!aircraftExists(newAircraft.getFullId())) {
			insertSuccess = true;
			aircraftList.add(newAircraft);
		}

		return insertSuccess;
	}

	public boolean removeAircraft(String fullAircraftId) {
		boolean removalSuccess = false;
		Iterator aircraftParser = this.aircraftList.iterator();

		while (aircraftParser.hasNext()) {
			Aircraft currentAircraft = (Aircraft) aircraftParser.next();
			String currentAircraftId = currentAircraft.getFullId();

			if (currentAircraftId.equals(fullAircraftId)) {
				aircraftParser.remove();
			}
		}

		return removalSuccess;
	}

	public boolean aircraftExists(String fullAircraftId) {
		boolean exists = false;

		for (Aircraft aircraft : this.aircraftList) {
			String existingAircraftId = aircraft.getFullId();

			if (existingAircraftId.equals(fullAircraftId)) {
				exists = true;
				break;
			}
		}

		return exists;
	}

	public boolean aircraftExists(Aircraft newAircraft) {
		boolean exists = false;

		if (newAircraft == null) {
			return exists;
		}

		for (Aircraft aircraft : this.aircraftList) {
			if (aircraft.equals(newAircraft)) {
				exists = true;
				break;
			}
		}

		return exists;
	}

	public List<Aircraft> getFleet() {
		List<Aircraft> aircraftFleet = new ArrayList<>(aircraftList);

		return aircraftFleet;
	}

	public Touple scrambleAircraft() {
		Touple scrambleDetails;

		List<Aircraft> scrambledAircraft = new ArrayList<>();
		Random random = new Random();
		int scrambleTime = 0;

		int randomInt1 = random.nextInt(this.aircraftList.size());
		int randomInt2;

		// Insure second random number is unique
		while (true) {
			randomInt2 = random.nextInt(this.aircraftList.size());

			if (randomInt2 != randomInt1) {
				break;
			}
		}

		Aircraft randomAircraft1 = this.aircraftList.get(randomInt1);
		Aircraft randomAircraft2 = this.aircraftList.get(randomInt2);

		int scrambleTime1 = randomAircraft1.scramble();
		int scrambleTime2 = randomAircraft2.scramble();

		scrambledAircraft.add(randomAircraft1);
		scrambledAircraft.add(randomAircraft2);

		scrambleTime = Math.max(scrambleTime1, scrambleTime2);

		scrambleDetails = new Touple(scrambledAircraft, scrambleTime);

		System.out.println("\nAircraft scrambled:\n");
		System.out.println("\t" + randomAircraft1);
		System.out.println("\t" + randomAircraft2);

		System.out.println("\nTime to scramble:\t" + scrambleTime + " minutes.\n");

		return scrambleDetails;
	}

	@Override 
	public String toString() {
		String strRepresentation = "";

		for (Aircraft aircraft : aircraftList) {
			strRepresentation += aircraft.toString() + "\n";
		}

		return strRepresentation;
	}

	private void createAndAddAircraft(int aircraftLimit) {
		while (this.aircraftList.size() < aircraftLimit) {

			AircraftType randomAircraftType = AircraftType.getRandomAircraftType();

			Aircraft newAircraft = new Aircraft(randomAircraftType, this.COUNTRY_CODE);

			this.addAircraft(newAircraft);
		}
	}

	public class Touple {
		private final List<Aircraft> scrambledAircraft;
		public final int scrambleTime;

		public Touple(List<Aircraft> scrambledAircraft, int scrambleTime) {
			this.scrambledAircraft = scrambledAircraft;
			this.scrambleTime = scrambleTime;
		}

		public List<Aircraft> getScrambledAircraft() {
			List<Aircraft> safeList = new ArrayList<>(scrambledAircraft);

			return safeList;
		}
	}
}