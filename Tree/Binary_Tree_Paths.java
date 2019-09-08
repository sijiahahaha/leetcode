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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        List<Integer> currPath = new ArrayList<>();
        helper(root, currPath, res);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> currPath, List<String> res) {
        if (root == null) return;
        currPath.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(format(currPath));
            currPath.remove(currPath.size() - 1);
            return;
        }
        helper(root.left, currPath, res);
        helper(root.right, currPath, res);
        currPath.remove(currPath.size() - 1);
        return;
    }
    
    private String format(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            sb.append("->" + list.get(i));
        }
        return sb.toString();
    }
}