import java.util.Arrays;

public class anagram {
    public static void main(String[] args) {

        String str1 = "earth";
        String str2 = "heart";

        // convert strings to lowercase cause we don't have to check separately for
        // upper case
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // First check if the lengths are same or not
        if (str1.length() == str2.length()) {
            // convert strings into char array
            char[] str1charArray = str1.toCharArray();
            char[] str2charArray = str2.toCharArray();

            // sort the char array
            Arrays.sort(str1charArray);
            Arrays.sort(str2charArray);

            // if sorted char arrays are same then strings are anagram
            boolean res = Arrays.equals(str1charArray, str2charArray);
            if (res) {
                System.out.println(str1 + " and " + str2 + " are anagrams of each other");
            } else {
                System.out.println(str1 + " and " + str2 + " are not anagrams of each other");
            }
        } else {
            // when the lengths are not equal
            System.out.println(str1 + " and " + str2 + " are not anagrams of each other");
        }

    }

}
