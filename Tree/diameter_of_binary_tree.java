diameter_of_binary_tree.java
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
    private class ResultType {
        int singlePath, maxPath;
        public ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        ResultType res = dfs(root);
        return res.maxPath - 1;
    }
    private ResultType dfs(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }

        ResultType left = dfs(root.left);
        ResultType right = dfs(root.right);

        ResultType curr = new ResultType(0, 0);
        curr.singlePath = Math.max(left.singlePath, right.singlePath) + 1;
        curr.maxPath = Math.max(left.singlePath + right.singlePath + 1, Math.max(left.maxPath, right.maxPath));
        return curr;
    }
}
