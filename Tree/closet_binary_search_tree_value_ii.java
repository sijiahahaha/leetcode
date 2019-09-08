closet_binary_search_tree_value_ii.java
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

public class Solution {
    /**
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    private class Pair{
        int val;
        double diff;
        Pair(int val, double diff) {
            this.val = val;
            this.diff = diff;
        }
    }
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        if (root == null) throw new IllegalArgumentException("Invalid input");
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if (b.diff > a.diff) return 1;
                if (a.diff > b.diff) return -1;
                return 0;
            }
        });

        inorder(root, target, k, pq);

        List<Integer> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            res.add(pq.poll().val);
        }
        return res;
    }
    private void inorder(TreeNode root, double target, int k, PriorityQueue<Pair> pq) {
        if (root == null) return;
        inorder(root.left, target, k, pq);
        pq.offer(new Pair(root.val, Math.abs(root.val - target)));
        if (pq.size() > k) pq.poll();
        inorder(root.right, target, k, pq);

    }
}