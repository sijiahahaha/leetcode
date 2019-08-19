/*
find nth from end:
    curr = dummy, curr go nth;
    pre = dummy; while (curr.next != null) pre++, curr++

    D   1   2   3   4   5   6   null
    pre             curr
            pre             curr

*/




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        for (int i = 0; i < n; i++) {
            if (curr.next == null) return head;
            curr = curr.next;
        }
        ListNode pre = dummy;
        while (curr.next != null) {
            curr = curr.next;
            pre = pre.next;
        }
        ListNode temp = pre.next;
        pre.next = pre.next.next;
        temp.next = null;
        
        return dummy.next;
    }
}