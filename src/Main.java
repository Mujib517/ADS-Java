import LinkedLists.Node;
import LinkedLists.Problems;
import Stacks.MinStack;
import Stacks.Stack;
import heaps.MaxHeap;
import heaps.MinHeap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {

        MaxHeap h = new MaxHeap();
        h.add(10);
        h.add(30);
        h.add(40);
        h.add(20);
        h.add(120);

        System.out.println(h.poll());
        System.out.println(h.poll());
        System.out.println(h.poll());
        System.out.println(h.poll());
        System.out.println(h.poll());


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