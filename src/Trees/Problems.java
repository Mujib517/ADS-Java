package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Problems {

    public static TNode buildTree(int[] arr, int n) {
        if (n <= 0) return null;

        TNode root = new TNode(arr[0]);
        TNode temp = root;

        for (int i = 1; i < n; i++) {
            add(temp, arr[i]);
        }

        return root;
    }

    public static void inOrder(TNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(TNode root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void preOrder(TNode root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static int findMin(TNode root) {
        if (root == null) return Integer.MIN_VALUE;

        while (root.left != null) {
            root = root.left;
        }

        return root.data;
    }

    public static int findMax(TNode root) {
        if (root == null) return Integer.MAX_VALUE;

        while (root.right != null) {
            root = root.right;
        }

        return root.data;
    }

    public static boolean find(TNode root, int val) {

        while (root != null) {
            if (root.data == val) return true;
            if (root.data < val) root = root.right;
            else root = root.left;
        }

        return false;
    }

    public static int height(TNode root) {

        if (root == null) return -1;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void levelOrder(TNode root) {
        if (root == null) return;

        Queue<TNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TNode node = q.poll();
            System.out.print(node.data + " ");
            if (node.left != null) q.add(node.left);
            if (node.right != null) q.add(node.right);
        }
    }

    public static void levelOrder2(TNode root) {
        if (root == null) return;

        Queue<TNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TNode node = q.poll();

            if (node == null) {
                System.out.println();
                if (!q.isEmpty()) q.add(null);
            } else {

                System.out.print(node.data + " ");
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
    }

    private static void add(TNode temp, int val) {
        if (temp == null) return;

        TNode newNode = new TNode(val);

        while (true) {

            if (temp.data > val) {
                if (temp.left == null) {
                    temp.left = newNode;
                    break;
                } else
                    temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    break;
                }
                temp = temp.right;
            }
        }
    }
}
