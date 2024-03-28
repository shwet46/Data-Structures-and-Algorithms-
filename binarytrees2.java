import java.util.*;

public class binarytrees2 {

    static class Node {
        int data;
        Node right, left;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static int height(Node root) { // time complexity -> O(n)
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;
    }

    public static int count(Node root) {
        if (root == null) {
            return 0;
        }

        int lc = count(root.left);
        int rc = count(root.right);
        return lc + rc + 1;
    }

    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }

        int ls = sum(root.left);
        int rs = sum(root.right);

        return ls + rs + root.data;
    }

    public static int diameter2(Node root) { // time complexity -> O(n^2)
        if (root == null) {
            return 0;
        }

        int ldiam = diameter2(root.left);
        int lh = height(root.left);
        int rdiam = diameter2(root.right);
        int rh = height(root.right);

        return Math.max(lh + rh + 1, Math.max(ldiam, rdiam));
    }

    static class Info {
        int diam;
        int ht;

        public Info(int diam, int ht) {
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht + rightInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    public static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }

        return true;

    }

    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    static class Info1 {
        Node node;
        int hd;

        public Info1(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void topView(Node root) {
        // Level order
        Queue<Info1> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        int min = 0, max = 0;

        q.add(new Info1(root, 0));
        q.add(null);

        while (!q.isEmpty()) {
            Info1 curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) {
                    map.put(curr.hd, curr.node);
                }
                if (curr.node.left != null) {
                    q.add(new Info1(curr.node.left, curr.hd - 1));
                    min = Math.min(min, curr.hd - 1);
                }
                if (curr.node.right != null) {
                    q.add(new Info1(curr.node.right, curr.hd + 1));
                    max = Math.max(max, curr.hd + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void kthNode(Node root, int level, int k) {
        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        kthNode(root.left, level + 1, k);
        kthNode(root.right, level + 1, k);
    }

    public static Node lca(Node root, int n1, int n2) {
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }

        Node leftLca = lca(root.left, n1, n2);
        Node rightLca = lca(root.right, n1, n2);

        // left Lca = val right Lca = null
        if (rightLca == null) {
            return leftLca;
        }
        if (leftLca == null) {
            return rightLca;
        }

        return root;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int lcaDistLeft = lcaDist(root.left, n);
        int lcaDistRight = lcaDist(root.right, n);

        if (lcaDistLeft == -1 && lcaDistRight == -1) {
            return -1;
        } else if (lcaDistLeft == -1) {
            return lcaDistRight + 1;
        } else {
            return lcaDistLeft + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);

        return dist1 + dist2;
    }

    public static int kthAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }
        if (root.data == n) {
            return 0;
        }

        int leftdist = kthAncestor(root.left, n, k);
        int rightdist = kthAncestor(root.right, n, k);

        int max = Math.max(leftdist, rightdist);
        if (max + 1 == k) {
            System.out.println(root.data + " ");
        }

        return max + 1;
    }

    public static int tranformSum(Node root) {
        if (root == null) {
            return 0;
        }

        int leftChild = tranformSum(root.left);
        int rightChild = tranformSum(root.right);

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;

        int data = root.data;
        root.data = newLeft + leftChild + newRight + rightChild;

        return data;
    }

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {

        /*
         * 1
         * / \
         * 2 3
         * / \ \
         * 4 5 6
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.left = new Node(7);

        // System.out.println("Height of tree = " + height(root));
        // System.out.println("Count of nodes = " + count(root));
        // System.out.println("Sum of Nodes = " + sum(root));
        // System.out.println("Diameter of tree = " + diameter(root).diam);

        // 2
        // / \
        // 4 5

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);

        System.out.println("is subroot = " + isSubtree(root, subRoot));
        topView(root);
        kthNode(root, 1, 3);
        System.out.println();

        int n1 = 4, n2 = 5;
        System.out.println("Lca = " + lca(root, n1, n2).data);
        kthAncestor(root, 2, 2);
        System.out.println();
        tranformSum(root);
        preOrder(root);

    }

}
