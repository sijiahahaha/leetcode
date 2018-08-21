/**
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1 -> 4->3 -> 5

For k = 3, you should return: 3->2->1 -> 4->5

reverse 以k为单位长度的链表
 currHead -> n1 -> n2 ... -> nk -> nk+
 currHead ->   | n1 <- n2 ... <- nk |   -> nk+
            pre  curr  temp
                 pre   curr  temp
**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currHead = dummy;
        
        // currHead -> n1 -> n2 ... -> nk -> nk+
        while (true) {
            currHead = helper(currHead, k);
            if (currHead == null) {
                break;
            }
        }
        return dummy.next;
    }
    
    private ListNode helper(ListNode currHead, int k) {
        ListNode n1 = currHead.next;
        ListNode nk = currHead;
        for (int i = 0; i < k; i++) {
            if (nk.next == null) {
                return null;
            }
            nk = nk.next;
        }
        ListNode nkp = nk.next;
        
        //swap
        // currHead -> n1 -> n2 ... -> nk -> nk+
        // currHead ->   | n1 <- n2 ... <- nk |   -> nk+
        //            pre  curr  temp
        //                 pre   curr  temp
        ListNode pre = null;
        ListNode curr = n1;
        while (curr != nkp) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }
        currHead.next = nk;
        n1.next = nkp;
        return n1;
    }
}