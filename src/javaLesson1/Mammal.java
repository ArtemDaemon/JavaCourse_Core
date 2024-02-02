package javaLesson1;

public class Mammal extends Animal {
	private int numLegs;
	private String habitat;
	private static final int MIN_NUM_LEGS = 0;
	private static final int MAX_NUM_LEGS = 4;
	
	public int getNumLegs() {
		return numLegs;
	}
	public void setNumLegs(int numLegs) throws ValueOutOfRangeException {
		if(numLegs < MIN_NUM_LEGS || numLegs > MAX_NUM_LEGS) throw new ValueOutOfRangeException(MIN_NUM_LEGS, MAX_NUM_LEGS);
		this.numLegs = numLegs;
	}
	public String getHabitat() {
		return habitat;
	}
	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}
}
