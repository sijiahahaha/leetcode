maximum_binary_tree.java
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
    public TreeNode constructMaximumBinaryTree(int[] A) {
        if (A == null || A.length == 0) return null;

        return helper(A, 0, A.length - 1);
    }
    private TreeNode helper(int[] A, int start, int end) {
        if (start > end) return null;
        int rootVal = Integer.MIN_VALUE;
        int rootIndex = start;
        for (int i = start; i <= end; i++) {
            if (A[i] > rootVal) {
                rootVal = A[i];
                rootIndex = i;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(A, start, rootIndex - 1);
        root.right = helper(A, rootIndex + 1, end);
        return root;
    }
}