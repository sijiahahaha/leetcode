/**
perfect bineary tree
    1
   /  \
  2    3
 / \  / \
4  5  6  7
 
 刚开始所有next指向null

    1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

用一个point指向level最左边，遍历level
**/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) {
            return;
        }
        TreeLinkNode levelStart = root;
        while (levelStart != null && levelStart.left != null) {
            TreeLinkNode curr = levelStart;
            while (curr != null) {
                curr.left.next = curr.right;
                curr.right.next = curr.next == null ? null : curr.next.left;
                
                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
    }
}

/**
普通 bineary tree
    1
   /  \
  2    3
 / \    \
4   5    7

 
 刚开始所有next指向null

    1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL

用stack， level order travers
用dummy表示level最后
**/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> que = new LinkedList<>();
        TreeLinkNode dummy = new TreeLinkNode(0);
        que.offer(root);
        que.offer(dummy);
        while (!que.isEmpty()) {
            TreeLinkNode curr = que.poll();
            if (curr == dummy) {
                if (!que.isEmpty()) {
                    que.offer(dummy);
                }
                continue;
            }
            
            if (que.peek() == dummy) {
                curr.next = null;
            } else {
                curr.next = que.peek();
            }
            
            if (curr.left != null) {
                que.offer(curr.left);
            }
            if (curr.right != null) {
                que.offer(curr.right);
            }
            
        }
    
    }
}