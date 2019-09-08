find_mode_in_binary_search_tree.java
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
    private int count = 1;
    private int maxLen = 0;
    TreeNode pre = null;
    public int[] findMode(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return convert(res);
        inorder(root, res);
        return convert(res);
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        if (pre != null) {
            count = root.val == pre.val ? count + 1 : 1;
        }
        if (count >= maxLen) {
            if (count > maxLen) {
                res.clear();
            }
            res.add(root.val);
            maxLen = count;
        }
        pre = root;
        inorder(root.right, res);
    }

    private int[] convert(List<Integer> list) {
        if (list == null) return new int[0];
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}






