/**
1. 用inorder travse思想，stack pop出第k个
    O(h + k) h为高度
2. 类似quick select， 先计算好每个node孩子的个数，放入map，之后只要找到k就可以
    O(n) 当需要多次查询和更新树时， 只需更新map对应node，查询很快

**/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//1
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            throw new IllegalArgumentException("root can't be null!");
        }
        
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        int i = 0;
        TreeNode curr = stack.peek();
        while (!stack.isEmpty()) {
            i++;
            curr = stack.pop();
            if (i == k) {
                break;
            }
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
        }
        return curr.val;
    }
}
//2
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            throw new IllegalArgumentException("root can't be null!");
        }
        
        Map<TreeNode, Integer> map = new HashMap<>();
        countChildNum(root, map);
        return findK(root, k, map);
    }
    
    private int countChildNum(TreeNode root, Map<TreeNode, Integer> map) {
        if (root == null) {
            return 0;
        }
        int leftChildNum = countChildNum(root.left, map);
        int rightChildNum = countChildNum(root.right, map);
        map.put(root, leftChildNum + rightChildNum + 1);
        return leftChildNum + rightChildNum + 1;
    }
    
    private int findK(TreeNode root, int k, Map<TreeNode, Integer> map) {
        if (root == null) {
            throw new IllegalArgumentException("root can't be null!");
        }
        int leftNum = root.left == null ? 0 : map.get(root.left);
        if (leftNum + 1 == k) {
            return root.val;
        }
        if (leftNum >= k) {
            return findK(root.left, k, map);
        }
        return findK(root.right, k - leftNum - 1, map);
    }
}
