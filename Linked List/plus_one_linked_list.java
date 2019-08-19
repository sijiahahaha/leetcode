class Solution {
    public ListNode plusOne(ListNode head) {
    	if (head == null) return new ListNode(1);

    	Stack<Integer> stk = new Stack<Integer>();

    	while (head != null) {
    		stk1.push(head.val);
    		head = head.next;
    	}

    	ListNode dummy = new ListNode(0);
    	ListNode pre = dummy;
    	int carry = 1;
    	while (!stk.isEmpty()) {
    		int sum = carry;
    		if (!stk.isEmpty()) sum += stk.pop();
    		ListNode curr = new ListNode(sum % 10);
    		curr.next = dummy.next;
    		dummy.next = curr;
    		carry = sum / 10;
    	}

    	if (carry != 0) {
    		ListNode curr = new ListNode(carry % 10);
    		curr.next = dummy.next;
    		dummy.next = curr;
    	}
    	return dummy.next;

    }
}