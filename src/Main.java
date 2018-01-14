import LinkedLists.Node;
import LinkedLists.Problems;

public class Main {
    public static void main(String[] args){
        Node head=Problems.createList(new int[]{1,2,3,5,6});
       Node result=Problems.InsertInSortedList(head,7);
       Problems.print(result);
    }
}
