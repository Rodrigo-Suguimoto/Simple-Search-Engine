import java.lang.Integer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        List<Integer> numbers = convertToList(number);

        System.out.println(numbers);
    }

    public static List<Integer> convertToList(int number){
        List<Integer> numbers = new ArrayList<Integer>();
        String numbersAsString = String.valueOf(number);

        for (int i = 0; i < numbersAsString.length(); i++) {
            numbers.add(Character.getNumericValue(numbersAsString.charAt(i)));
        }

        Collections.sort(numbers);

        return numbers;
    }
}