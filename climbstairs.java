import java.util.Arrays;

public class climbstairs {

    // memoization - O(n) | recursion (2^n) -> n = 10^5

    /*
     * public static int countWays(int n) { // recursive way
     * if (n == 0) {
     * return 1;
     * }
     * if (n < 0) {
     * return 0;
     * }
     * 
     * return countWays(n - 1) + countWays(n - 2);
     * }
     */

    public static int countWays(int n, int ways[]) { // memoization code
        if (n == 0) { // time complexity -> O(n)
            return 1;
        }
        if (n < 0) {
            return 0;
        }

        if (ways[n] != -1) { // already calculated
            return ways[n];
        }

        ways[n] = countWays(n - 1, ways) + countWays(n - 2, ways);
        return ways[n];
    }

    public static int countWaysTab(int n) {
        int dp[] = new int[n + 1]; // time complexity -> O(n)
        dp[0] = 1;

        // tabulation loop
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5; // n=3 -> & n=4 -> 5 => 8
        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println(countWays(n, ways));
        System.out.println(countWaysTab(n));
    }

}
