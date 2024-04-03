import java.util.*;

public class distnum {

    public static void main(String[] args) {

        int num[] = { 1, 4, 3, 5, 3, 3, 5, 6, 7, 7 };
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < num.length; i++) {
            set.add(num[i]);
        }

        System.out.println(set.size());

    }

}
