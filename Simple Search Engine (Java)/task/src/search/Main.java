package search;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> dataset = new ArrayList<>();
        if (args[0].equals("--data")) {
            dataset = readFileAndReturnDataset(args[1]);
        }

        Menu menu = new Menu();
        Integer option = null;

        do {
            menu.printOptions();
            option = menu.getSelectedOptionFromUser();
            if (option != null) {
                switch (option) {
                    case 1:
                        search(dataset);
                        break;
                    case 2:
                        printAllPeople(dataset);
                        break;
                }
            }
        } while (option == null || option != 0);
    }

    private static ArrayList<String> readFileAndReturnDataset(String fileName) {
        String pathToFile = String.format("./%s", fileName);
        File file = new File(pathToFile);
        ArrayList<String> dataset = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                dataset.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found on " + pathToFile);
        }
        return dataset;
    }

    private static Map<String, List<Integer>> invertedIndex(ArrayList<String> dataset) {

    }

    private static void printAllPeople(ArrayList<String> people) {
        System.out.println(); // Print an empty line.
        System.out.println("=== List of people ===");
        people.forEach((person) -> System.out.println(person));
    }

    private static void search(ArrayList<String> textToSearchFor) {
        Scanner scanner = new Scanner(System.in);
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
