import java.util.*;

public class AirforceSim {
	public static void generateBogey() {
		EnumSet<AircraftType> aircraftTypes = EnumSet.allOf(AircraftType.class);
		Random random = new Random();

		int randAircraftType = random.nextInt(aircraftTypes.size());
		int randAircraftId = random.nextInt(10000);

		Aircraft bogey = new Aircraft(AircraftType.values()[randAircraftType] ,
												"XX",
												randAircraftId);

		bogey.addFuel();

		System.out.println("Bogey spotted on radar!\n");
		System.out.println(bogey + "\n");
	}

	public static Airforce generateAirforce(String countryCode, int aircraftLimit) {
		try {
			Airforce newAirforce = new Airforce(countryCode, aircraftLimit);

			return newAirforce;
		} catch (InvalidCountryCodeException e) {
			System.out.println(e);

			return null;
		}
	}

	public static void scrambleTest(Airforce airforce) {
		airforce.scrambleAircraft();
	}

	public static void main(String[] args) {
		generateBogey();
		Airforce canadianAirforce = generateAirforce("CA", 10);
		scrambleTest(canadianAirforce);
	}
}