class Solution {
    public ListNode oddEvenList(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode odd = head;
    	ListNode even = head.next;
    	while (even != null && even.next != null) {
    		ListNode temp = odd.next;
    		odd.next = even.next;
    		even.next = even.next.next;
    		odd.next.next = temp;
    		odd = odd.next;
    		even = even.next;
    	}
    	return head;
    }
}