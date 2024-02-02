package javaLesson1;

public class ValueOutOfRangeException extends Exception {
	public ValueOutOfRangeException(int bottomLimit, int upperLimit) {
        super("Value is out of range: from " + bottomLimit + " to " + upperLimit);
    }
	public ValueOutOfRangeException(float bottomLimit, float upperLimit) {
        super("Value is out of range: from " + bottomLimit + " to " + upperLimit);
    }
}
