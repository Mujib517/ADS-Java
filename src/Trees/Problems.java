package Trees;

import LinkedLists.DNode;

import java.util.*;

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

    public static void delete(TNode root, int val) {

    }

    public static TNode[] findparent(TNode root, int val) {
        if (root == null) return null;

        TNode[] nodes = new TNode[2];
        nodes[0] = null;

        while (root != null) {

            if (root.data == val) {
                nodes[1] = root;
                break;
            }
            nodes[0] = root;
            if (root.data > val) root = root.left;
            else root = root.right;
        }

        return nodes;
    }

    public static int lca(TNode root, int n1, int n2) {

        TNode nd1 = findNode(root, n1);
        TNode nd2 = findNode(root, n2);
        TNode result = lca(root, nd1, nd2);

        return result == null ? -1 : result.data;
    }

    //Clue: Calculate depth of a node. Right child is at the same depth as that of root
    //Depth of left child is depth(root)+1
    public static void diagonalSum(TNode root) {
        HashMap<Integer, Integer> sum = new HashMap<>();

        diagonalSum(root, 0, sum);

        for (Integer key : sum.keySet()) {
            System.out.println(sum.get(key));
        }

    }

    //Given a pre order traversal array find if every node has only one child
    //Clue: All preceding elments are higher and all subsequent elements are lower the every node will have one child
    //Ex: {9,8,5,7,6} True, {8,5,4,7,6} False
    public static boolean hasOnlyOneChild(int[] arr) {
        int n = arr.length;
        int max = arr[n - 1], min = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            if (!(arr[i] > max || arr[i] < min)) return false;

            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        return true;
    }

    public static void nodeWithNoSibling(TNode root) {
        if (root == null) return;
        if (root.left != null && root.right == null) System.out.print(root.left.data + " ");
        else if (root.right != null && root.left == null) System.out.print(root.right.data + " ");

        nodeWithNoSibling(root.left);
        nodeWithNoSibling(root.right);
    }

    public static boolean isFBT(TNode root) {
        if (root == null) return true;
        if (hasOnlyOneChild(root)) return false;
        return isFBT(root.left) && isFBT(root.right);
    }

    public static void leftView(TNode root) {
        if (root == null) return;

        Queue<TNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean print = true;

        while (!q.isEmpty()) {

            TNode nd = q.poll();
            if (print) {
                System.out.print(nd.data + " ");
                print = false;
            }
            if (nd == null) {
                if (q.size() != 0) q.add(null);
                print = true;
                continue;
            }
            if (nd.left != null) q.add(nd.left);
            if (nd.right != null) q.add(nd.right);
        }
    }

    public static void rightView(TNode root) {
        if (root == null) return;
        Queue<TNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        boolean print = true;

        while (!q.isEmpty()) {
            TNode nd = q.poll();
            if (nd == null) {
                if (!q.isEmpty()) q.add(null);
                print = true;
                continue;
            }

            if (print) {
                System.out.println(nd.data);
                print = false;
            }

            if (nd.right != null) q.add(nd.right);
            if (nd.left != null) q.add(nd.left);
        }
    }

    //clue: Use horizontal distance. Left node Horizontal Distance: root distance -1,
    //Right node horizontal distance: root distance+1
    public static void verticalOrder(TNode root) {
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        verticalOrder(root, map, 0);

        for (Integer item : map.keySet()) {
            ArrayList<Integer> list = map.get(item);

            for (Integer node : list) System.out.print(node + " ");

            System.out.println();
        }
    }

    public static void printNodeWithNoSibling(TNode root) {
        if (root == null) return;
        if (root.left != null && root.right == null) System.out.print(root.left.data + " ");
        else if (root.right != null && root.left == null) System.out.print(root.right.data + " ");

        printNodeWithNoSibling(root.left);
        printNodeWithNoSibling(root.right);
    }

    //Clue: Should not be siblings and should be at the same level
    public static boolean areCousins(TNode root, int n1, int n2) {
        if (n1 == n2) return false;
//        return areSiblings(root, n1, n2);
        return !areSiblings(root, n1, n2) &&
                (findLevel(root, n1, -1) == findLevel(root, n2, -1));
    }

    //Balanced tree = leftHeight-rightHeight<=1
    public static boolean isBalnacedTree(TNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    //Complete binary tree: All the levels are filled except last level. Left most nodes are filled first than right most
    public static boolean isCBT(TNode root) {
        return isCBT(root, false);
    }

    public static int count(TNode root) {
        if (root == null) return 0;
        return count(root.left) + count(root.right) + 1;
    }

    private static boolean isCBT(TNode root, boolean nonFullNodeSeen) {
        if (root == null) return true;
        if (root.left == null && root.right != null) return false;
        if (root.left == null) nonFullNodeSeen = true;
        return isCBT(root.left, nonFullNodeSeen) && isCBT(root.right, nonFullNodeSeen);
    }

    private static boolean areSiblings(TNode root, int n1, int n2) {
        if (root == null || root.left == null || root.right == null) return false;
        if ((root.left.data == n1 && root.right.data == n2) || (root.left.data == n2 && root.right.data == n1))
            return true;
        return areSiblings(root.left, n1, n2) || areSiblings(root.right, n1, n2);
    }

    private static int findLevel(TNode root, int n1, int level) {
        if (root == null || root.data == n1) return level;

        int l = findLevel(root.left, n1, level + 1);
        return l == -1 ? findLevel(root.right, n1, level + 1) : l;
    }

    private static void verticalOrder(TNode root, Map<Integer, ArrayList<Integer>> map, int hDistance) {
        if (root == null) return;

        if (map.containsKey(hDistance)) {
            ArrayList<Integer> list = map.get(hDistance);
            list.add(root.data);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            map.put(hDistance, list);
        }

        verticalOrder(root.left, map, hDistance - 1);
        verticalOrder(root.right, map, hDistance + 1);
    }

    private static boolean hasOnlyOneChild(TNode root) {
        return (root.right != null && root.left == null) || (root.right == null && root.left != null);
    }

    private static void diagonalSum(TNode root, int depth, HashMap<Integer, Integer> sum) {
        if (root == null) return;

        if (sum.containsKey(depth)) sum.put(depth, sum.get(depth) + root.data);
        else sum.put(depth, root.data);

        diagonalSum(root.right, depth, sum);
        diagonalSum(root.left, depth + 1, sum);
    }

    private static TNode findNode(TNode root, int n1) {
        if (root == null) return null;
        if (root.data == n1) return root;
        if (root.data < n1) return findNode(root.right, n1);

        return findNode(root.left, n1);
    }

    private static TNode lca(TNode root, TNode n1, TNode n2) {

        if (root == null) return null;

        if (n1.data < root.data && root.data < n2.data) return root;
        if (n1.data == root.data || n2.data == root.data) return root;

        if (n2.data < root.data) return lca(root.left, n1, n2);
        return lca(root.right, n1, n2);
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
