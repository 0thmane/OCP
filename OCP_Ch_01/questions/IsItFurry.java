import java.util.*;

public class IsItFurry {
	static interface Mammal {}

	static class Furry implements Mammal {}

	static class Chipmunk extends Furry {}

	public static void main(String[] args) {
		Chipmunk c = new Chipmunk();
		ArrayList<Chipmunk> l = new ArrayList<>();
		Runnable r = new Thread();
		int result = 0;

		if (c instanceof Chipmunk) result += 1;

		// Compiler error : ArrayList cannot be converted to Chipmunk
		// if (l instanceof Chipmunk) result += 2; 
		
		if (r instanceof Chipmunk) result += 4;

		System.out.println(result);

		// ----------------------------------------------------------

		System.out.println(c instanceof Runnable);
		System.out.println(c instanceof Object);

		// ----------------------------------------------------------

		IsItFurry iif = new IsItFurry();

		// Compiler error : Chipmunk cannot be converted to IsItFurry
		//			- Unless Chipmunk is set to extend IsItFurry
		//System.out.println(c instanceof IsItFurry);

		// ----------------------------------------------------------

		Mammal m = c;
		Furry f = c;
		result = 0;

		if (c instanceof Mammal) result += 1;
		if (c instanceof Furry) result +=2;
		if (null instanceof Chipmunk) result += 4;

		System.out.println(result);
	}
}