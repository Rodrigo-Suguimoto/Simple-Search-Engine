import java.util.Scanner;

class Finder {

    private FindingStrategy strategy;

    public Finder(FindingStrategy strategy) {
        // write your code here
        this.strategy = strategy;
    }

    /**
     * It performs the search algorithm according to the given strategy
     */
    public int find(int[] numbers) {
        return this.strategy.getResult(numbers);
    }
}

interface FindingStrategy {

    /**
     * Returns search result
     */
    int getResult(int[] numbers);

}

class MaxFindingStrategy implements FindingStrategy {

    public int getResult(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return Integer.MIN_VALUE;
        }

        int maxNumber = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxNumber) {
                maxNumber = numbers[i];
            }
        }

        return maxNumber;
    }
}

class MinFindingStrategy implements FindingStrategy {

    public int getResult(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return Integer.MAX_VALUE;
        }

        int minNumber = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < minNumber) {
                minNumber = numbers[i];
            }
        }

        return minNumber;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        final String[] elements = scanner.nextLine().split("\\s+");
        int[] numbers = null;

        if ("EMPTY".equals(elements[0])) {
            numbers = new int[0];   
        } else {
            numbers = new int[elements.length];
            for (int i = 0; i < elements.length; i++) {
                numbers[i] = Integer.parseInt(elements[i]);
            }
        }

        final String type = scanner.nextLine();

        Finder finder = null;

        switch (type) {
            case "MIN":
                finder = new Finder(new MinFindingStrategy());
                break;
            case "MAX":
                finder = new Finder(new MaxFindingStrategy());
                break;
            default:
                break;
        }

        if (finder == null) {
            throw new RuntimeException(
                    "Unknown strategy type passed. Please, write to the author of the problem.");
        }

        System.out.println(finder.find(numbers));
    }
}