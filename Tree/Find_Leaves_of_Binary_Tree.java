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
    /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        dfs(root, res);
        return res;
    }
    private int dfs(TreeNode root, List<List<Integer>> res) {
        if (root == null) return -1;
        int height = Math.max(dfs(root.left, res), dfs(root.right, res)) + 1;
        if (res.size() <= height) {
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        return height;
    }
}