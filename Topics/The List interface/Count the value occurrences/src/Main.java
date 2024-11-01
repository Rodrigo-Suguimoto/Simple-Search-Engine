import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Counter {

    public static boolean checkTheSameNumberOfTimes(int elem, List<Integer> list1, List<Integer> list2) {
        int counterOnList1 = 0;
        for (Integer number : list1) {
            if (number == elem) {
                counterOnList1++;
            }
        }

        int counterOnList2 = 0;
        for (Integer number : list2) {
            if (number == elem) {
                counterOnList2++;
            }
        }

        if (counterOnList1 == counterOnList2) {
            return true;
        } else {
            return false;
        }
    }
}