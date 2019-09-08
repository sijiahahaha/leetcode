flatten_binary_tree_to_linked_list.java
class Solution {
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode mostRight = curr.left;
                while (mostRight.right != null) mostRight = mostRight.right;
                mostRight.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}