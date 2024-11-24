package search;

import java.util.ArrayList;

public interface SearchMethod {
    void searchMethod(ArrayList<String> dataset);
}

class SearchAllStrategy implements SearchMethod {
    @Override
    public void searchMethod(ArrayList<String> dataset) {
        System.out.println("Search ALL strategy");
        System.out.println(dataset);
    }
}

class SearchAnyStrategy implements SearchMethod {
    @Override
    public void searchMethod(ArrayList<String> dataset) {
        System.out.println("Search ANY strategy");
    }
}

class SearchNoneStrategy implements SearchMethod {
    @Override
    public void searchMethod(ArrayList<String> dataset) {
        System.out.println("Search NONE strategy");
    }
}
