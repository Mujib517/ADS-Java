package Trees;

import LinkedLists.DNode;
import sun.reflect.generics.tree.Tree;

import javax.swing.tree.TreeNode;
import java.util.*;

import java.util.LinkedList;
import java.util.Queue;

public class Problems {

    static int preIndex = 0;

    static int postIndex;

    static class MinMax {
        int min;
        int max;
        boolean isBST;
        int size;

        MinMax() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isBST = true;
            size = 0;
        }
    }

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
        if (root == null) return;

        TNode[] result = findparent(root, val);
        TNode node = result[1];
        TNode parent = result[0];

        if (node == null) return;

        //Case1: No children
        if (node.left == null && node.right == null) {
            if (parent.left != null && parent.left.data == val) parent.left = null;
            else if (parent.right != null && parent.right.data == val) parent.right = null;
        }

        //case 2: with only child
        else if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
            if (parent.left != null && parent.left.data == val)
                parent.left = node.left == null ? node.right : node.left;
            else if (parent.right != null && parent.right.data == val)
                parent.right = node.left == null ? node.right : node.left;
        }

        //case 3: With children
        else {

            TNode temp = node.left;

            while (temp.right != null) {
                temp = temp.right;
            }

            temp.left = node.left;
            temp.right = node.right;

            if (parent.left != null && parent.left.data == val)
                parent.left = temp;
            else if (parent.right != null && parent.right.data == val)
                parent.right = temp;
        }
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

    public static void topView(TNode root) {
        if (root == null) return;
        System.out.println(root.data);
        printLeft(root.left);
        printRight(root.right);
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

    public static boolean areIdentical(TNode root1, TNode root2) {
        if (root1 == null && root2 == null) return true;
        if ((root1 == null && root2 != null) || (root1 != null && root2 == null)) return false;
        if (root1.data != root2.data) return false;

        return areIdentical(root1.left, root2.left) && areIdentical(root1.right, root2.right);
    }

    public static TNode mirrorTree(TNode root) {
        if (root == null) return root;

        TNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }

    public static int minDepth(TNode root) {
        if (root == null) return 0;
        int lDepth = minDepth(root.left);
        int rDepth = minDepth(root.right);

        return 1 + Math.min(lDepth, rDepth);
    }

    public static int maxDepth(TNode root) {
        if (root == null) return 0;
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);

        return 1 + Math.max(lDepth, rDepth);
    }

    //Build Balanced Binary tree from sorted array
    public static TNode treeFromSortedArray(int[] sortedArray) {
        return treeFromSortedArray(sortedArray, 0, sortedArray.length - 1);
    }

    //clue: approach1:  Do a pre order search and form an array return the nth element from the end O(N),O(N)
    //approach2: do a reverse pre order search and keep track of iteration. O(N),O(1)
    public static int nthLargestElement(TNode root, int n) {
        return nthLargestElement(root, 0, n).data;
    }

    public static boolean rootToLeafSum(TNode root, int sum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && sum == root.data) return true;
        return (rootToLeafSum(root.left, sum - root.data) || rootToLeafSum(root.right, sum - root.data));


    }

    public static int largestBST(TNode root) {
        return largestBSTUtil(root).size;
    }

    private static int findEelement(int[] in, int val, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (in[i] == val) return i;
        }
        return -1;
    }

    public static TNode treeFromPreOrderInOrder(int in[], int pre[], int inStrt, int inEnd) {
        if (inStrt > inEnd) return null;

        TNode tNode = new TNode(pre[preIndex++]);
        if (inStrt == inEnd) return tNode;

        int inIndex = search(in, inStrt, inEnd, tNode.data);

        tNode.left = treeFromPreOrderInOrder(in, pre, inStrt, inIndex - 1);
        tNode.right = treeFromPreOrderInOrder(in, pre, inIndex + 1, inEnd);

        return tNode;
    }

    public static TNode treeFromPostInOrder(int[] in, int[] post) {
        postIndex = in.length - 1;

        return treeFromPostInOrder(in, post, 0, in.length - 1);
    }

    private static TNode treeFromPostInOrder(int[] in, int[] post, int start, int end) {
        if (start > end || postIndex < 0) return null;

        TNode root = new TNode(post[postIndex--]);
        if (start == end) return root;

        int idx = search(in, start, end, root.data);
        root.right = treeFromPostInOrder(in, post, idx + 1, end);
        root.left = treeFromPostInOrder(in, post, start, idx - 1);


        return root;
    }

    private static int search(int arr[], int strt, int end, int value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value)
                return i;
        }
        return i;
    }

    /*
    TNode root = new TNode(25);

        TNode n18 = new TNode(18);
        TNode n19 = new TNode(19);
        TNode n15 = new TNode(15);

        TNode n20 = new TNode(20);
        TNode n18r = new TNode(18);
        TNode n25 = new TNode(25);


        TNode n50 = new TNode(50);
        TNode n35 = new TNode(35);
        TNode n60 = new TNode(60);
        TNode n20r = new TNode(20);
        TNode n40 = new TNode(40);
        TNode n25r = new TNode(25);
        TNode n55 = new TNode(55);
        TNode n70 = new TNode(70);


        root.left = n18;
        n18.left = n19;
        n18.right = n20;
        n19.right = n15;

        n20.left = n18r;
        n20.right = n25;

        root.right = n50;
        n50.left = n35;
        n50.right = n60;

        n35.left = n20r;
        n35.right = n40;

        n20r.right = n25r;

        n60.left = n55;
        n60.right = n70;
     */
    //Post order traversal to find out largest bst
    private static MinMax largestBSTUtil(TNode root) {
        if (root == null) return new MinMax();

        MinMax leftMinMax = largestBSTUtil(root.left);
        MinMax rightMinMax = largestBSTUtil(root.right);

        MinMax m = new MinMax();

        if (!leftMinMax.isBST || !rightMinMax.isBST || (leftMinMax.max > root.data || rightMinMax.min <= root.data)) {
            m.isBST = false;
            m.size = Math.max(leftMinMax.size, rightMinMax.size);
            return m;
        }

        m.isBST = true;
        m.size = leftMinMax.size + rightMinMax.size + 1;
        m.min = root.left != null ? leftMinMax.min : root.data;
        m.max = root.right != null ? rightMinMax.max : root.data;
        return m;
    }

    private static TNode nthLargestElement(TNode root, int iteration, int n) {
        if (root == null || iteration == n) return root;

        TNode result = nthLargestElement(root.right, iteration + 1, n);
        if (result == null) result = root;
        result = nthLargestElement(root.left, iteration + 1, n);
        return root;
    }

    private static TNode treeFromSortedArray(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;
        TNode root = new TNode(arr[mid]);

        root.left = treeFromSortedArray(arr, start, mid - 1);
        root.right = treeFromSortedArray(arr, mid + 1, end);
        return root;
    }

    private static void printLeft(TNode root) {
        if (root == null) return;
        System.out.println(root.data);
        printLeft(root.left);
    }

    private static void printRight(TNode root) {
        if (root == null) return;
        System.out.println(root.data);
        printRight(root.right);
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
