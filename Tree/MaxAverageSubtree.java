/**
Given a binary tree, find the subtree with maximum average. Return the root of the subtree.


**/

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

class resultType {
    int sum;
    int size;
    
    public resultType(int sum, int size) {
        this.sum = sum;
        this.size = size;
    }
}

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    
    public resultType maxResult = null;
    public TreeNode maxRoot = null;
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return maxRoot;
    }
    
    private resultType helper(TreeNode root) {
        if (root == null) {
            return new resultType(0, 0);
        }
        resultType left = helper(root.left);
        resultType right = helper(root.right);
        resultType result = new resultType(left.sum + right.sum + root.val, left.size + right.size + 1);
        
        if (maxRoot == null || maxResult.sum * result.size < result.sum * maxResult.size) {
            maxResult = result;
            maxRoot = root;
        }
        
        return result;
    }
}