/**
        1
   2         3
4     5   6     7


preorder: 1    2 4 5   3 6 7        inorder:  4 2 5   1    6 3 7
         root  left    right                  left   root  right

         用pre确定root.val               用in定位root来确定left长度
         然后递归build left和right
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int inRootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                inRootIndex = i;
            }
        }
        int leftLen = inRootIndex - inStart;
        
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preorder, preStart + 1, preStart + leftLen, inorder, inStart, inRootIndex - 1);
        root.right = helper(preorder, preStart + leftLen + 1, preEnd, inorder, inRootIndex + 1, inEnd);
        return root;
    }
    
         
}