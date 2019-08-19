/*
把小于x的都取出来形成新链表，剩下的链表接在新链表后面
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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newDummy = new ListNode(0);
        ListNode newPre = newDummy;
        ListNode oldDummy = new ListNode(0);
        oldDummy.next = head;
        ListNode pre = oldDummy;
        while (pre.next != null) {
            if (pre.next.val < x) {
                ListNode temp = pre.next;
                pre.next = pre.next.next;
                temp.next = null;
                
                newPre.next = temp;
                newPre = newPre.next;  
            } else {
                pre = pre.next;
            }
        }
        
        newPre.next = oldDummy.next;
        return newDummy.next;
    }
}