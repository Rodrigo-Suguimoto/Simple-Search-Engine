package search;

public interface SearchMethod {
    void searchMethod();
}

class SearchAllStrategy implements SearchMethod {
    @Override
    public void searchMethod() {
        System.out.println("Search ALL strategy");
    }
}

class SearchAnyStrategy implements SearchMethod {
    @Override
    public void searchMethod() {
        System.out.println("Search ANY strategy");
    }
}

class SearchNoneStrategy implements SearchMethod {
    @Override
    public void searchMethod() {
        System.out.println("Search NONE strategy");
    }
}
