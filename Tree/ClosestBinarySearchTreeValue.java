 /**
Input: root = [4,2,5,1,3], target = 3.714286

    4
   / \
  2   5
 / \
1   3

Output: 4

BST: 大了往左，小了往右，记录minDiff
O(h)
**/
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
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return root.val;
        }
        int closetNum = root.val;
        double closetDiff = Math.abs(root.val - target);
        
        while (root != null) {
            if (root.val == target) {
                return root.val;
            } else if (root.val > target) {
                if (root.val - target < closetDiff) {
                    closetDiff = root.val - target;
                    closetNum = root.val;
                }
                root = root.left;
            } else {
                if (target - root.val < closetDiff) {
                    closetDiff = target - root.val;
                    closetNum = root.val;
                }
                root = root.right;
            }
        }
        return closetNum;
    }
}
