Delete_Node_in_a_BST.java
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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) root.left = deleteNode(root.left, key);
        else if (root.val < key) root.right = deleteNode(root.right, key);
        else {
            if (root.left == null || root.right == null) root = root.left == null ? root.right : root.left;
            else {
                TreeNode curr = root.right;
                while (curr.left != null) curr = curr.left;
                root.val = curr.val;
                root.right = deleteNode(root.right, curr.val);
            }
            
        }
        return root;
    }
}