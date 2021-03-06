import java.lang.Math;
import java.util.*;

public class Aircraft {
	public final String TYPE;
	public final int ID;

	public String ownerNation;

	public final int FUEL_CAPACITY;
	public final int FUEL_RATE;
	public final int MIN_TAKEOFF_TIME;

	private int currentFuel = 0;

	public Aircraft(AircraftType aircraftType,  String ownerNation) {
		this(aircraftType, ownerNation, new Random().nextInt(1000), 0);
	}

	public Aircraft(AircraftType aircraftType,  String ownerNation, int aircraftId) {
		this(aircraftType, ownerNation, aircraftId, 0);
	}

	public Aircraft(AircraftType aircraftType, String ownerNation, int aircraftId, int currentFuel) {
		this.TYPE = aircraftType.name();

		this.ID = aircraftId;
		this.ownerNation = ownerNation;

		this.FUEL_CAPACITY = aircraftType.FUEL_CAPACITY;
		this.FUEL_RATE = aircraftType.FUEL_RATE;
		this.MIN_TAKEOFF_TIME = aircraftType.MIN_TAKEOFF_TIME;

		this.currentFuel = currentFuel;
	}

	public int getFuel() {
		return this.currentFuel;
	}

	public int addFuel() {
		if (this.fullyFuelled()) return 0;

		int fuelingTime = 0;
		int requiredFuel = this.FUEL_CAPACITY - this.currentFuel;

		this.currentFuel += requiredFuel;

		fuelingTime = Math.round(requiredFuel / this.FUEL_RATE);

		return fuelingTime;
	}

	public boolean fullyFuelled() {
		return this.currentFuel == this.FUEL_CAPACITY;
	}

	public String getFullId() {
		String strId = this.TYPE;

		if (this.ID < 10) {
			strId +="000" + this.ID;
		} else if (this.ID < 100) {
			strId += "00" + this.ID;
		} else if (this.ID < 1000) {
			strId += "0" + this.ID;
		} else {
			strId += this.ID;
		}

		strId += this.ownerNation;

		return strId;
	}

	@Override
	public String toString() {
		String strRepresentation = "";
		String strId = this.getFullId();

		strRepresentation += "Type: " + this.TYPE;
		strRepresentation += "\tID: " + strId;
		strRepresentation += "\t\tFUEL: " + this.currentFuel + " / " + this.FUEL_CAPACITY + "kg";

		return strRepresentation;
	}

	@Override
	public int hashCode() {
		int newHash = 0;
		String strRep = this.TYPE + this.ID + this.ownerNation;

		newHash += strRep.hashCode();
		newHash <<= 2;

		return newHash;
	}

	@Override
	public boolean equals(Object obj) {
		if (! (obj instanceof Aircraft)) return false;

		Aircraft subjectAircraft = (Aircraft) obj;

		int otherHash = subjectAircraft.hashCode();
		int thisHash = this.hashCode();

		return thisHash == otherHash;
	}

	public int scramble() {
		int scrambleTime = this.addFuel() + this.MIN_TAKEOFF_TIME;

		return scrambleTime;
	}
}