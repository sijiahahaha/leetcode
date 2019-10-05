subtree_with_maximum_average.java
class ResultType {
    int count;
    int sum;
    public ResultType(int count, int sum) {
        this.count = count;
        this.sum = sum;
    }
}

class Solution {
    private TreeNode maxRoot = null;
    private double maxAverage = Double.MIN_VALUE;
    public TreeNode find(TreeNode root) {
        helper(root);
        return maxRoot;
    }

    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType curr = new ResultType(
                left.count + right.count + 1,
                left.sum + right.sum + root.val
        );
        if (max == null || maxAverage * curr.count < curr.sum) {
            maxRoot = root;
            maxAverage = curr.count * 1.0 / curr.sum;
        }
        return curr;

    }

}