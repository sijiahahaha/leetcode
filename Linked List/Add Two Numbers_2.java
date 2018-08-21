/**
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode newNode = dummy;
        int carry = 0, digit = 0;
        for (ListNode i = l1, j = l2; i != null || j != null;) {
            int sum = carry;
            if (i != null) {
                sum += i.val;
            }
            if (j != null) {
                sum += j.val;
            }
            carry = sum / 10;
            digit = sum % 10;
            
            newNode.next = new ListNode(digit);
            newNode = newNode.next;
            
            if (i != null) {
                i = i.next;
            }
            if (j != null) {
                j = j.next;
            }
            
        }
        if (carry != 0) {
            newNode.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}