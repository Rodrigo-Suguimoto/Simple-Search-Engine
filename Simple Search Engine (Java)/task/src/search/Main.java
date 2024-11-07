package search;

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
                        dataset.search();
                        break;
                    case 2:
                        dataset.printDataset();
                        break;
                }
            }
        } while (option == null || option != 0);
    }
}
