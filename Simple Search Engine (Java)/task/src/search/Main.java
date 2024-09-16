package search;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfLinesToSearch = getNumberOfRepetition(scanner, "Enter the number of people:");
        ArrayList<String> textToSearchFor = getTextToSearchFor(scanner, numberOfLinesToSearch);
        int numberOfSearchQueries = getNumberOfRepetition(scanner, "Enter the number of search queries:");
        int iterationsOfSearch = 0;

        while (iterationsOfSearch < numberOfSearchQueries) {
            search(scanner, textToSearchFor);
            System.out.println();
            iterationsOfSearch++;
        }
    }

    private static int getNumberOfRepetition(Scanner scanner, String message) {
        System.out.println(message);
        int numberOfRepetition = scanner.nextInt();
        scanner.nextLine(); // Consume the line break that nextInt() left behind.

        return numberOfRepetition;
    }

    private static ArrayList<String> getTextToSearchFor(Scanner scanner, int numberOfLinesToSearch) {
        System.out.println("Enter all people:");
        ArrayList<String> textToSearchFor = new ArrayList<String>();

        for (int i = 0; i < numberOfLinesToSearch; i++) {
            String newText = scanner.nextLine();
            textToSearchFor.add(newText);
        }

        return textToSearchFor;
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
