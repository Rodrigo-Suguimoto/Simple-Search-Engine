package search;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        if (args[0].equals("--data")) {
            readFile(args[1]);
        }


//        int numberOfPeople = setNumberOfPeople(scanner, "Enter the number of people:");
//        ArrayList<String> people = setPeopleDataset(scanner, numberOfPeople);
//        Menu menu = new Menu();
//        Integer option = null;
//
//        do {
//            menu.printOptions();
//            option = menu.getSelectedOptionFromUser();
//            if (option != null) {
//                switch (option) {
//                    case 1:
//                        search(scanner, people);
//                        break;
//                    case 2:
//                        printAllPeople(people);
//                        break;
//                }
//            }
//        } while (option == null || option != 0);

    }

    private static void readFile(String fileName) {
        String pathToFile = String.format("../%s", fileName);
        File file = new File(pathToFile);

        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found on " + pathToFile);
        }

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
        System.out.println(); // Print an empty line.
        System.out.println("Enter a name or email to search all suitable people.");
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
            matches.forEach(text -> System.out.println(text));
        } else {
            System.out.println("No matching people found.");
        }
    }
}
