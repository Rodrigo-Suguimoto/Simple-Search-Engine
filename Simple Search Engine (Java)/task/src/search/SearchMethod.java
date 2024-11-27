package search;

import java.util.*;

public interface SearchMethod {
    void searchMethod(Dataset dataset, String[] wordsToBeSearched);
}

class SearchAllStrategy implements SearchMethod {
    @Override
    public void searchMethod(Dataset dataset, String[] wordsToBeSearched) {
        List<List<Integer>> listOfLineNumbers = new ArrayList<>();

        for (int i = 0; i < wordsToBeSearched.length; i++) {
            List<Integer> lines = (dataset.getInvertedIndex().getOrDefault(wordsToBeSearched[i].toLowerCase(), Collections.emptyList()));
            listOfLineNumbers.add(lines);
        }

        if (listOfLineNumbers == null || listOfLineNumbers.isEmpty()) {
            return;
        }

        // Initialize the set with the first list
        Set<Integer> commonLines = new HashSet<>(listOfLineNumbers.get(0));
        for (int i = 1; i < listOfLineNumbers.size(); i++) {
            commonLines.retainAll(listOfLineNumbers.get(i));
        }

        for (Integer line : commonLines) {
            System.out.println(dataset.getDataset().get(line));
        }
    }
}

class SearchAnyStrategy implements SearchMethod {
    @Override
    public void searchMethod(Dataset dataset, String[] wordsToBeSearched) {
        System.out.println("Search ANY strategy");
    }
}

class SearchNoneStrategy implements SearchMethod {
    @Override
    public void searchMethod(Dataset dataset, String[] wordsToBeSearched) {
        System.out.println("Search NONE strategy");
    }
}
