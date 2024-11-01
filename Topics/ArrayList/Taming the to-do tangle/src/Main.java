import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> taskList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String operation = scanner.nextLine();

            if (operation.equals("add")) {

            } else if (operation.equals("remove")) {

            } else if (operation.equals("display")) {

            }
        }

        scanner.close();
    }
}