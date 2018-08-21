/**
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6

用PriorityQueue,把k个list的head进队，每次出最小的，进下一个
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0 ) {
            return null;
        }
        
        Queue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
            }
        });
        
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                queue.offer(lists[i]);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        while (!queue.isEmpty()) {
            ListNode newNode = queue.poll();
            newHead.next = newNode;
            newHead = newHead.next;
            
            if (newNode.next != null) {
                queue.offer(newNode.next);
            }
        }
        return dummy.next;
    }
}