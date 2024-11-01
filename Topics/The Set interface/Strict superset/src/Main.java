import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.Objects;

public class Main {

    private static <T> boolean isStrictSuperset(Set<T> set1, Set<T> set2) {
        boolean elementsInSet1ExistInSet2 = true;
        for (T element : set1) {
            if (!set2.contains(element)) {
                elementsInSet1ExistInSet2 = false;
            }
        }

        if(!elementsInSet1ExistInSet2) {
            return false;
        }

        if(Objects.equals(set1, set2)) {
            return false;
        }

        return true;
    }

    /* Please do not change the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> set1 = readStringSet(scanner);
        Set<String> set2 = readStringSet(scanner);

        System.out.println(isStrictSuperset(set1, set2));
    }

    private static Set<String> readStringSet(Scanner scanner) {
        return Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toSet());
    }
}