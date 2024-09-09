import java.util.*;

public class RedBlackTrees {

    public RedBlackTrees() {
        super();
        root = null;
    }

    public Node root;

    class Node {
        int data;
        Node left, right;
        char color;
        Node parent;

        Node(int data) {
            super();
            this.data = data; // only data
            this.left = null;
            this.right = null;
            this.color = 'R';
            this.parent = null;
        }
    }

    Node rotateLeft(Node node) {
        Node x = node.right;
        Node y = x.left;
        x.left = node;
        node.right = y;
        node.parent = x;

        if (y != null) {
            y.parent = node;
        }

        return (x);
    }

    Node rotateRight(Node node) {
        Node x = node.left;
        Node y = x.right;
        x.right = node;
        node.left = y;
        node.parent = x;

        if (y != null) {
            y.parent = node;
        }

        return (x);
    }

    boolean ll = false;
    boolean rr = false;
    boolean lr = false;
    boolean rl = false;

    Node insertHelp(Node root, int data) {
        boolean f = false;

        if (root == null) {
            return new Node(data);
        } else if (data < root.data) {
            root.left = insertHelp(root.left, data);
            root.left.parent = root;
            if (root != this.root) {
                if (root.color == 'R' && root.left.color == 'R') {
                    f = true;
                }
            }
        } else {
            root.right = insertHelp(root.right, data);
            root.right.parent = root;
            if (root != this.root) {
                if (root.color == 'R' && root.right.color == 'R') {
                    f = true;
                }
            }
        }

        if (this.ll) {
            root = rotateLeft(root);
            root.color = 'B';
            root.left.color = 'R';
            this.ll = false;
        } else if (this.rr) {
            root = rotateRight(root);
            root.color = 'B';
            root.right.color = 'R';
            this.rr = false;
        } else if (this.rl) {
            root.right = rotateRight(root.right);
            root.right.parent = root.right;
            root = rotateLeft(root);
            root.color = 'B';
            root.left.color = 'R';
            this.rl = false;
        } else if (this.rl) {
            root.left = rotateLeft(root.left);
            root.left.parent = root;
            root = rotateRight(root);
            root.color = 'B';
            root.right.color = 'R';
            this.lr = false;
        }

        if (f) {
            if (root.parent.right == root) {
                if (root.parent.left == null || root.parent.left.color == 'B') {
                    if (root.left != null && root.left.color == 'R') {
                        this.rl = true;
                    } else if (root.right != null && root.right.color == 'R') {
                        this.ll = true;
                    } else {
                        root.parent.left.color = 'B';
                        root.color = 'B';
                        if (root.parent != this.root) {
                            root.parent.color = 'R';
                        }
                    }
                } else {
                    root.parent.left.color = 'B';
                    root.color = 'B';
                    if (root.parent != this.root) {
                        root.parent.color = 'R';
                    }
                }
            } else {
                if (root.parent.right == null || root.parent.right.color == 'B') {
                    if (root.left != null && root.left.color == 'R') {
                        this.rr = true;
                    } else if (root.right != null && root.right.color == 'R') {
                        this.rl = true;
                    }
                } else {
                    root.parent.right.color = 'B';
                    root.color = 'B';
                    if (root.parent != this.root) {
                        root.parent.color = 'R';
                    }
                }
            }
            f = false;
        }

        return root;
    }

    public void insert(int data) {
        if (this.root == null) {
            this.root = new Node(data);
            this.root.color = 'B';
        } else {
            this.root = insertHelp(this.root, data);
        }
    }

    void inorderHelper(Node node) {
        if (node != null) {
            inorderHelper(node.left);
            System.out.print(node.data + " ");
            inorderHelper(node.right);
        }
    }

    public void inorder() {
        inorderHelper(this.root);
    }

    void printTreeHelper(Node root, int space) {
        int i;
        if (root != null) {
            space = space + 10;
            printTreeHelper(root.right, space);
            System.out.println();
            for (i = 10; i < space; i++) {
                System.out.print(" ");
            }
            System.out.print(root.data + " ");
            System.out.println();
        }
    }

    public void printTree() {
        printTreeHelper(this.root, 0);
    }

    public static void main(String[] args) {

        RedBlackTrees rbt = new RedBlackTrees();
        int arr[] = { 3, 6, 8, 10, 14, 18, 20, 21, 25 };

        for (int i = 0; i < arr.length; i++) {
            rbt.insert(arr[i]);
            System.out.println();
            rbt.inorder();
        }

        rbt.printTree();

    }

}
