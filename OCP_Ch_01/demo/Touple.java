import java.util.*;

public class Touple {
	private final List<Aircraft> scrambledAircraft;
	public final int scrambleTime;

	public Touple(List<Aircraft> scrambledAircraft, int scrambleTime) {
		this.scrambledAircraft = scrambledAircraft;
		this.scrambleTime = scrambleTime;
	}

	public List<Aircraft> getScrambledAircraft() {
		List<Aircraft> safeList = new ArrayList<>(scrambledAircraft);

		return safeList;
	}
}