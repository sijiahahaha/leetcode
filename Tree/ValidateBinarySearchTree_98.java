/**
不是的情况：
    left不是 || right不是
    有left且 left.minVal >= root.val
    有right且 right.maxVal <= root.val
其他为是

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
    private class ResultType{
        boolean isBST;
        int maxValue, minValue;
        ResultType(boolean isBST, int maxValue, int minValue){
            this.isBST = isBST;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }
    
    
    public boolean isValidBST(TreeNode root) {
        ResultType result = helper(root);
        return result.isBST;             
        
    }
    
    
    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }    
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        if(!left.isBST || !right.isBST){
            return new ResultType(false, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        if( (root.left != null && left.maxValue >= root.val) || (root.right != null && right.minValue <= root.val) ){
            return new ResultType(false, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        return new ResultType(true, Math.max(root.val, right.maxValue), Math.min(root.val, left.minValue));
        
    }
}