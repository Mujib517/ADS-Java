import LinkedLists.Node;
import LinkedLists.Problems;

public class Main {
    public static void main(String[] args){
        Node head=Problems.createList(new int[]{1,2,3,4,5,6});
       Node result=Problems.middle(head);
       Problems.print(result);
    }
}
