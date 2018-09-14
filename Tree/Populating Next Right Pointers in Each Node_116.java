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

用levelStart， nextLevelStart， nextLevelNode来做
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
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode curr = levelStart;
            TreeLinkNode nextLevelStart = null;
            TreeLinkNode nextLevelNode = null;
            while (curr != null) {
                if (curr.left != null) {
                    if (nextLevelStart == null) {
                        nextLevelStart = curr.left;
                        nextLevelNode = nextLevelStart;
                    } else {
                        nextLevelNode.next = curr.left;
                        nextLevelNode = nextLevelNode.next;
                    }
                }

                if (curr.right != null) {
                    if (nextLevelStart == null) {
                        nextLevelStart = curr.right;
                        nextLevelNode = nextLevelStart;
                    } else {
                        nextLevelNode.next = curr.right;
                        nextLevelNode = nextLevelNode.next;
                    }
                }
                curr = curr.next;
            }
            levelStart = nextLevelStart;
        }
        
        
    
    }
}