package javaLesson1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
	private final static int MENU_DEFAULT_KEY = -1;
	private final static int MENU_EXIT_KEY = 0;
	private final static int MENU_ADD_KEY = 1;
	private final static int MENU_DELETE_KEY = 2;
	private final static int MENU_VIEW_KEY = 3;
	private final static int MENU_COMPARE_KEY = 4;
	
	private final static int CREATE_ANIMAL = 1;
	private final static int CREATE_MAMMAL = 2;
	private final static int CREATE_BIRD = 4;
	
	/**
	 * Method for creating an Animal/Mammal/Artiodactyl/Bird object
	 * @param scanner - Object for scanning user's input
	 * @return Object of chosen class
	 * @throws ValueOutOfRangeException - At least on of the numeric field was out of its possible range
	 */
	private static Animal createAnimal(Scanner scanner) throws ValueOutOfRangeException {
		System.out.println("Enter animal type:");
		System.out.println("1. Animal");
		System.out.println("2. Mammal");
		System.out.println("3. Artiodactyl");
		System.out.println("4. Bird");
        int choice = getIntValue(scanner, "Enter your choice: ");
        Animal newAnimal = null;
        
        if(choice >= CREATE_ANIMAL && choice <= CREATE_BIRD) {
        	System.out.println("Enter Animal details");
    		System.out.print("Name: ");
    		String name = scanner.next();
    		int age = getIntValue(scanner, "Age: ");
    		
    		if(choice == CREATE_ANIMAL) {
    			newAnimal = new Animal(name, age);
    		}
    		else if(choice == CREATE_BIRD) {
    			float wingSpan = getFloatValue(scanner, "Wing span: ");
    			
    			System.out.print("Migratory status: ");
        		String migratoryStatus = scanner.next();
        		
        		newAnimal = new Bird(name, age, wingSpan, migratoryStatus);
    		}
    		else {
    			int numLegs = getIntValue(scanner, "Num of legs: ");
    			
    			System.out.print("Habitat: ");
    			String habitat = scanner.next();
    			
    			if(choice == CREATE_MAMMAL) {
    				newAnimal = new Mammal(name, age, numLegs, habitat);
    			}
    			else {
    				float hornLength = getFloatValue(scanner, "Length of horn: ");
        			
        			System.out.print("Diet: ");
            		String diet = scanner.next();
            		
            		newAnimal = new Artiodactyl(name, age, numLegs, habitat, hornLength, diet);
    			}
    		}
    		System.out.println("Animal was succesfully created");
        }
        else {
        	System.out.println("Invalid input! Creating a default Animal");
        	newAnimal = new Animal();
        }

        return newAnimal;
	}
	
	/**
	 * Method for printing menu items
	 */
	private static void printMenu() {
		System.out.println("===== Animal Information System Menu =====");
        System.out.println("1. Add a new Animal");
        System.out.println("2. Delete an Animal");
        System.out.println("3. View all Animals");
        System.out.println("4. Compare two Animals");
        System.out.println("0. Exit");
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Animal Information System! How can we assist you today?");
		Scanner scanner = new Scanner(System.in);
		int menuKey = MENU_DEFAULT_KEY;
		List<Animal> animalList = new ArrayList<>();
		do {
			int length = animalList.size();
			printMenu();
			
			menuKey = getIntValue(scanner, "Enter your choice: ");
			switch (menuKey) {
				case MENU_ADD_KEY:
					try {
						Animal newAnimal = createAnimal(scanner);
						animalList.add(newAnimal);
					}
					catch (ValueOutOfRangeException e) {
						System.out.println(e.getMessage());
					}
					break;
				case MENU_DELETE_KEY:
					if(length == 0) {
						System.out.println("Animal list is empty");
						break;
					}
					
					int animalIndex = getIntValue(scanner, "Enter an Animal index (start from 0): ");
					if(animalIndex < 0 || (animalIndex + 1) > length) {
						System.out.println("Invalid index");
						break;
					}
					
					animalList.remove(animalIndex);
					System.out.println("Element was removed");
					break;
				case MENU_VIEW_KEY:
					System.out.println("//------------------------//");
					for(Animal animal : animalList) {
						System.out.println(animal);
						System.out.println("//------------------------//");
					}
					break;
				case MENU_COMPARE_KEY:
					if(length == 0) {
						System.out.println("Animal list is empty");
						break;
					}
					
					int firstAnimalIndex = getIntValue(scanner, "Enter first Animal index (start from 0): ");
					int secondAnimalIndex = getIntValue(scanner, "Enter second Animal index (start from 0): ");
					if(firstAnimalIndex < 0 || (firstAnimalIndex + 1) > length ||
							secondAnimalIndex < 0 || (secondAnimalIndex + 1) > length) {
						System.out.println("Invalid index");
						break;
					}
					
					if(animalList.get(firstAnimalIndex).equals(animalList.get(secondAnimalIndex))) {
						System.out.println("Animals are the same");
					}
					else System.out.println("Animals are different");
					break;
				case MENU_EXIT_KEY:
					System.out.println("Goodbye!");
			}
		} while (menuKey != MENU_EXIT_KEY);
		scanner.close();
	}
	
	// Utility Methods
	/**
	 * Method for getting valid integer value
	 * @param scanner - Object for scanning user's input
	 * @param message - String message that will appear before input
	 * @return valid integer value
	 */
	private static int getIntValue(Scanner scanner, String message) {
		int value = 0;
        boolean isValidInput = false;

        do {
        	System.out.print(message);
        	try {
                value = scanner.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        } while (!isValidInput);
        return value;
	}
	
	/**
	 * Method for getting valid float value
	 * @param scanner - Object for scanning user's input
	 * @param message - String message that will appear before input
	 * @return valid float value
	 */
	private static float getFloatValue(Scanner scanner, String message) {
		float value = 0;
        boolean isValidInput = false;

        do {
        	System.out.print(message);
        	try {
                value = scanner.nextFloat();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid flaot value.");
                scanner.nextLine();
            }
        } while (!isValidInput);
        return value;
	}
}
