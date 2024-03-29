public class power {

    public static int pow1(int x, int n) {

        if (n == 0) {
            return 1;
        }

        return x * pow1(x, n - 1);
    }

    public static int pow2(int x, int n) { // time complexity => O(logn)

        if (n == 0) {
            return 1;
        }

        int xn = pow2(x, n / 2);
        int powx = xn * xn;

        if (n % 2 != 0) {
            return x * powx;
        }

        return powx;
    }

    public static void main(String[] args) {

        System.out.println(pow1(2, 5));
        System.out.println(pow2(2, 5));

    }

}
