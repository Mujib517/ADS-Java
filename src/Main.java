import LinkedLists.Node;
import LinkedLists.Problems;

public class Main {
    public static void main(String[] args){
        Node head=Problems.createCycledList();
        Node result= Problems.detectCycleStartNode(head);
        System.out.println(result.data);
    }
}
