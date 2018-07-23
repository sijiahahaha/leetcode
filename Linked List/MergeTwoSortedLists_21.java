/**
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
         ListNode dummy = new ListNode(0);
        ListNode newNode = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newNode.next = l1;
                l1 = l1.next;
            } else {
                newNode.next = l2;
                l2 = l2.next;
            }
            newNode = newNode.next;
        }
        
        if (l1 != null) {
            newNode.next = l1;
        }
        
        if (l2 != null) {
            newNode.next = l2;
        }
      
        return dummy.next;
    }
}