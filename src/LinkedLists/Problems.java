package LinkedLists;

public class Problems {

    public static boolean floydCycleDetection(Node head){
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

        slow=head;

        while(slow!=null & fast!=null){
            slow=slow.next;
            fast=fast.next;
            if(slow.equals(fast)) return slow;
        }
        return null;
    }

    public static int detectCycleLength(Node head){
        Node slow=head,fast=head;
        while(slow!=null && fast.next!=null){

            slow=slow.next;
            fast=fast.next.next;

            if(slow.equals(fast)) break;
        }

        int count=0;

        while(fast!=null){
            fast=fast.next;
            count++;
            if(slow.equals(fast)) break;
        }
        return count;
    }

    public static Node insertInSortedList(Node head,int data){
        Node n=new Node(data);
        if(head==null) return head=n;
        Node temp=head;
        Node prev=null;


        while(head!=null){
            if(head.data<data) {
                prev=head;
                head=head.next;
            }
            else{
                if(prev==null){
                    prev=n;
                    n.next=head;
                    head=prev;
                    return head;
                }
                else{
                    n.next=head;
                    prev.next=n;
                    return temp;
                }
            }
        }
        prev.next=n;
        return temp;
    }

    public static Node reverseIterative(Node head){
        Node pre=null;
        while(head!=null){
            Node next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }

        return pre;
    }

    public static Node reverseRecursive(Node head,Node prev){
        if(head==null) return prev;

        Node next=head.next;  //2 3 4 5
        head.next=prev;  //  5->4->3-> 2->1->null
        prev=head;//5
        return reverseRecursive(next,prev);
    }

    public static Node middle(Node head){
        Node slow=head,fast=head;
        Node prev=null;
        while(slow!=null && fast!=null&& fast.next!=null){
            slow=slow.next;
            prev=slow;
            fast=fast.next.next;// 1 2 3 4 5 6
        }
        //even return prev else return middle element.
        //if fast pointer reaches null its even length else odd length
        return fast==null?prev:slow;
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
        Node n6=new Node(6);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n3;

        return n1;
    }

    public static void print(Node head){
        while(head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
}
