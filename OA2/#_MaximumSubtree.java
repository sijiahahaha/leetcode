/**
Given a binary tree, find the subtree with maximum sum. Return the root of the subtree.

用递归，
leftSum = helper(root.left)
rightSum = helper(root.right)
sum = root + leftSum + rightSum
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
class Solution {
    private TreeNode maxRoot = null;
    private int maxSum = Integer.MIN_VALUE;
    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return maxRoot;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = helper(root.left);
        int rightSum = helper(root.right);

        if (maxRoot == null || leftSum + rightSum + root.val > maxSum) {
            maxRoot = root;
            maxSum = leftSum + rightSum + root.val;           
        }

        return leftSum + rightSum + root.val;
    }
}