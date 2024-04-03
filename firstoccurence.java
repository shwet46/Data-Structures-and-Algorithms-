public class firstoccurence {

    public static int firstOcc(int a[], int i, int key) {

        if (i == a.length - 1) {
            return -1;
        }

        if (a[i] == key) {
            return i;
        }

        return firstOcc(a, i + 1, key);
    }

    public static void main(String[] args) {

        int a[] = { 1, 4, 3, 5, 6, 7, 3, 5 };

        System.out.println(firstOcc(a, 0, 3));

    }

}
