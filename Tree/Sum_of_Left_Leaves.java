/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return 0;

        return dfs(root, false);
    }
    
    private int dfs(TreeNode root, boolean isLeft) {
        int sum = 0;
        if (root == null) return sum;
        if (isLeft && root.left == null && root.right == null) return root.val;
        sum += dfs(root.left, true);
        sum += dfs(root.right, false);
        return sum;
        
    }

}