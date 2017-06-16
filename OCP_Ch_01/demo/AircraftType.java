public enum AircraftType {
	F16(3175, 1250, 4), 
	F35(8380, 950, 5), 
	F22(8200, 1750, 3), 
	FA18(6750, 2250, 2), 
	SU27(11775, 1900, 2), 
	SU27UB(11775, 2000, 4), 
	SU35(11625, 2750, 2), 
	MIG31(14200, 2450, 5);

	public final int FUEL_CAPACITY;
	public final int FUEL_RATE;
	public final int MIN_TAKEOFF_TIME;

	private AircraftType(int fuelCapacity, int fuelRate, int scrambleTime) {
		this.FUEL_CAPACITY = fuelCapacity;
		this.FUEL_RATE = fuelRate;
		this.MIN_TAKEOFF_TIME = scrambleTime;
	}
}