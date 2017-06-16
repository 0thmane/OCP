import java.util.*;
import java.lang.Math;

public class Airforce {

	public final String COUNTRY_CODE;

	private List<Aircraft> aircraftList;

	public Airforce(String countryCode, int aircraftLimit) throws InvalidCountryCodeException {
		if (countryCode.length() > 2) {
			throw new InvalidCountryCodeException("Invalid country code, must be 2 chars.");
		}

		this.COUNTRY_CODE = countryCode;
		this.aircraftList = AirforceGenerator.createAircraft(countryCode, aircraftLimit);
	}

	public boolean addAircraft(Aircraft newAircraft) {
		boolean insertSuccess = false;

		if (aircraftExists(newAircraft.getFullId())) {
			insertSuccess = false;
		} else {
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
			String aircraftFullId = aircraft.getFullId();

			if (aircraftFullId.equals(fullAircraftId)) {
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
		int randomInt2 = random.nextInt(this.aircraftList.size());

		Aircraft randomAircraft1 = this.aircraftList.get(randomInt1);
		Aircraft randomAircraft2 = this.aircraftList.get(randomInt2);

		scrambledAircraft.add(randomAircraft1);
		scrambledAircraft.add(randomAircraft2);

		int scrambleTime1 = randomAircraft1.scramble();
		int scrambleTime2 = randomAircraft2.scramble();

		scrambleTime = Math.max(scrambleTime1, scrambleTime2);

		scrambleDetails = new Touple(scrambledAircraft, scrambleTime);

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

	private static class AirforceGenerator {
		// TODO
		public static List<Aircraft> createAircraft(String countryCode, int aircraftLimit) {
			List<Aircraft> newAirforce = new ArrayList<>();

			return newAirforce;
		}
	}
}