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
     * @param root: the given tree
     * @return: the number of uni-value subtrees.
     */
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return res;
        isValid(root, root.val);
        return res;
    }
    
    private boolean isValid(TreeNode root, int val) {
        if (root == null) return true;
        if (!isValid(root.left, root.val) | !isValid(root.right, root.val)) {
            return false;
        }
        res++;
        return root.val == val;
    }
}