Binary_Tree_Longest_Consecutive_Sequence.java
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 1);
    }
    private int dfs(TreeNode root, int curLen) {
        if (root == null) return curLen;

        int left = (root.left != null && root.left.val == root.val + 1) ?
                    dfs(root.left, curLen + 1) : dfs(root.left, 1);
        int right = (root.right != null && root.right.val == root.val + 1) ?
                    dfs(root.right, curLen + 1) : dfs(root.right, 1);
        return Math.max(curLen, Math.max(left, right));
    }
}