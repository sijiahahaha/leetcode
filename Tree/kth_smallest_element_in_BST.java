kth_smallest_element_in_BST.java
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            throw new IllegalArgumentException("root can't be null");
        }

        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        int count = 0;
        TreeNode curr = stack.peek();
        while (!stack.isEmpty()) {
            curr = stack.pop();
            count++;
            if (count == k) break;
            curr = curr.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return curr.val;
    }

}