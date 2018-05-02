package Trees;

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
