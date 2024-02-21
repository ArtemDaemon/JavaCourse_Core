package javaLesson1;

import java.util.Objects;

public class Bird extends Animal {
	private float wingSpan;
	private String migratoryStatus;
	private static final float MIN_WING_SPAN = 1;
	private static final float MAX_WING_SPAN = 100;
	
	public Bird() {
		super();
		wingSpan = 0;
		migratoryStatus = "Unknown migratory status";
	}
	
	public Bird(String name, int age, float wingSpan, String migratoryStatus) throws ValueOutOfRangeException {
		super(name, age);
		validateWingSpan(wingSpan);
		this.wingSpan = wingSpan;
		this.migratoryStatus = migratoryStatus;
	}

	// Getters and setters
	public float getWingSpan() {
		return wingSpan;
	}
	public void setWingSpan(float wingSpan) throws ValueOutOfRangeException {
		validateWingSpan(wingSpan);
		this.wingSpan = wingSpan;
	}
	public String getMigratoryStatus() {
		return migratoryStatus;
	}
	public void setMigratoryStatus(String migratoryStatus) {
		this.migratoryStatus = migratoryStatus;
	}
	
	/**
	 * Method for checking whether a numeric value is within the range of valid values
	 * @param wingSpan - Value obtained via constructor or setter
	 * @throws ValueOutOfRangeException - Numeric field was out of its possible range
	 */
	private void validateWingSpan(float wingSpan) throws ValueOutOfRangeException {
		if(wingSpan < MIN_WING_SPAN || wingSpan > MAX_WING_SPAN) {
			throw new ValueOutOfRangeException(MIN_WING_SPAN, MAX_WING_SPAN);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(migratoryStatus, wingSpan);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bird other = (Bird) obj;
		return Objects.equals(migratoryStatus, other.migratoryStatus)
				&& Float.floatToIntBits(wingSpan) == Float.floatToIntBits(other.wingSpan);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Wing span: ").append(wingSpan).append("\n");
		sb.append("Migratory status: ").append(migratoryStatus).append("\n");
		return sb.toString();
	}
}
