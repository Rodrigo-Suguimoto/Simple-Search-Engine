package search;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String wordToSearchFor = scanner.next();

        String[] words = firstLine.split(" ");
        String response = "Not found";
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(wordToSearchFor)) {
                response = String.format("%d", i + 1);
            }
        }

        System.out.println(response);
    }
}
