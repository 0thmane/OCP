public class Main {
	public static void main(String[] args) {
		Aircraft planeOne = new Aircraft(AircraftType.F16, 1);
		Aircraft planeTwo = new Aircraft(AircraftType.FA18, 1);

		System.out.println(planeOne);
		System.out.println(planeTwo);
	}
}