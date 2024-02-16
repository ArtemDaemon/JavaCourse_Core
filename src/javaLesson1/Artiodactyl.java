package javaLesson1;

import java.util.Objects;

public class Artiodactyl extends Mammal {
	private float hornLength;
	private String diet;
	private static final float MIN_HORN_LENGTH = 0;
	private static final float MAX_HORN_LENGTH = 20;
	
	public Artiodactyl() {
		super();
		hornLength = 0;
		diet = "Unknown diet";
	}
	
	public Artiodactyl(String name, int age, int numLegs, String habitat, float hornLength, String diet) 
			throws ValueOutOfRangeException {
		super(name, age, numLegs, habitat);
		validateHornLength(hornLength);
		this.hornLength = hornLength;
		this.diet = diet;
	}

	public float getHornLength() {
		return hornLength;
	}
	public void setHornLength(float hornLength) throws ValueOutOfRangeException {
		validateHornLength(hornLength);
		this.hornLength = hornLength;
	}
	public String getDiet() {
		return diet;
	}
	public void setDiet(String diet) {
		this.diet = diet;
	}
	
	private void validateHornLength(float hornLength) throws ValueOutOfRangeException {
		if(hornLength < MIN_HORN_LENGTH || hornLength > MAX_HORN_LENGTH) {
			throw new ValueOutOfRangeException(MIN_HORN_LENGTH, MAX_HORN_LENGTH);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(diet, hornLength);
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
		Artiodactyl other = (Artiodactyl) obj;
		return Objects.equals(diet, other.diet)
				&& Float.floatToIntBits(hornLength) == Float.floatToIntBits(other.hornLength);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Length of horns : ").append(hornLength).append("\n");
		sb.append("Diet : ").append(diet).append("\n");
		return sb.toString();
	}
}
