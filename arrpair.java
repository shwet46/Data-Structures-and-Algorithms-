
public class arrpair {

    public static boolean pair(int a[]) {

        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int a[] = { 1, 3, 2, 1 };
        System.out.println(pair(a));

        int a1[] = { 1, 2, 3, 4 };
        System.out.println(pair(a1));

        int a2[] = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        System.out.println(pair(a2));

    }

}
