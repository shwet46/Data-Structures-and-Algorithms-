import java.util.Scanner;

public class Repititions {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int maxLen = 1;
        int currLen = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                currLen++;
            } else {
                maxLen = Math.max(maxLen, currLen);
                currLen = 1;
            }
        }

        maxLen = Math.max(maxLen, currLen);

        System.out.print(maxLen);

        sc.close();

    }
}
