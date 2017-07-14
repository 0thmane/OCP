import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;

public class Main {
	public static void runDemo() {
		System.out.print("Den Haag: ");
		printCurrentTime();

		System.out.println();

		printCurrentTimeInCity("Oakville");
	}

	public static void printCurrentTime() {
		LocalDateTime currentDateTime = LocalDateTime.now();

		DateTimeFormatter hoursMinutesFormat = DateTimeFormatter.ofPattern("HH:mm");

		String currentTime = currentDateTime.format(hoursMinutesFormat);
		System.out.print(currentTime);
	}

	public static void printCurrentTimeInCity(String city) {
		if (city != null) {
			DateTimeFormatter hoursMinutesFormat = DateTimeFormatter.ofPattern("HH:mm");
			ZoneId desiredZoneId = getCityZoneId(city);

			Instant nowInstant = Instant.now();
			ZonedDateTime desiredDateTime = nowInstant.atZone(desiredZoneId);

			System.out.println(city + ": " + desiredDateTime.format(hoursMinutesFormat));
		} else {
			System.out.println("City not recognized");
		}
	}

	private static ZoneId getCityZoneId(String city) {
		try {
			ResourceBundle resource = ResourceBundle.getBundle("TimeZones");

			ZoneId desiredZoneId = ZoneId.of(resource.getString(city));

			return desiredZoneId;
		} catch (MissingResourceException e) {
			return null;
		}
	}

	public static void main(String[] args) {
		runDemo();
	}
}