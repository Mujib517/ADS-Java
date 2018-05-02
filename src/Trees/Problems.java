package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    public static void spiralOrder(TNode root) {
        if (root == null) return;
        Stack<TNode> s1 = new Stack<>();
        Stack<TNode> s2 = new Stack<>();

        s1.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {

            while (!s1.isEmpty()) {
                TNode node = s1.pop();
                System.out.print(node.data + " ");

                if (node.right != null) s2.push(node.right);
                if (node.left != null) s2.push(node.left);
            }


            while (!s2.isEmpty()) {
                TNode node = s2.pop();
                System.out.print(node.data + " ");

                if (node.left != null) s1.push(node.left);
                if (node.right != null) s1.push(node.right);
            }
        }
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

    public static boolean isBST(TNode root, int min, int max) {
        if (root == null) return true;
        if (root.data < min || root.data > max) return false;
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
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
