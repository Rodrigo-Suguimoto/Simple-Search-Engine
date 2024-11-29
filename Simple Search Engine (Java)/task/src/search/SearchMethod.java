package search;

import java.util.*;

public interface SearchMethod {
    void searchMethod(List<List<Integer>> linesThatMatch, Dataset dataset);
}

class SearchAllStrategy implements SearchMethod {
    @Override
    public void searchMethod(List<List<Integer>> linesThatMatch, Dataset dataset) {
        if (linesThatMatch.isEmpty()) {
            return;
        }

        // Initialize the set with the first list
        Set<Integer> commonLines = new HashSet<>(linesThatMatch.get(0));
        for (int i = 1; i < linesThatMatch.size(); i++) {
            commonLines.retainAll(linesThatMatch.get(i));
        }

        for (Integer line : commonLines) {
            System.out.println(dataset.getDataset().get(line));
        }
    }
}

class SearchAnyStrategy implements SearchMethod {
    @Override
    public void searchMethod(List<List<Integer>> linesThatMatch, Dataset dataset) {
        if (linesThatMatch.isEmpty()) {
            return;
        }

        Set<Integer> uniqueLines = new HashSet<>(linesThatMatch.get(0));
        for (int i = 1; i < linesThatMatch.size(); i++) {
            uniqueLines.addAll(linesThatMatch.get(i));
        }

        for (Integer line : uniqueLines) {
            System.out.println(dataset.getDataset().get(line));
        }

    }
}

class SearchNoneStrategy implements SearchMethod {
    @Override
    public void searchMethod(List<List<Integer>> linesThatMatch, Dataset dataset) {
        System.out.println("Search NONE strategy");
    }
}
