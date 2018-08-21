 /**
Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.


当前层 sum = pre*10 + root.val

递归
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
    public int sumNumbers(TreeNode root) {
        int sum = helper(root, 0);
        return sum;
    }
    
    private int helper(TreeNode root, int pre) {
        if (root == null) {
            return 0;
        }
        int sum = pre * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            sum = helper(root.left, sum) + helper(root.right, sum);
        }
        return sum;
    }
}