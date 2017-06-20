import java.util.*;

@FunctionalInterface
interface TraitChecker {
	public boolean test(Aircraft aircraft);
}

@FunctionalInterface
interface FlyingAircraft {
	public Aircraft test(Aircraft aircraft);
}

class Aircraft {
	private boolean canFly;
	private boolean canLand;

	public Aircraft(boolean flier, boolean lander) {
		canFly = flier;
		canLand = lander;
	}

	public boolean canFly() {
		return canFly;
	}

	public boolean canLand() {
		return canLand;
	}

	@Override
	public String toString() {
		return "Aircraft";
	}
}

public class Lambdas {
	private static void printDesired(Aircraft aircraft, TraitChecker trait) {
		if (trait.test(aircraft)) {
			System.out.println(aircraft);
		}
	}

	private static void printDesired(ArrayList<Aircraft> aircraftList, TraitChecker trait) {
		for (Aircraft aircraft : aircraftList) {
			if (trait.test(aircraft)) {
				System.out.println(aircraft);
			}
		}
	}

	public static void main(String... args) {
		Aircraft aircraft1 = new Aircraft(false, false);
		Aircraft aircraft2 = new Aircraft(true, false);
		Aircraft aircraft3 = new Aircraft(true, true);

		// Printing aircraft that can fly
		printDesired(aircraft1, a -> a.canFly());	// No result
		printDesired(aircraft2, a -> a.canFly());	// Expect it to print 'Aircraft'
		printDesired(aircraft3, a -> a.canFly());	// Expect it to print 'Aircraft'

		System.out.println();

		// -------------------------------------------------------------------------

		ArrayList<Aircraft> aircraftList = new ArrayList<>();
		aircraftList.add(aircraft1);
		aircraftList.add(aircraft2);
		aircraftList.add(aircraft3);

		// Print aircraft that can fly and can land
		printDesired(aircraftList, a -> a.canFly() & a.canLand());	// Expect it to print 'Aircraft'

		// -------------------------------------------------------------------------

		ArrayList<Aircraft> flyingAircraft = new ArrayList<>();

		aircraftList.stream().forEach(a -> { 
			if(a.canFly()) {
				flyingAircraft.add(a);
			}
		});

		System.out.println(flyingAircraft);
	}
}