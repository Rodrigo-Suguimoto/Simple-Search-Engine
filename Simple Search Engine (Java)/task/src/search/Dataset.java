package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Dataset {

    private Map<String, List<Integer>> invertedIndex = new HashMap<>();
    private ArrayList<String> dataset = new ArrayList<>();

    public Map<String, List<Integer>> getInvertedIndex() {
        return this.invertedIndex;
    }
    public ArrayList<String> getDataset() {
        return this.dataset;
    }

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

    public void printDataset() {
        System.out.println(); // Print an empty line.
        System.out.println("=== List of people ===");
        this.dataset.forEach((entry) -> System.out.println(entry));
    }
}
