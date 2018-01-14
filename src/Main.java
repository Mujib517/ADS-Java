import LinkedLists.Node;
import LinkedLists.Problems;

public class Main {
    public static void main(String[] args){
        Node head=Problems.createCycledList();
        System.out.println(Problems.detectCycleLength(head));
    }
}
