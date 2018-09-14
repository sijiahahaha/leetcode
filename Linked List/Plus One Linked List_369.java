/**
用stack，push进去，第一个pop出来的加1，然后一个个pop，更新carry
**//**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return head;
        }
        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        
        int sum = 0;
        sum += stack.pop() + 1;
        int digit = sum % 10;
        int carry = sum / 10;
        ListNode dummy = new ListNode(0);
        dummy.next = new ListNode(digit);
        while (!stack.isEmpty()) {
            carry += stack.pop();
            ListNode newNode = new ListNode(carry % 10);
            newNode.next = dummy.next;
            dummy.next = newNode;
            carry /= 10;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        return dummy.next;
        
    }
}