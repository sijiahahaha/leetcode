closet_binary_search_tree_value.java
class Solution {
    public int closetValue(TreeNode root, double target) {
        if (root == null) throw new IllegalArgumentException("Invalid input");
        int closet = root.val;
        double minDiff = Math.abs(root.val - target);

        while (root != null) {
            if (root.val == target) return root.val;
            else if (root.val > target) {
                if (root.val - target < minDiff) {
                    minDiff = root.val - target;
                    closet = root.val;
                }
                root = root.left;
            }
            else {
                if (target - root.val < minDiff) {
                    minDiff = target - root.val;
                    closet = root.val;
                }
                root = root.right;

            }
        }
        return closet;
    }
}