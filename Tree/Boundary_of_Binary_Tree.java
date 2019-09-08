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
     * @param root: a TreeNode
     * @return: a list of integer
     */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        if (root.left != null || root.right != null) {
            res.add(root.val);
        }
        leftBoundary(root.left, res);
        leaves(root, res);
        rightBoundary(root.right, res);
        return res;
        
    }
    
    private void leftBoundary(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) return;
        res.add(root.val);
        if (root.left != null) leftBoundary(root.left, res);
        else leftBoundary(root.right, res);
    }
    
    private void rightBoundary(TreeNode root, List<Integer> res) {
        if (root == null || (root.left == null && root.right == null)) return;
        if (root.right != null) rightBoundary(root.right, res);
        else rightBoundary(root.left, res);
        res.add(root.val);
    }
    
    private void leaves(TreeNode root, List<Integer> res) {
        if (root == null) return;
        if (root.left == null && root.right == null) res.add(root.val);
        leaves(root.left, res);
        leaves(root.right, res);
    }
}