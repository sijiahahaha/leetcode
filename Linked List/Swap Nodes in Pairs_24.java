/**
Given 1->2->3->4, you should return the list as 2->1->4->3.
两个为一对，swap

... currHead -> n1 -> n2 -> null
while (currHead.next != null && currHead.next.next != null )
    swap n1 & n2
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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currHead = dummy;
        // ... currHead -> n1 -> n2 -> null
        //while (currHead.next != null && currHead.next.next != null )
        while (currHead.next != null && currHead.next.next != null) {
            ListNode n1 = currHead.next;
            ListNode n2 = currHead.next.next;
            currHead.next = n2;
            n1.next = n2.next;
            n2.next = n1;
            
            currHead = n1;
        }
        return dummy.next;
    }
}