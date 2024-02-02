package javaLesson1;

public class Artiodactyl extends Mammal {
	private float hornLength;
	private String diet;
	private static final float MIN_HORN_LENGTH = 0;
	private static final float MAX_HORN_LENGTH = 20;
	
	public float getHornLength() {
		return hornLength;
	}
	public void setHornLength(float hornLength) throws ValueOutOfRangeException {
		if(hornLength < MIN_HORN_LENGTH || hornLength > MAX_HORN_LENGTH) {
			throw new ValueOutOfRangeException(MIN_HORN_LENGTH, MAX_HORN_LENGTH);
		}
		this.hornLength = hornLength;
	}
	public String getDiet() {
		return diet;
	}
	public void setDiet(String diet) {
		this.diet = diet;
	}
}
