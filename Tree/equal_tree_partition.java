equal_tree_partition.java

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
     * @return: return a boolean
     */
    public boolean checkEqualTree(TreeNode root) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        int sum = helper(root, map);
        if (sum == 0) return map.get(0) > 1;
        return sum % 2 == 0 && map.containsKey(sum / 2);
    }
    private int helper(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) return 0;
        int currSum = helper(root.left, map) + helper(root.right, map) + root.val;
        if (!map.containsKey(currSum)) map.put(currSum, 0);
        map.put(currSum, map.get(currSum) + 1);
        return currSum;
    }
}