package javaLesson1;

public class Animal {
	private String name;
	private int age;
	private static final int MIN_AGE = 0;
	private static final int MAX_AGE = 200;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws ValueOutOfRangeException {
		if(age < MIN_AGE || age > MAX_AGE) throw new ValueOutOfRangeException(MIN_AGE, MAX_AGE);
		this.age = age;
	}
}
