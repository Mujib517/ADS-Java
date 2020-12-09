package leetcode;

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LL {
    /*
        https://leetcode.com/problems/add-two-numbers/
        edge case: l1=[9,9,9,9,9,9,9], l2 = [9,9,9,9]
        result: [8,9,9,9,0,0,0,1]
     */
    public static ListNode addTwoLists(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = new ListNode(0);
        ListNode tempRes = head;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        while (temp1 != null && temp2 != null) {
            int sum = temp1.val + temp2.val;
            sum += carry;

            tempRes.next = new ListNode(sum % 10);
            carry = sum / 10;
            temp1 = temp1.next;
            temp2 = temp2.next;
            tempRes = tempRes.next;
        }

        while (temp1 != null) {
            int sum = temp1.val + carry;
            tempRes.next = new ListNode(sum % 10);
            carry = sum / 10;
            tempRes = tempRes.next;
            temp1 = temp1.next;
        }

        while (temp2 != null) {
            int sum = temp2.val + carry;
            tempRes.next = new ListNode(sum % 10);
            carry = sum / 10;
            tempRes = tempRes.next;
            temp2 = temp2.next;
        }
        if (carry > 0) tempRes.next = new ListNode(carry);

        return head.next;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode tempResult = result;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                tempResult.next = new ListNode(temp1.val);
                temp1 = temp1.next;
            } else {
                tempResult.next = new ListNode(temp2.val);
                temp2 = temp2.next;
            }
            tempResult = tempResult.next;
        }

        while (temp1 != null) {
            tempResult.next = new ListNode(temp1.val);
            temp1 = temp1.next;
            tempResult = tempResult.next;
        }

        while (temp2 != null) {
            tempResult.next = new ListNode(temp2.val);
            temp2 = temp2.next;
            tempResult = tempResult.next;
        }

        return result.next;
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode temp = head;
        ListNode result = new ListNode(0);

        while (temp != null && temp.next != null) {
            ListNode l1 = temp;
            ListNode l2 = temp.next;
            l1.next = l2.next;
            l2.next = l1;

            temp = l1.next;
        }

        return result.next;
    }
}
