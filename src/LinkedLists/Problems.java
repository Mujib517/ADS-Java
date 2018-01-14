package LinkedLists;

public class Problems {

    public static boolean FloydCycleDetection(Node head){
        Node slow=head,fast=head;

        while(slow!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow.equals(fast)) return true;
        }
        return false;
    }

    public static Node detectCycleStartNode(Node head){
        Node slow=head,fast=head;

        while(slow!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow.equals(fast)) break;
        }

        while(slow!=null & fast!=null){
            slow=slow.next;
            fast=fast.next;
            if(slow.equals(fast)) return slow;
        }
        return null;
    }

    public static Node createList(int arr[]){
        if(arr.length==0) return null;
        Node head=new Node(arr[0]);
        Node temp=head;
        for(int i=1;i<arr.length;i++){
            temp.next=new Node(arr[i]);
            temp=temp.next;
        }
        return head;
    }

    public static Node createCycledList(){
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n3;

        return n1;
    }
}
