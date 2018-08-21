/**
Input: "4(2(3)(1))(6(5))"
Output: return the tree root node representing the following tree:

       4
     /   \
    2     6
   / \   / 
  3   1 5   



递归，找到第一个完整的（） -->   root(left)(right)
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
    public TreeNode str2tree(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        int i = s.indexOf('(');
        if (i < 0) {
            return new TreeNode(Integer.valueOf(s));
        }
        
        int j = i;
        int count = 0;
        while (j < s.length()) {
            if (s.charAt(j) == '(') {
                count++;
            }
            if (s.charAt(j) == ')') {
                count--;
            }
            if (count == 0) {
                break;
            }
            j++;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(s.substring(0,i)));
        root.left = str2tree(s.substring(i + 1, j));
        if (j + 2 < s.length()) {
            root.right = str2tree(s.substring(j + 2, s.length() - 1));
        }
        
        return root;
    }
}