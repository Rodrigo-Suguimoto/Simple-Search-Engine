package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dataset {

    private Map<String, List<Integer>> invertedIndex = new HashMap<>();
    private ArrayList<String> dataset = new ArrayList<>();

    public void setDataset(String fileName) {
        String pathToFile = String.format("./%s", fileName);

        File file = new File(pathToFile);

        try {
            Scanner scanner = new Scanner(file);
            while(scanner.hasNext()) {
                this.dataset.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("No file found on " + pathToFile);
        }
    }

    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(); // Print an empty line.
        System.out.println("Enter a name or email to search all suitable people.");
        String query = scanner.nextLine();
        ArrayList<String> matches = new ArrayList<String>();

        this.dataset.forEach(text -> {
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

    public void printDataset() {
        System.out.println(); // Print an empty line.
        System.out.println("=== List of people ===");
        this.dataset.forEach((entry) -> System.out.println(entry));
    }
}
