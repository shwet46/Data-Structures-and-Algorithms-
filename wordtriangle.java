public class wordtriangle {

    public static void print(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(s.charAt(j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        print("JAVA");
        System.out.println();
        print("development");

    }

}
