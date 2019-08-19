/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while (pre.next != null) {
            if (pre.next.val == val) {
                ListNode temp = pre.next;
                pre.next = pre.next.next;
                temp.next = null;
            }
            else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}