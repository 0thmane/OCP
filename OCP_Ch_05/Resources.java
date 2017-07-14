import java.util.*;

public class Resources {
	public static void printProperties(Locale locale) {
		ResourceBundle resourceBundle = ResourceBundle.getBundle("Prop", locale);

		Set<String> keys = resourceBundle.keySet();

		keys.stream()
			.map(k -> k + " " + resourceBundle.getString(k))
			.forEach(System.out::println);
	}

	public static void main(String[] args) {
		Locale canada = new Locale("en", "CA");
		Locale britain = new Locale("en", "GB");
		Locale france = new Locale("fr", "FR");

		printProperties(france);

		/* Order of looking for resource bundle

			1. Prop_fr_FR.java
			2. Prop_fr_FR.properties
			3. Prop_fr.java
			4. Prop_fr.properties
			5. Prop_en_GB.java 			// System default locale
			6. Prop_en_GB.properties 	// System default locale
			7. Prop_en.java
			8. Prop_en.properties
			9. Prop.java
			10. Prop.properties 
			11. Throw an Exception
		*/
	}
}