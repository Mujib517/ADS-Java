import LinkedLists.Node;
import LinkedLists.Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        Node head = Problems.createList(new int[]{1, 2, 3, 4, 5});

        Node result = Problems.arrange(head);
        Problems.print(result);
        //        int max= (int)1e6+1;
//        long[] arr=new long[max];
//        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
//        int testCases=Integer.parseInt(reader.readLine());
//        while(testCases>0){
//            testCases--;
//            int n=Integer.parseInt(reader.readLine());
//            System.out.println(factorial(n,arr));
//        }
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