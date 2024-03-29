public class friendspairing {

    public static int frPair(int n) {

        if (n == 1 || n == 0) {
            return 1;
        }

        return frPair(n - 1) + (n - 1) * frPair(n - 2);

    }

    public static void main(String[] args) {

        System.out.println(frPair(3));

    }

}
