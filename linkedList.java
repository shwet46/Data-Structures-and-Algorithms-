public class linkedList {

    public static class Node { // creating a node object
        int data; // this will store data
        Node next; // this is created to store reference to next node

        Node(int data) {
            this.data = data;
            this.next = null; // we are pointing the first node to null
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) { // time complexity = O(1)

        // step 1 -> create new node
        Node newNode = new Node(data);
        size++;

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2 -> newNode ka next = head
        newNode.next = head;

        // step 3 -> head = newNode
        head = newNode;
    }

    public void addLast(int data) { // time complexity = O(1)
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void add(int idx, int data) {

        if (idx == 0) {
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        size++;
        int i = 0;
        Node temp = head;

        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }

        // i -> idx-1 temp -> prev
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void printLL() { // time complexity = O(n)
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int removeFirst() {

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
        val = head.data;
        head = head.next;
        size--;
        return val;
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

        // prev i = size-2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }

        val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int itrSearch(int key) { // time complexity = O(n)
        Node temp = head;
        int i = 0;

        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }

        return i; // key not found
    }

    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }

        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    public int recSearch(int key) {
        return helper(head, key);
    }

    public void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public Node midfind(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }

        return slow; // middle wala node
    }

    // from here the code to check if a linked is is palindrome or not is there.
    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // step 1 -> find mid
        Node midNode = midfind(head);

        // step 2 -> reverse second half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right half head
        Node left = head;

        // step 3 -> check left half & right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    // from here the code of merge sort is there.
    private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private Node merge(Node head1, Node head2) {
        Node mergedll = new Node(-1);
        Node temp = mergedll;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = temp.next;
                temp = temp.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergedll.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        // find mid
        Node mid = getMid(head);

        // left and right
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;

        // 2nd half reverse
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // alternate merge zig-zag
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

    }

    public void deleteNthfromEnd(int n){
        //calculate size
        int sz = 0;
        Node temp = head;

        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n==sz){
            head = head.next; //remove first
            return;
        }

        //sz-n
        int i=1;
        int iToFind = sz-n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    public static void main(String[] args) {

        /*
         * linkedList ll = new linkedList();
         * ll.printLL();
         * ll.addFirst(1);
         * ll.addFirst(2);
         * ll.addLast(5);
         * ll.addLast(4);
         * ll.add(2, 7);
         * ll.printLL();
         * System.out.println(ll.size);
         * System.out.println(ll.checkPalindrome());
         */

        linkedList ll = new linkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.printLL();
        ll.zigZag();
        ll.printLL();

    }

}
