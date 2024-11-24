package search;

import java.util.ArrayList;

public class Search {
    private SearchMethod searchMethod;

    public void setSearchMethod(SearchMethod searchMethod) {
        this.searchMethod = searchMethod;
    }

    public void searchMethod(ArrayList<String> dataset) {
        this.searchMethod.searchMethod(dataset);
    }
}


