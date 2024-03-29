package javaLesson1;

import java.util.Objects;

public class Mammal extends Animal {
	private int numLegs;
	private String habitat;
	private static final int MIN_NUM_LEGS = 0;
	private static final int MAX_NUM_LEGS = 4;
	
	public Mammal() {
		super();
		numLegs = 0;
		habitat = "Unknown habitat";
	}
	
	public Mammal(String name, int age, int numLegs, String habitat) throws ValueOutOfRangeException {
		super(name, age);
		validateNumLegs(numLegs);
		this.numLegs = numLegs;
		this.habitat = habitat;
	}

	// Getters and setters
	public int getNumLegs() {
		return numLegs;
	}
	public void setNumLegs(int numLegs) throws ValueOutOfRangeException {
		validateNumLegs(numLegs);
		this.numLegs = numLegs;
	}
	public String getHabitat() {
		return habitat;
	}
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
	
	/**
	 * Method for checking whether a numeric value is within the range of valid values
	 * @param numLegs - Value obtained via constructor or setter
	 * @throws ValueOutOfRangeException - Numeric field was out of its possible range
	 */
	private void validateNumLegs(int numLegs) throws ValueOutOfRangeException {
		if(numLegs < MIN_NUM_LEGS || numLegs > MAX_NUM_LEGS) throw new ValueOutOfRangeException(MIN_NUM_LEGS, MAX_NUM_LEGS);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(habitat, numLegs);
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
		Mammal other = (Mammal) obj;
		return Objects.equals(habitat, other.habitat) && numLegs == other.numLegs;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("Number of legs: ").append(numLegs).append("\n");
		sb.append("Habitat: ").append(habitat).append("\n");
		return sb.toString();
	}
	
}
