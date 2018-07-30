 /**
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1



找到left～right内最大值为root
root.left在[left，maxIndex-1]内递归， root.right在[maxIndex+1， right]内递归
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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(nums, 0, nums.length - 1);
    }
    private TreeNode helper(int[] nums, int left, int right) {
        while (left <= right) {
            int maxIndex = findMaxIndex(nums, left, right);
            TreeNode root = new TreeNode(nums[maxIndex]);
            root.left = helper(nums, left, maxIndex - 1);
            root.right = helper(nums, maxIndex + 1, right);
            return root;
        }
        return null;
    }
    private int findMaxIndex(int[] nums, int left, int right) {
        int maxIndex = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}