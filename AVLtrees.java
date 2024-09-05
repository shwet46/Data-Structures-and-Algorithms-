public class AVLtrees {

    static class Node {
        int data;
        int height;
        Node left, right;

        Node(int data) {
            this.data = data;
            height = 1; // helps for calculating the balance factor
        }
    }

    public static Node root;

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        return root.height;
    }

    // this rotation is used for LL case
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // this case is used for RR case
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // calculating the balance factor
    public static int getBalance(Node root) {
        if (root == null) {
            return 0;
        }
        return height(root.left) - height(root.right);
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }

        if (val < root.data) {
            root.left = insert(root.left, val);
        } else if (val > root.data) {
            root.right = insert(root.right, val);
        } else {
            return root;
        }

        root.height = 1 + Math.max(height(root.left), height(root.right));

        int bf = getBalance(root);

        if (bf > 1 && val < root.left.data) {
            return rightRotate(root);
        }

        if (bf < -1 && val > root.right.data) {
            return leftRotate(root);
        }

        if (bf > 1 && val > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if (bf < -1 && val < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static Node getMinNode(Node root) {
        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public static Node deleteNode(Node root, int val) {
        if (root == null) {
            return root;
        }

        if (val < root.data) {
            root.left = deleteNode(root.left, val);
        } else if (val > root.data) {
            root.right = deleteNode(root.right, val);
        } else {
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left) {
                    temp = root.right;
                } else {
                    temp = root.left;
                }
                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    root = temp;
                }
            } else {
                Node temp = getMinNode(root.right);
                root.data = temp.data;
                root.right = deleteNode(root.right, temp.data);
            }
        }

        if (root == null) {
            return root;
        }

        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int bf = getBalance(root);

        if (bf > 1 && getBalance(root.left) >= 0) {
            return rightRotate(root);
        }
        if (bf > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (bf < -1 && getBalance(root.right) <= 0) {
            return leftRotate(root);
        }
        if (bf < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        root = insert(root, 4);
        root = insert(root, 12);
        root = insert(root, 20);
        root = insert(root, 25);
        root = insert(root, 34);
        root = insert(root, 46);

        inorder(root);
        System.out.println();

        deleteNode(root, 34);

        inorder(root);
    }

}
