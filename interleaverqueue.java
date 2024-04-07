import java.util.Queue;
import java.util.LinkedList;

public class interleaverqueue {

    public static void interleave(Queue<Integer> q) {
        Queue<Integer> q1 = new LinkedList<>(); // firstHalf
        int size = q.size();

        for (int i = 0; i < size / 2; i++) {
            q1.add(q.remove());
        }

        while (!q1.isEmpty()) {
            q.add(q1.remove());
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {

        Queue<Integer> qu = new LinkedList<>();
        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        qu.add(5);
        qu.add(6);
        qu.add(7);
        qu.add(8);
        qu.add(9);
        qu.add(10);
        interleave(qu);

        while (!qu.isEmpty()) {
            System.out.print(qu.remove() + " ");
        }

    }

}
