public class doubleLL {

    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;

    }

    public int removeFirst() {

        int val;
        if (head == null) {
            System.out.println("The list is empty");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void printDLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <=> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeLast() {

        int val;
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        Node prev = head;
        // i = size-2
        for (int i = 0; i <= size - 2; i++) {
            prev = prev.next;
        }

        val = prev.data;
        prev.next = null;
        tail = prev;
        size--;

        return val;
    }

    public void reverseDLL(){
        
    }

    public static void main(String[] args) {

        doubleLL dll = new doubleLL();
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.addLast(4);
        dll.addLast(5);
        dll.addLast(6);
        // dll.printDLL();
        // dll.removeFirst();
        dll.printDLL();

    }
}
