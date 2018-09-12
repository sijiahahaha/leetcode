/**
BFS 最后一层的第一个是答案 ----> 从右往左BFS， 最后的一个就是最后一行第一个

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
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Tree can't be null!");
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode curr = new TreeNode(0);
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr.right != null) {
                queue.offer(curr.right);
            }
            if (curr.left != null) {
                queue.offer(curr.left);
            }
        }
        return curr.val;
    }
}