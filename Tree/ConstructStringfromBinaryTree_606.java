/**
Input: Binary tree: [1,2,3,null,4]
       1
     /   \
    2     3
     \  
      4 

Output: "1(2()(4))(3)"
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
    public String tree2str(TreeNode t) {
        String result = new String();
        result = traverse(t);
        return result.substring(1, result.length() - 1);
    }
    
     private String traverse(TreeNode t) {
        if (t == null) {
            return "()";
        }
        
        if (t.left == null && t.right == null) {
            return "(" + t.val + ")";
        }
        
        String left = traverse(t.left);
        String right = traverse(t.right);
        
        if (right == "()") {
            return "(" + t.val + left + ")";
        } else {
            return "(" + t.val + left + right + ")";
        }
        
    }
}