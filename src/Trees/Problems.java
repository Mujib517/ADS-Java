package Trees;

public class Problems {

    public static void createBinaryTree(int[] arr, int n) {

        TreeNode temp = new TreeNode(arr[0], 0);
        System.out.print(temp.height + " ");

        for (int i = 1; i < n; i++) {
            while (temp != null) {
                if (arr[i] < temp.data) {
                    if (temp.left == null) {
                        temp.left = new TreeNode(arr[i], temp.height + 1);
                        System.out.print(temp.left.height + " ");
                        break;
                    }
                    temp = temp.left;
                } else {
                    if (temp.right == null) {
                        temp.right = new TreeNode(arr[i], temp.height + 1);
                        System.out.print(temp.right.height + " ");
                        break;
                    }
                    temp = temp.right;
                }
            }
        }
    }
}
