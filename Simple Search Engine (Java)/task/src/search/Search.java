package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Search {
    private SearchMethod searchMethod;

    public void search(Dataset dataset) {
        String[] wordsToBeSearched = askForWordsToBeSearched();
        this.searchMethod.searchMethod(dataset, wordsToBeSearched);
    }

    public String[] askForWordsToBeSearched() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(); // Print an empty line.
        System.out.println("Enter a name or email to search all suitable people.");
        String[] wordsToBeSearched = scanner.nextLine().split(" ");

        return wordsToBeSearched;
    }

    public void setSearchMethod(SearchMethod searchMethod) {
        this.searchMethod = searchMethod;
    }

    public void searchMethod(Dataset dataset, String[] wordsToBeSearched) {
        this.searchMethod.searchMethod(dataset, wordsToBeSearched);
    }
}


