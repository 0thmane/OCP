import java.time.*;

public class NEO {
	private final int id;
	private LocalDateTime approachDate;
	private double nominalDistance;
	private double minimalDistance;
	private double relativeVelocity;
	private String estimatedDiameter;

	public NEO (int id) {
		this.id = id;
	}

	public void setApproachDate(LocalDateTime approachDate) {
		this.approachDate = approachDate;
	}

	public LocalDateTime getApproachDate() {
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
		this.estimatedDiameter = estimatedDiameter;
	}

	public String getEstimatedDiameter() {
		return this.estimatedDiameter;
	}

	@Override
	public boolean equals(Object obj) {
		
	}
}