/*
	Scenario:

		Gynamede stations environmental systems have collapsed and 2500 lives are now in danger.
		The Martian Conrgress has decided to use it's navy to help evacuate all the victims.

	Task:

		Figure out which ships to send.
*/

import java.util.*;

public class Main {
	public static void main(String[] args) {
		MCRN marsNavy = new MCRNBuilder()
			.setFleetAdmiral("Adm Dantes")
			.setFleetCommander("Cmd Mark Twain")
			.setCivilianCommander("Jules Verne")
			.setShipLimit(1124)
			.build();

		System.out.println("\n\tMARS NAVY FLEET REGISTRAR\n");

		System.out.println(marsNavy);

		LocationType dispatchFrom = LocationType.MARS;

		int livesInDanger = 2500;

		System.out.println("\nLives in danger: " + livesInDanger);

		List<Spaceship> rescueShips = marsNavy.callEvacuationShips(livesInDanger, dispatchFrom);

		for (Spaceship ship : rescueShips) {
			System.out.println(ship);
		}
	}
}