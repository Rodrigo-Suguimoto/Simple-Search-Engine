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

            transformToInvertedIndex();
        } catch (FileNotFoundException e) {
            System.out.println("No file found on " + pathToFile);
        }
    }

    private void transformToInvertedIndex() {
        for (int i = 0; i < this.dataset.size(); i++) {
            addToInvertedIndex(this.dataset.get(i), i);
        }
    }

    private void addToInvertedIndex(String lineContent, int lineNumber) {
        String[] words = lineContent.toLowerCase().split(" ");

        for (String word : words) {
            if (!this.invertedIndex.containsKey(word)) {
                this.invertedIndex.put(word, new ArrayList<>()); // Since it's a new word, create a new list for line numbers
            }
            this.invertedIndex.get(word).add(lineNumber); // Add line number to the word's list
        }
    }

    public void search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(); // Print an empty line.
        System.out.println("Enter a name or email to search all suitable people.");
        String query = scanner.nextLine();
        List<Integer> linesWithContent = this.invertedIndex.getOrDefault(query.toLowerCase(), Collections.emptyList());
        for (int line : linesWithContent) {
            System.out.println(this.dataset.get(line));
        }

    }

    public void printDataset() {
        System.out.println(); // Print an empty line.
        System.out.println("=== List of people ===");
        this.dataset.forEach((entry) -> System.out.println(entry));
    }
}
