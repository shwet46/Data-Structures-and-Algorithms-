import java.util.*;

public class reverseQueue {

    public static Queue<Integer> revQueue(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<Integer>();
        Queue<Integer> q1 = new LinkedList<Integer>();

        for (int i = 0; i < k; i++) {
            s.push(q.remove());
        }

        while (!q.isEmpty()) {
            q1.add(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        while (!q1.isEmpty()) {
            q.add(q1.remove());
        }

        return q;
    }

    public static void main(String[] args) {

        Queue<Integer> qsb = new LinkedList<>();

        qsb.add(10);
        qsb.add(20);
        qsb.add(30);
        qsb.add(40);
        qsb.add(50);
        qsb.add(60);
        qsb.add(70);
        qsb.add(80);
        qsb.add(90);
        qsb.add(100);

        revQueue(qsb, 5);

        while (!qsb.isEmpty()) {
            System.out.print(qsb.remove() + " ");
        }

    }

}
