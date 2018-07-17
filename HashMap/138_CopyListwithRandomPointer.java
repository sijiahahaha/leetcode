/**  
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
Return a deep copy of the list.
复制一个带有random指针的链表

1. HashMap， O(n) memory, O(2n) time
  1.遍历list的next关系，复制一个新的链表，将对应关系存入HashMap
  2.重新遍历list，复制random关系

2. 不用HashMap，O(1) memory, O(3n) time 
  1.遍历list， 复制每个node到next
  2.重新遍历list，复制random关系
  3.拆开两个list

**/


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */



//HashMap O(n) space, O(2n) time
//  1.遍历list的next关系，复制一个新的链表，将对应关系存入HashMap
//  2.重新遍历list，复制random关系
import java.util.HashMap;
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newHead = new RandomListNode(head.label);
        map.put(head, newHead);
        RandomListNode oldNext = head.next;
        
        while (oldNext != null) {
            RandomListNode newNext = new RandomListNode(oldNext.label);
            map.put(oldNext, newNext);
            newHead.next = newNext;
            
            oldNext = oldNext.next;
            newHead = newHead.next;
        }
        
        RandomListNode oldHead = head;
        newHead = map.get(head);
        while (oldHead!= null) {
            newHead.random = map.get(oldHead.random);
            oldHead = oldHead.next;
            newHead = newHead.next;
        }
        
        return map.get(head);
    }
}



//不用HashMap， O(1) space, O(3n) time
//  1.遍历list， 复制每个node到next
//  2.重新遍历list，复制random关系
//  3.拆开两个list
import java.util.List;
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        RandomListNode oldNode = head;
        while (oldNode != null) {
            RandomListNode newNode = new RandomListNode(oldNode.label);
            newNode.next = oldNode.next;
            oldNode.next = newNode;
            
            oldNode = newNode.next;
        }
        
        oldNode = head;
        
        while (oldNode != null) {
            if (oldNode.random != null) {
                oldNode.next.random = oldNode.random.next;                            
            }
            oldNode = oldNode.next.next;
        }
        
        RandomListNode newHead = head.next;
        oldNode = head;
        while (oldNode != null) {
            RandomListNode newNode = oldNode.next;
            oldNode.next = newNode.next;
            if (newNode.next != null) {
                newNode.next = oldNode.next.next;
            }
            oldNode = oldNode.next;            
        }
        
        return newHead;
    }
}
