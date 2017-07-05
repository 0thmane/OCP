import java.util.*;

public class Q10 implements Comparator<String> {
	public int compare(String a, String b) {
		return b.toLowerCase().compareTo(a.toLowerCase());
	}

	public static void main(String[] args) {
		String[] values = {"123", "Abb", "aab"};

		Arrays.sort(values, new Q10()); // Q10 is a Comparator

		for (String str : values) {
			System.out.println(str + " ");
		}
	}
}