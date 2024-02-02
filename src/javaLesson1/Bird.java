package javaLesson1;

public class Bird extends Animal {
	private float wingSpan;
	private String migratoryStatus;
	
	public float getWingSpan() {
		return wingSpan;
	}
	public void setWingSpan(float wingSpan) {
		this.wingSpan = wingSpan;
	}
	public String getMigratoryStatus() {
		return migratoryStatus;
	}
	public void setMigratoryStatus(String migratoryStatus) {
		this.migratoryStatus = migratoryStatus;
	}
}
