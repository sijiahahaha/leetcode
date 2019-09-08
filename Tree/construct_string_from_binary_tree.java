construct_string_from_binary_tree.java
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
    public String tree2str(TreeNode t) {
        String result = "";
        result = helper(t);
        return result.substring(1, result.length() - 1);
    }
    private String helper(TreeNode t) {
        if (t == null) return "()";
        if (t.left == null && t.right == null) return "(" + t.val + ")";
        String left = helper(t.left);
        String right = helper(t.right);

        if (right == "()") return "(" + t.val + left + ")";
        else return "(" + t.val + left + right + ")";
    }
}