import LinkedLists.Node;
import LinkedLists.Problems;

public class Main {
    public static void main(String[] args){
        Node head=Problems.createList(new int[]{1,2,3,4,5});
       Node result=Problems.reverseRecursive(head,null);
       Problems.print(result);
    }
}
