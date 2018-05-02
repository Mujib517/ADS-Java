import LinkedLists.Node;
import LinkedLists.Problems;
import Stacks.MinStack;
import Stacks.Stack;
import Trees.TNode;
import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 1, 3, 6, 5, 7};

        TNode root1 = new TNode(10);
        root1.left = new TNode(5);
        root1.right = new TNode(7);


        TNode root = Trees.Problems.buildTree(arr, arr.length);
        System.out.println(Trees.Problems.isBST(root1, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(Trees.Problems.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }
}


//    public static void main(String[] args) throws IOException {
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        int testCases=Integer.parseInt(reader.readLine());
//        while(testCases>0){
//            testCases--;
//            int n=Integer.parseInt(reader.readLine());
//            System.out.println(factorial(n));
//        }
//    }