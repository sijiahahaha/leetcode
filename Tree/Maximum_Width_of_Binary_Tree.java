/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Pair {
    TreeNode root;
    int index;
    
    Pair(TreeNode root, int index) {
        this.root = root;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 1));
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size == 1) {
                queue.peek().index = 1;
            }
            int left = queue.peek().index;
            int right = left;
            for (int i = 0; i < size; i++) {
                right = queue.peek().index;
                TreeNode curr = queue.poll().root;
                if (curr.left != null) queue.offer(new Pair(curr.left, right * 2));
                if (curr.right != null) queue.offer(new Pair(curr.right, right * 2 + 1));
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}