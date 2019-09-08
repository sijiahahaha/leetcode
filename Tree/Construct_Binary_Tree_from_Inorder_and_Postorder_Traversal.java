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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) return null;
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return null;
        int rootVal = postorder[postEnd];
        int inRootIndex = inStart;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                inRootIndex = i;
                break;
            }
        }
        int leftLen = inRootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(inorder, inStart, inStart + leftLen - 1, postorder, postStart, postStart + leftLen - 1);
        root.right = helper(inorder, inStart + leftLen + 1, inEnd, postorder, postStart + leftLen, postEnd - 1);
        return root;
    }
}