/*
	Code that that was removed during dev process and may be useful at some other time.
*/

import java.util.Random;
import java.util.Set;
import java.util.HashSet;

class AircraftIdGenerator {

	private static Set<Integer> existingIds = new HashSet<>();

	private AircraftIdGenerator() {}

	public static int getRandomId() {
		int randomId = 0;
		Random random = new Random();

		do {
			System.out.println("\nExisting Ids: \t" + existingIds + "\n");
			randomId = random.nextInt(10000);

			if (existingIds.add(randomId)) break;
		} while (true);

		return randomId;
	}
}