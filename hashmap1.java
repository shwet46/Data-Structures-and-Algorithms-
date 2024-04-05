import java.util.*;

public class hashmap1 {

    public static void main(String[] args) {

        HashMap<String, Integer> menu = new HashMap<>();

        menu.put("Tea", 15);
        menu.put("Samosa", 20);
        menu.put("Vadapav", 22);
        menu.put("Coffee", 25);
        menu.put("Idli sambar", 50);

        // System.out.println(menu);
        // get() -> time complexity = O(n)
        // System.out.println(menu.get("Tea")); // output = 15
        // containsKey() -> time complexity = O(n)
        // System.out.println(menu.containsKey("Samosa")); // output = true

        // menu.clear();
        // System.out.println(menu); // this will print an empty hashMap

        Set<String> keys = menu.keySet();
        System.out.println("---------- MENU ---------");
        System.out.println("Item , Price");
        for (String k : keys) {
            System.out.println(k + " , " + menu.get(k));
        }

    }

}
