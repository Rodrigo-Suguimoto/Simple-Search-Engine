package search;

import java.util.Optional;
import java.util.Scanner;

public class Menu {
    int option;

    public void printOptions() {
        System.out.println(); // Print an empty line.
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    public Optional<Integer> getSelectedOptionFromUser() {
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        if (option > 2 || option < 0) {
            System.out.println(); // Print an empty line.
            System.out.println("Incorrect option! Try again.");
            return Optional.empty();
        } else {
            return Optional.of(option);
        }
    }
}
