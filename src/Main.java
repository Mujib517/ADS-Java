import LinkedLists.Node;
import LinkedLists.Problems;
import Stacks.MinStack;
import Stacks.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 20, 4, 5, 80, 10, 20, 30};
        System.out.println(recursion.Problems.findMin(arr, 0, Integer.MAX_VALUE));
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