import java.util.*;

class Main {
    private static int sum(Map<String, Integer> map) {
        Collection<Integer> values = map.values();
        int sum = 0;

        for(int value : values) {
            sum += value;
        }

        return sum;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> m = new HashMap<>();
        int size = scanner.nextInt();
        for (int i = 0; i < size; ++i) {
            String key = scanner.next();
            int value = scanner.nextInt();
            m.put(key, value);
        }
        int result = sum(Map.copyOf(m));
        System.out.println(result);
    }
}