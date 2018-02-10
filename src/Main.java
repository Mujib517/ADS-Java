import LinkedLists.Node;
import LinkedLists.Problems;
import Stacks.MinStack;
import Stacks.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Stacks.Problems.stockSpan2(new int[]{100, 80, 60, 70, 60, 75, 85}, 7);
        Stacks.Problems.stockSpan2(new int[]{10, 4, 5, 90, 120, 80}, 6);
        Stacks.Problems.stockSpan2(new int[]{0, 7, 3, 6, 6, 9, 18, 0, 16, 0}, 10);
        System.out.println();
        Stacks.Problems.stockSpan(new int[]{10, 4, 5, 90, 120, 80});
        System.out.println();
        Stacks.Problems.stockSpan(new int[]{0, 7, 3, 6, 6, 9, 18, 0, 16, 0});

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