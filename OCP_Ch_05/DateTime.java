import java.time.*;
import java.util.stream.Stream;

public class DateTime {
	public static void main(String[] args) {
		// What time is it now?

		System.out.println(LocalDate.now());
		System.out.println(LocalDateTime.now());
		System.out.println(LocalTime.now());
		System.out.println(ZonedDateTime.now());

		// ---------------------------------------------------------------------------------------
		// Getting date specifics

		LocalDate firstDate = LocalDate.of(2026, Month.JANUARY, 19);

		System.out.println(firstDate);
		System.out.println(firstDate.getDayOfWeek());
		System.out.println(firstDate.getDayOfMonth());

		// ---------------------------------------------------------------------------------------
		// Zones

		LocalDateTime secondDate = LocalDateTime.now();

		ZoneId.getAvailableZoneIds()
			.stream()
			.sorted()
			.forEach(System.out::println);

		System.out.println("\n" + secondDate);

		ZonedDateTime zonedSecondDate = ZonedDateTime.of(secondDate, ZoneId.of("Canada/Central"));

		System.out.println(zonedSecondDate);

		// ---------------------------------------------------------------------------------------
		// Manipulation

		LocalDate thirdDate = LocalDate.now();
		System.out.println("\n" + thirdDate); 

		thirdDate.plusDays(50);

		System.out.println(thirdDate); 							// No change, dates are immutable

		thirdDate = thirdDate.plusDays(50);
		System.out.println(thirdDate + ", " + thirdDate.getDayOfWeek());

		thirdDate = thirdDate.minusMonths(7);
		System.out.println(thirdDate);

		// ---------------------------------------------------------------------------------------
		// Periods

		System.out.println("\n");

		LocalDateTime fourthDate = LocalDateTime.now();
		Period period = Period.of(0, 0, 35); // 0 years, 0 months, 35 days

		Stream<LocalDateTime> dateStream = Stream.generate(() -> fourthDate)
			.limit(5);

		Stream.iterate(period, date -> date.plus(period))
			.limit(5)
			.forEach(System.out::println);
	}
}