package search;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dataset dataset = new Dataset();
        if (args[0].equals("--data")) {
            dataset.setDataset(args[1]);
        }

        Menu menu = new Menu();
        Integer option = null;

        do {
            menu.printOptions();
            option = menu.getSelectedOptionFromUser();
            if (option != null) {
                switch (option) {
                    case 1:
                        Search searchStrategy = getSearchStrategy();
                        searchStrategy.searchMethod();
                        break;
                    case 2:
                        dataset.printDataset();
                        break;
                }
            }
        } while (option == null || option != 0);
    }

    public static Search getSearchStrategy() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        Scanner scanner = new Scanner(System.in);
        String searchStrategy = scanner.nextLine();
        Search searcher = new Search();

        switch(searchStrategy) {
            case "ALL":
                searcher.setSearchMethod(new SearchAllStrategy());
                break;
            case "ANY":
                searcher.setSearchMethod(new SearchAnyStrategy());
                break;
            case "NONE":
                searcher.setSearchMethod(new SearchNoneStrategy());
                break;
        }

        return searcher;
    }
}
