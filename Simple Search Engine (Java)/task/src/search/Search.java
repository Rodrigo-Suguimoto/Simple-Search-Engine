package search;

import java.util.*;

public class Search {
    private SearchMethod searchMethod;

    public void search(Dataset dataset) {
        String[] wordsToBeSearched = askForWordsToBeSearched();
        List<List<Integer>> linesThatMatch = findLinesThatMatch(dataset, wordsToBeSearched);
        this.searchMethod.searchMethod(linesThatMatch, dataset);
    }

    private String[] askForWordsToBeSearched() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(); // Print an empty line.
        System.out.println("Enter a name or email to search all suitable people.");
        String[] wordsToBeSearched = scanner.nextLine().split(" ");

        return wordsToBeSearched;
    }

    private List<List<Integer>> findLinesThatMatch(Dataset dataset, String[] wordsToBeSearched) {
        List<List<Integer>> listOfLineNumbers = new ArrayList<>();

        for (String word : wordsToBeSearched) {
            List<Integer> lines = dataset
                    .getInvertedIndex()
                    .getOrDefault(word.toLowerCase(), Collections.emptyList());
            listOfLineNumbers.add(lines);
        }

        return listOfLineNumbers.isEmpty() ? Collections.emptyList() : listOfLineNumbers;
    }

    public void setSearchMethod(SearchMethod searchMethod) {
        this.searchMethod = searchMethod;
    }

    public void searchMethod(List<List<Integer>> linesThatMatch, Dataset dataset) {
        this.searchMethod.searchMethod(linesThatMatch, dataset);
    }
}


