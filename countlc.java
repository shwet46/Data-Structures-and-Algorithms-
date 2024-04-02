public class countlc { // count how many lowercase vowels occured in a string

    public static int countLowerCase(String s) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        String s1 = "ShhayaaKapoor";
        String s2 = "Shhayaadidi";

        System.out.println(countLowerCase(s1));
        System.out.println(countLowerCase(s2));

    }

}
