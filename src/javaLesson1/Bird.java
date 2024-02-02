package javaLesson1;

public class Bird extends Animal {
	private float wingSpan;
	private String migratoryStatus;
	private static final float MIN_WING_SPAN = 1;
	private static final float MAX_WING_SPAN = 100;
	
	public float getWingSpan() {
		return wingSpan;
	}
	public void setWingSpan(float wingSpan) throws ValueOutOfRangeException {
		if(wingSpan < MIN_WING_SPAN || wingSpan > MAX_WING_SPAN) {
			throw new ValueOutOfRangeException(MIN_WING_SPAN, MAX_WING_SPAN);
		}
		this.wingSpan = wingSpan;
	}
	public String getMigratoryStatus() {
		return migratoryStatus;
	}
	public void setMigratoryStatus(String migratoryStatus) {
		this.migratoryStatus = migratoryStatus;
	}
}
