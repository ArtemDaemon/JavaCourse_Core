package javaLesson1;

import java.util.Objects;

public class Animal {
	private String name;
	private int age;
	private static final int MIN_AGE = 0;
	private static final int MAX_AGE = 200;
	
	public Animal() {
		name = "Unknown";
		age = 0;
	}
	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
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
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name : ").append(name).append("\n");
		sb.append("Age : ").append(age).append("\n");
		return sb.toString();
	}
	
}
