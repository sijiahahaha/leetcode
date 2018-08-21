/**
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3



A走完接着走B， B走完接着走A
若有intersection，则一定有一时间走到同一位置
**/

//A走完接着走B， B走完接着走A
//若有intersection，则一定有一时间走到同一位置
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        
        return a;
        
    }
}








//两条链表连起来，则一定有环，找到环的入口
//但是会改变原本链表的结构

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
         if (headA == null || headB == null) {
            return null;
        }
        ListNode head = headA;
        while(head.next != null) {
            head = head.next;
        }
        head.next = headB;
        
        ListNode slow = headA;
        ListNode fast = headA.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = headA;
        slow = slow.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
        
    }
}