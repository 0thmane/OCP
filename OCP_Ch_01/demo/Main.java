public class Main {
	public static void main(String[] args) {
		Aircraft planeOne = new Aircraft(AircraftType.F16, "CA", 1);
		Aircraft planeTwo = new Aircraft(AircraftType.FA18, "CA", 1);
		Aircraft planeThree = new Aircraft(AircraftType.FA18, "CA", 2);
		Aircraft planeFour = new Aircraft(AircraftType.FA18, "CA", 3);
		
		Airforce airforce;

		try {
			airforce = new Airforce("CA", 2);

			airforce.addAircraft(planeOne);
			airforce.addAircraft(planeTwo);
			airforce.addAircraft(planeThree);
			airforce.addAircraft(planeFour);
			
			airforce.scrambleAircraft();
		} catch(InvalidCountryCodeException e) {
			System.out.println(e);
		}
	}
}