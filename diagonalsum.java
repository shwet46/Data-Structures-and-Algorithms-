public class diagonalsum {

    public static int digsum(int a[][]) {
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i][i];

            if (i != a.length - 1 - i) {
                sum += a[i][a.length - i - 1];
            }

        }

        return sum;
    }

    public static void main(String[] args) {

        int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println(digsum(a));

    }

}
