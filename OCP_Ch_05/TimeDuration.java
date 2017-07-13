import java.time.*;

public class TimeDuration {
	public static void main(String[] args) {
		// Adding Duration
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();

		LocalDateTime dateTime = LocalDateTime.of(date, time);

		Duration duration = Duration.ofDays(1);

		System.out.println("The appointment will end at " + dateTime.plus(duration));

		// ---------------------------------------------------------------------------------------
		// Instants

		System.out.println("\n");

		Instant nowInstant = Instant.now();
		System.out.println(nowInstant);



		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println(zonedDateTime);
		System.out.println(zonedDateTime.toInstant());
	}
}