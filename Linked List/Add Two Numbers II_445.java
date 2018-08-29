/**
1. 先把链表reverse， 然后用之前的相加的算法，再把结果reverse回来
    Time Complexity: O(n). reverse O(n), add O(n).
    Space: O(1). reverse O(1), add O(1).
2. 不reverse， 用2个stack，分别push进去，再一个个pop相加
    Time Complexity: O(n). 压stack用了O(n), pop后相加用了O(n).
    Space: O(n). stack用了O(n). result list用了O(n).
**/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//1
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        return reverse(add2(l1, l2));
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
    
    
    private ListNode add2(ListNode l1, ListNode l2) {
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

//2
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        Stack<Integer> stk1 = new Stack<Integer>();
        Stack<Integer> stk2 = new Stack<Integer>();
        while(l1 != null){
            stk1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            stk2.push(l2.val);
            l2 = l2.next;
        }
        
        ListNode dummy = new ListNode(0);
        int carry = 0;
        while(!stk1.isEmpty() || !stk2.isEmpty()){
            if(!stk1.isEmpty()){
                carry += stk1.pop();
            }
            if(!stk2.isEmpty()){
                carry += stk2.pop();
            }
            ListNode cur = new ListNode(carry%10);
            cur.next = dummy.next;
            dummy.next = cur;
            carry /= 10;
        }
        if(carry != 0){
            ListNode cur = new ListNode(1);
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }
    
}