/**
Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// reverse 全部链表
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        if (head == null) {
            return pre;
        }
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }        
        
        return pre;
    }
}

// reverse中间一部分 m, n
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {      
        if (head == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        //find m-1 th Node
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        
        ListNode left = head;
        ListNode mNode = head.next;
        ListNode curr = mNode;
        ListNode post  = curr.next;
        
        for (int i = m; i < n; i++) {
            if (post == null) {
                return null;
            }           
            ListNode temp = post.next;
            post.next = curr;
            curr = post;
            post = temp;
        }
        
        left.next = curr;
        mNode.next = post;
        
        return dummy.next;
    }
}

// reverse后半部分 m=middle+1，n=end

class Solution {
    public ListNode reverseHalf(ListNode head) {      
        if (head == null || head.next == null) {
            return head;
        }
        //find middle Node
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast.next != null || fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //reverse secone half
        ListNode pre = slow.next;
        ListNode cur = pre.next;
        while (cur != null) {
        pre.next = cur.next;
        cur.next = slow.next;
        slow.next = cur;
        cur = pre.next;
    }
        return head;
    }
}

