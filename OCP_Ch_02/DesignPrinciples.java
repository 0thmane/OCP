interface SpySubmarine {
	default String spy() {
		return "Doing some James Bond style spying...";
	}
}

class NuclearReactor {
	private int powerOutput;

	public NuclearReactor(int powerOutput) {
		if (powerOutput > 0) {
			this.powerOutput = powerOutput;
		} else {
			throw new IllegalArgumentException("Power output cannot be negative");
		}
	}

	public int getPowerOutput() {
		return this.powerOutput;
	}
}

class Submarine {
	private String ID;

	public Submarine(String id) {
		this.setID(id);
	}

	public void setID(String id) {
		if (id == null || id.trim().length() == 0) {
			throw new IllegalArgumentException("Invalid ID input.");
		} else {
			this.ID = id.trim();
		}
	}

	public String getID() {
		return this.ID;
	}

	@Override
	public String toString() {
		return "Submarine: " + this.ID;
	}
}

class NuclearSubmarine extends Submarine {

	private int nuclearFuel;
	private NuclearReactor nuclearReactor;

	private NuclearSubmarine(String id) {
		super(id);
	}

	public NuclearSubmarine(String id, int fuelAmount, NuclearReactor nuclearReactor) {
		this(id);
		this.addNuclearFuel(fuelAmount);

		if (nuclearReactor != null & nuclearReactor instanceof NuclearReactor) {
			this.nuclearReactor = nuclearReactor;
		} else {
			throw new IllegalArgumentException("Nuclear submarine must have a nuclear reactor");
		}
	}

	public void setNuclearFuel(int fuelAmount) {
		if (fuelAmount < 0) {
			throw new IllegalArgumentException("Nuclear fuel amount cannot be neagative.");
		}
	}

	public int getNuclearFuel() {
		return this.nuclearFuel;
	}

	public void addNuclearFuel(int fuelAmount){
		if (fuelAmount < 0) {
			throw new IllegalArgumentException("Adding negative nuclear fuel is not allowed.");
		} else {
			this.nuclearFuel += fuelAmount;
		}
	}

	@Override
	public String toString() {
		String strRepresentation = "";

		strRepresentation += "Submarine: " + this.getID()
						+ "\n\tNuclear fuel: " + this.nuclearFuel	
						+ "\n\tNuclear reactor output : " + this.nuclearReactor.getPowerOutput();

		return strRepresentation;
	}
}

class SecretSubmarine extends NuclearSubmarine implements SpySubmarine {
	public SecretSubmarine(String id, int fuelAmount, NuclearReactor nuclearReactor) {
		super(id, fuelAmount, nuclearReactor);
	}
}

public class DesignPrinciples {
	public static void main(String[] args) {
		Submarine sub = new Submarine("Sub-001");

		NuclearReactor nucReact = new NuclearReactor(50);

		NuclearSubmarine nuclearSub = new NuclearSubmarine("Sub-002", 75, nucReact);
		SecretSubmarine spySub = new SecretSubmarine("Sub-Bond", 200, nucReact);

		System.out.println(nuclearSub);
		System.out.println(spySub);
		System.out.println(spySub.spy());
	}
}