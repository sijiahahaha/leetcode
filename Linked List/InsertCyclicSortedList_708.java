/**
一个sorted的链表，头尾连了起来成为了环
给定一个值，找位置插入


三种情况画出来

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
        if (head == null) {
            Node insertNode = new Node(insertVal);
            insertNode.next = insertNode;
            return insertNode;
        }
        
         if (head.next == null) {
            Node insertNode = new Node(insertVal);
            insertNode.next = head;
            head.next = insertNode;
            return head;
        }
        
        Node pre = head;
        Node next = head.next;
        
        do {
            if (insertVal >= pre.val && insertVal <= next.val) {
                break;
            }
                
            if ((insertVal < next.val || insertVal > pre.val) && pre.val > next.val) {
                break;
            }
                
            pre = next;
            next = next.next;
        } while (next != head.next);
        
        Node insertNode = new Node(insertVal);
        pre.next = insertNode;
        insertNode.next = next;
        return head;    
    }
}