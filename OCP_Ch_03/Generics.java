import java.util.*;
import java.lang.*;

class Dragon {}

class Unicorn {}

public class Generics {
	public static void main(String[] args) {
		List unicorns = new ArrayList(); 	// Compiler warning: raw type
		unicorns.add(new Unicorn());
		

		try {
			printDragons(unicorns); // Incompatible types
		} catch (ClassCastException e) {
			System.out.println("ClassCastException - printDragons");  
		} catch (Exception e) {
			System.out.println("Exception");
		}

		addUnicorn(unicorns);

		// --------------------------------------------------------------------------

		try {
			// Unicorn unicorn = unicorns.get(0); // Compiler Error: casting

			Unicorn unicorn = (Unicorn) unicorns.get(0);
		} catch (ClassCastException e) {
			System.out.println("ClassCastException");  
		} catch (Exception e) {
			System.out.println("Exception");
		}
	}

	private static void printDragons(List<Dragon> dragons) {
		for (Dragon dragon: dragons) {
			System.out.println(dragon);
		}
	}

	private static void addUnicorn(List unicorn) {
		unicorn.add(new Dragon()); 			// Compiler warning: unchecked call to raw list type. 
	}
}

