package javaLesson1;

public class Main {
	public static void main(String[] args) {
		Animal testException = new Animal();
		try {
			testException.setAge(-1);			
			testException.setAge(10);
		}
		catch(ValueOutOfRangeException e) {
			System.out.println(e);
		}
		System.out.println(testException.getAge());
	}
}
