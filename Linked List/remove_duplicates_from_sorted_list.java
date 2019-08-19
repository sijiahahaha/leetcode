/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        while (pre.next != null) {
            if (pre.next.val == pre.val) {
                ListNode temp = pre.next;
                pre.next = pre.next.next;
                temp.next = null;
            } else {
                pre = pre.next;
            }
        }
        return head;
    }
}