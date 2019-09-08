most_frequent_subtree_sum.java
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
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        dfs(root);
        List<Integer> temp = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == count) temp.add(key);
        }

        int[] res = new int[temp.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = temp.get(i);
        }
        return res;
    }
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = root.val + left + right;
        if (!map.containsKey(sum)) map.put(sum, 0);
        map.put(sum, map.get(sum) + 1);
        count = Math.max(count, map.get(sum));
        return sum;
    }
}