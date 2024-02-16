package javaLesson1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private final static int MENU_DEFAULT_KEY = -1;
	private final static int MENU_EXIT_KEY = 0;
	
	private static void printMenu() {
		System.out.println("===== Animal Information System Menu =====");
        System.out.println("1. Add a new Animal");
        System.out.println("2. Delete an Animal");
        System.out.println("3. View all Animals");
        System.out.println("4. Compare two Animals");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the Animal Information System! How can we assist you today?");
		Scanner scanner = new Scanner(System.in);
		int menuKey = MENU_DEFAULT_KEY;
		do {
			printMenu();
			
			try {
				menuKey = scanner.nextInt();				
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid integer choice.");
                scanner.next();
                menuKey = MENU_DEFAULT_KEY;
			}
		} while (menuKey != MENU_EXIT_KEY);
		scanner.close();
	}
}
