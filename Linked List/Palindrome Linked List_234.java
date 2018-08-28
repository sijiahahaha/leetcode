/**
find middle
reverse the second half
2 pointer form start and middle
check if the same
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
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);
        
        ListNode l1 = head, l2 = middle.next;
        while (l2 != null) {
            if (l1.val != l2.val) {
                return false;
            } else {
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        
        return true;
    }
    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}