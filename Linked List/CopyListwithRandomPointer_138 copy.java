/**  
一个sorted的链表，头尾连了起来成为了环
给定一个值，找位置插入

**/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null) {
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        
        Node pre = head;
        Node next = head.next;
        
        while(next != null) {
            if(pre.val <= insertVal && next.val >= insertVal 
               || next.val >= insertVal && pre.val >= next.val          
               || pre.val <= insertVal && pre.val >= next.val ) {
                Node node = new Node(insertVal);
                pre.next = node;
                node.next = next;
                break;
            } 
            pre = next;
            next = next.next;
        }
                
        return head;        
    }
}