/**
Given a tree of N nodes, return the amplitude of the tree     
就是从root到leaf max - min的差
}
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
public static int maxDiff(TreeNode root){ 
    if(root == null) 
        return 0;
    return maxDiff(root, root.val, root.val);
}

public static int maxDiff(TreeNode root, int min, int max){ 
    if(root == null) 
        return max - min;
    min = Math.min(min, root.val);
    max = Math.max(max, root.val);
    return Math.max(maxDiff(root.left, min, max),maxDiff(root.right, min, max)); 