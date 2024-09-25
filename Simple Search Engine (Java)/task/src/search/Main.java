package search;

import java.util.Optional;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = setNumberOfPeople(scanner, "Enter the number of people:");
        ArrayList<String> people = setPeopleDataset(scanner, numberOfPeople);
        Menu menu = new Menu();
        final Integer DEFAULT_VALUE_FOR_EMPTY_OPTION = -1;

        Integer valueChosen = DEFAULT_VALUE_FOR_EMPTY_OPTION;
        do {
            menu.printOptions();
            Optional<Integer> optional = menu.getSelectedOptionFromUser();
            valueChosen = optional.orElse(DEFAULT_VALUE_FOR_EMPTY_OPTION);

            switch (valueChosen) {
                case 1:
                    break;
                case 2:
                    printAllPeople(people);
                    break;
            }
        } while (valueChosen == -1 || valueChosen != 0);

    }

    private static int setNumberOfPeople(Scanner scanner, String message) {
        System.out.println(message);
        int numberOfRepetition = scanner.nextInt();
        scanner.nextLine(); // Consume the line break that nextInt() left behind.

        return numberOfRepetition;
    }

    private static ArrayList<String> setPeopleDataset(Scanner scanner, int numberOfPeople) {
        System.out.println("Enter all people:");
        ArrayList<String> textToSearchFor = new ArrayList<String>();

        for (int i = 0; i < numberOfPeople; i++) {
            String newText = scanner.nextLine();
            textToSearchFor.add(newText);
        }

        return textToSearchFor;
    }

    private static void printAllPeople(ArrayList<String> people) {
        System.out.println(); // Print an empty line.
        System.out.println("=== List of people ===");
        people.forEach((person) -> System.out.println(person));
    }

    private static void search(Scanner scanner, ArrayList<String> textToSearchFor) {
        System.out.println("Enter data to search people:");
        String query = scanner.nextLine();
        ArrayList<String> matches = new ArrayList<String>();

        textToSearchFor.forEach(text -> {
            Pattern compiledQueryPattern = Pattern.compile(query, Pattern.CASE_INSENSITIVE);
            Matcher matcher = compiledQueryPattern.matcher(text);

            if (matcher.find()) {
                matches.add(text);
            }
        });

        if (matches.size() > 0) {
            System.out.println("Found people:");
            matches.forEach(text -> System.out.println(text));
        } else {
            System.out.println("No matching people found.");
        }
    }
}
