Binary_Tree_Longest_Consecutive_Sequence_ii.java
class Solution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        int result = dfs(root, 1) + dfs(root, -1) + 1;
        return Math.max(result, Math.max(longestConsecutive(root.left), longestConsecutive(root.right)));
    }

    private int dfs(TreeNode root, int diff) {
        if (root == null) return 0;
        int left = 0, right = 0;
        if (root.left != null && root.val - root.left.val == diff) {
            left = dfs(root.left, diff) + 1;
        }
        if (root.right != null && root.val - root.right.val == diff) {
            right = dfs(root.right, diff) + 1;
        }

        return Math.max(left, right);

    }
}