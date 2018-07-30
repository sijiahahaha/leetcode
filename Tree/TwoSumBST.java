/**
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True

HashSet: O(n) time, O(n) space
  遍历root，若 target-root.val 在map里，则true
           若不在，set.add(root.val)
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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<Integer>();
        return helper(set, root, k);
    }
    private boolean helper(Set<Integer> set, TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (set.contains(k - root.val)) {
            return true;
        } else {
            set.add(root.val);
            return helper(set, root.left, k) || helper(set, root.right, k);
        }
        
    }
}