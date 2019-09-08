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
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null) return res;
        helper(root);
        return res;
    } 
    private String helper(TreeNode root) {
        if (root == null) return "#";
        String str = root.val + "," + helper(root.left) + "," + helper(root.right);
        if (map.containsKey(str) && map.get(str) == 1) {
            res.add(root);
            map.put(str, map.get(str) + 1);
        }
        if (!map.containsKey(str)) map.put(str, 1);
        return str;
    }
}