import java.util.Stack;

public class strcode {

    static String decode(String str) {
        Stack<Integer> n = new Stack<>();
        Stack<Character> s = new Stack<>();

        String temp = "", result = "";
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            if (Character.isDigit(str.charAt(i))) {
                while (Character.isDigit(str.charAt(i))) {
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }
                i--;
                n.push(count);
            } else if (str.charAt(i) == ']') {
                temp = "";
                count = 0;
                if (!n.isEmpty()) {
                    count = n.peek();
                    n.pop();
                }

                while (!s.isEmpty() && s.peek() != '[') {
                    temp = s.peek() + temp;
                    s.pop();
                }

                if (!s.isEmpty() && s.peek() == '[') {
                    s.pop();
                }

                for (int j = 0; j < count; j++) {
                    result = result + temp;
                }

                for (int j = 0; j < result.length(); j++) {
                    s.push(result.charAt(j));
                }

                result = "";
            } else if (str.charAt(i) == '[') {
                if (Character.isDigit(str.charAt(i - 1))) {
                    s.push(str.charAt(i));
                } else {
                    s.push(str.charAt(i));
                    n.push(1);
                }
            } else {
                s.push(str.charAt(i));
            }
        }

        while (!s.isEmpty()) {
            result = s.peek() + result;
            s.pop();
        }

        return result;

    }

    public static void main(String[] args) {

        String str = "3[b2[v]]L";
        System.out.println(decode(str));

    }

}
