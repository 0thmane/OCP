import java.util.*;

public class DataStructures {
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add("One");
		list.add("Two");
		list.add(5);

		try {
			for (String str : (List<String>) list) {
				System.out.println(str);
			}
		} catch (Exception e) {
			System.out.println("\n" + e + "\n");
		}

		// ----------------------------------------------------------------------------------------

		try {
			// HashSet<Number> hs = new HashSet<Integer>(); // Exception
			HashSet<? super ClassCastException> set = new HashSet<Exception>();
			List<String> list2 = new Vector<String>();
			//List<Object> values = new HashSet<Object>(); 	// Exception
			List<? extends Object> values = new ArrayList<>();
		} catch (Exception e) {
			System.out.println("\n" + e + "\n");
		}
	}
}