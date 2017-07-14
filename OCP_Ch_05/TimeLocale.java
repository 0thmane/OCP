import java.time.*;
import java.util.*;

public class TimeLocale {
	public static void main(String[] args) {
		Locale defaultLocale = Locale.getDefault();

		System.out.println(defaultLocale);

		// ----------------------------------------------------------------------------------------

		System.out.println(Locale.CANADA);
		System.out.println(new Locale("fr", "CA"));

		// ----------------------------------------------------------------------------------------

		Locale localeBuilder = new Locale.Builder()
			.setLanguage("fr")
			.build();
	}
}