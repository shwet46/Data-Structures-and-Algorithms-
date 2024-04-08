public class oddeveLL {

    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node head;

    void segregateEvenOdd() {
        Node end = head;
        Node prev = null;
        Node curr = head;

        while (end.next != null) {
            end = end.next;
        }

        Node newEnd = end;

        while (curr.data % 2 != 0 && curr != end) {
            newEnd.next = curr;
            curr = curr.next;
            newEnd.next.next = null;
            newEnd = newEnd.next;
        }

        if (curr.data % 2 == 0) {
            head = curr;
            while (curr != end) {
                if (curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                } else {
                    prev.next = curr.next;
                    curr.next = null;
                    newEnd.next = curr;
                    newEnd = curr;
                    curr = prev.next;
                }
            }
        } else {
            prev = curr;
        }

        if (newEnd != end && end.data % 2 != 0) {
            prev.next = end.next;
            end.next = null;
            newEnd.next = end;
        }
    }

    void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        oddeveLL list = new oddeveLL();

        list.push(11);
        list.push(10);
        list.push(7);
        list.push(6);
        list.push(3);
        list.push(2);
        list.push(0);

        System.out.println("Linked list");
        list.printList();
        list.segregateEvenOdd();
        System.out.println("Updated Linked List");
        list.printList();

    }

}
