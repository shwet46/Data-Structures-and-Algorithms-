import java.util.*;

public class frequency {

    public static void main(String[] args) {

        int a[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        for (Integer key : map.keySet()) {
            if (map.get(key) > a.length / 3) {
                System.out.print(key + " ");
            }
        }

    }

}
