import java.util.ArrayList;
import java.util.Arrays;

public class sortString {

    public static ArrayList<String> sortItems(int n, String[] items) {
        // code here

        ArrayList<String> list = new ArrayList<>(Arrays.asList(items));
        list.sort((a, b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return a.length() - b.length();
            }
        });
        return list;
    }

    public static void main(String[] args) {

        String items[] = { "DD", "A", "B", "ZZ", "ABCDE" };
        System.out.println(sortItems(5, items));

    }

}
