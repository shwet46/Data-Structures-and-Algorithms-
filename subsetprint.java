public class subsetprint {

    public static void printSubsets(String s, String ans, int i) {

        if (i == s.length()) {
            System.out.println(ans);
            return;
        }

        // yes
        printSubsets(s, ans + s.charAt(i), i + 1);
        // no
        printSubsets(s, ans, i + 1);
    }

    public static void main(String[] args) {

        String s = "abc";
        printSubsets(s, "", 0);
        System.out.println("These are the subsets");

    }

}
