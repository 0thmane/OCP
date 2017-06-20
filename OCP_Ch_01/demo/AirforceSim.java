public class AirforceSim {
	public static void generateBogey() {
		AircraftType randomAircraftType = AircraftType.getRandomAircraftType();

		Aircraft bogey = new Aircraft(randomAircraftType, "XX");

		bogey.addFuel();

		System.out.println("Bogey spotted on radar!\n");
		System.out.println(bogey + "\n");
	}

	public static Airforce generateSampleAirforce(String countryCode, int aircraftLimit) {
		try {
			Airforce newAirforce = new Airforce(countryCode, aircraftLimit);

			return newAirforce;
		} catch (InvalidCountryCodeException e) {
			System.out.println(e);

			return null;
		}
	}

	public static void extraDemo() {
		System.out.println("\n============================================\nExtra Demo:");
		System.out.println("\nHash equals:");

		Aircraft aircraftOne = new Aircraft(AircraftType.F16, "CA", 1, 250);
		Aircraft aircraftTwo = new Aircraft(AircraftType.F16, "CA", 1, 250);

		System.out.println(aircraftOne);
		System.out.println(aircraftTwo);
		System.out.println("Aircraft 1 equals Aircraft 2? " + aircraftOne.equals(aircraftTwo));

		System.out.println("\nHash equals:");

		// -----------------------------------------------------------------------------

		Aircraft aircraftThree = new Aircraft(AircraftType.F16, "CA", 1, 250);
		Aircraft aircraftFour = new Aircraft(AircraftType.F16, "CA", 2, 250);

		System.out.println(aircraftThree);
		System.out.println(aircraftFour);
		System.out.println("Aircraft 1 equals Aircraft 2? " + aircraftThree.equals(aircraftFour));

		System.out.println("\n");

		// -----------------------------------------------------------------------------
		aircraftThree = new Aircraft(AircraftType.F16, "CA", 1, 250);
		aircraftFour = new Aircraft(AircraftType.F16, "US", 1, 250);

		System.out.println(aircraftThree);
		System.out.println(aircraftFour);
		System.out.println("Aircraft 1 equals Aircraft 2? " + aircraftThree.equals(aircraftFour));

		System.out.println("\n");
	}

	public static void main(String[] args) {
		generateBogey();
		Airforce canadianAirforce = generateSampleAirforce("CA", 10);
		canadianAirforce.scrambleAircraft();

		extraDemo();
	}
}