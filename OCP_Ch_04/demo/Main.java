/*
	Scenario:

		Gynamede stations environmental systems have collapsed and 500 lives are now in danger.
		The Martian Conrgress has decided to use it's navy to help evacuate all the victims.

	Task:

		Figure out which ships to send.
*/

import java.util.*;

public class Main {
	public static void rescueSim() {
		LocationType dispatchFrom = LocationType.MARS;
		List<Spaceship> rescueShips;

		int livesInDanger = 500;

		MCRN marsNavy = new MCRNBuilder()
			.setFleetAdmiral("Adm Dantes")
			.setFleetCommander("Cmd Mark Twain")
			.setCivilianCommander("Jules Verne")
			.setShipLimit(15)
			.build();

		System.out.println(marsNavy);
		System.out.println("\nLives in danger: " + livesInDanger);

		rescueShips = marsNavy.callEvacuationShips(livesInDanger, dispatchFrom);

		rescueShips.forEach(System.out::println);	// Refactored
	}

	public static void main(String[] args) {
		rescueSim();
	}
}