public class NEO {
	private String approachDate;
	private String estimatedDiameter;
	private double nominalDistance;
	private double minimalDistance;
	private double relativeVelocity;

	public final int id;

	public NEO (int id, double nominalDistance, double minimalDistance, double relativeVelocity,
				String estimatedDiameter) {
		this.id = id;

		this.setNominalDistance(nominalDistance);
		this.setMinimalDistance(minimalDistance);
		this.setRelativeVelocity(relativeVelocity);
		this.setEstimatedDiameter(estimatedDiameter);
	}

	public void setApproachDate(String approachDate) {
		if (approachDate == null || approachDate.length() == 0) {
			throw new IllegalArgumentException("Invalid approachDate");
		}

		this.approachDate = approachDate;
	}

	public String getApproachDate() {
		return this.approachDate;
	}

	public void setNominalDistance(double nominalDistance) {
		this.nominalDistance = nominalDistance;
	}

	public double getNominalDistance() {
		return this.nominalDistance;
	}

	public void setMinimalDistance(double minimalDistance) {
		this.minimalDistance = minimalDistance;
	}

	public double getMinimalDistance() {
		return this.minimalDistance;
	}

	public void setRelativeVelocity(double relativeVelocity) {
		this.relativeVelocity = relativeVelocity;
	}

	public double getRelativeVelocity() {
		return this.relativeVelocity;
	}

	public void setEstimatedDiameter(String estimatedDiameter) {
		if (estimatedDiameter == null || estimatedDiameter.length() == 0) {
			throw new IllegalArgumentException("Invalid esimatedDiameter");
		}

		this.estimatedDiameter = estimatedDiameter;
	}

	public String getEstimatedDiameter() {
		return this.estimatedDiameter;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof NEO)) return false;

		if(this == obj) return true;

		NEO otherNEO = (NEO) obj;

		return this.id == otherNEO.id;
	}

	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public String toString() {
		StringBuilder strRepresentation = new StringBuilder();

		strRepresentation.append(this.id + "\t");
		strRepresentation.append(this.approachDate + "\t");
		strRepresentation.append(this.nominalDistance + "\t");
		strRepresentation.append(this.minimalDistance + "\t");
		strRepresentation.append(this.relativeVelocity + "\t");
		strRepresentation.append(this.estimatedDiameter + "\t");

		return strRepresentation.toString();
	}
}