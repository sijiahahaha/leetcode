closest_leaf_in_a_binary_tree.java
public class Solution {
    /**
     * @param root: the root
     * @param k: an integer
     * @return: the value of the nearest leaf node to target k in the tree
     */
    Map<Integer, Integer> map = new HashMap<>();
    int leafVal = -1;
    int minLen = Integer.MAX_VALUE;
    public int findClosestLeaf(TreeNode root, int k) {
        // Write your code here
        if (root == null) return -1;
        map.put(k, 0);
        mapRootToK(root, k);
        find(root, -1);
        return leafVal;
    }
    private int mapRootToK(TreeNode root, int k) {
        if (root == null) return -1;
        if (root.val == k) return 1;
        int left = mapRootToK(root.left, k);
        if (left != -1) {
            map.put(root.val, left);
            return left + 1;
        }
        int right = mapRootToK(root.right, k);
        if (right != -1) {
            map.put(root.val, right);
            return right + 1;
        }
        return -1;
    }

    private void find(TreeNode root, int currLen) {
        if (root == null) return;
        if (map.containsKey(root.val)) currLen = map.get(root.val);
        if (root.left == null && root.right == null) {
            if (currLen < minLen) {
                minLen = currLen;
                leafVal = root.val;
            }
        }
        
        find(root.left, currLen + 1);
        find(root.right, currLen + 1);
    }

}

