package search;

public interface SearchMethod {
    void searchMethod();
}

class SearchAllStrategy implements SearchMethod {
    @Override
    public void searchMethod() {
        System.out.println("Search all strategy");
    }
}
