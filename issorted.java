public class issorted {

    public static boolean sorted(int a[], int i) {

        if (i == a.length - 1) {
            return true;
        }

        if (a[i] > a[i + 1]) {
            return false;
        }

        return sorted(a, i + 1);
    }

    public static void main(String[] args) {

        int a1[] = { 1, 2, 3, 4, 5 };
        int a2[] = { 3, 5, 7, 6, 2 };

        System.out.println(sorted(a1, 0));

        System.out.println(sorted(a2, 0));

    }

}
