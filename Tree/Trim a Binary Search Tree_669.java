/**
递归
如果root.val在范围内，就对左右递归
如果root.val小于范围，则root.left都可以不要了，对root.right递归
如果root.val大于范围，则root.right都可以不要了，对root.left递归
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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return root;
        }
        if (root.val >= L && root.val <= R) {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
        } else if (root.val < L) {
            root = trimBST(root.right, L, R);
        } else {
            root = trimBST(root.left, L, R);
        }
        return root;
    }
}