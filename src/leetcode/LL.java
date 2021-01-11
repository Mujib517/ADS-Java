package leetcode;

import java.util.List;

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

    /*
        https://leetcode.com/problems/rotate-list/
     */
    public static ListNode rotate(ListNode head, int k) {
        int count = size(head);
        if (count == 0) return null;
        k = k % count;
        ListNode reversedList = reverse(head);
        ListNode list1 = getPartition1(reversedList, k);
        ListNode reversedList1 = reverse(list1);
        ListNode list2 = getPartition2(reversedList, k);
        ListNode reversedList2 = reverse(list2);

        return append(reversedList1, reversedList2);
    }

    private static ListNode append(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        ListNode temp = list1;
        while (temp != null && temp.next != null) {
            temp = temp.next;
        }
        temp.next = list2;

        return list1;
    }

    private static ListNode getPartition2(ListNode reversedList, int k) {
        ListNode list = new ListNode(-1);
        ListNode temp1 = list;
        ListNode temp = reversedList;
        while (k > 0) {
            temp = temp.next;
            k--;
        }
        while (temp != null) {
            temp1.next = new ListNode(temp.val);
            temp = temp.next;
            temp1 = temp1.next;
        }
        return list.next;
    }

    private static ListNode getPartition1(ListNode reversedList, int k) {
        ListNode list1 = new ListNode(-1);
        ListNode temp = reversedList;
        ListNode temp1 = list1;
        while (k > 0 && temp != null) {
            temp1.next = new ListNode(temp.val);
            temp1 = temp1.next;
            temp = temp.next;
            k--;
        }
        return list1.next;
    }

    private static int size(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            ++count;
            temp = temp.next;
        }
        return count;
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }
}
