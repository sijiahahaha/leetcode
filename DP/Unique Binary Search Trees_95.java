/**
1. 延续之前DP思想，
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


root: 1                           2                         3
left: 由(1-1)个node构成BST f(0)    由(2-1)个node构成BST f(1)   由(3-1)个node构成BST f(2)
right 由(n-1)个node构成BST f(2)    由(n-2)个node构成BST f(1)   由(n-3)个node构成BST f(0)

count = (left) * (right)
f(3) = f(0) * f(2) + f(1)*f(1) + f(2)*f(0)
f(n) = f(0) * f(n-1) + f(1)*f(n-2) + ... + f(n-1)*f(0)

TreeNode List list[n+1]
list[0] = new ArrayList<TreeNode>(null);
每次循环，添加list[i]



2. DFS
遍历index，分别以index为root，构建左右子树
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
//1
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] list = new List[n + 1];
        list[0] = new ArrayList<>();
        if (n == 0) {
            return list[0];
        }
        list[0].add(null);
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                //f[i] += f[j] * f[i - j - 1];
                for (TreeNode left : list[j]) {
                    for (TreeNode right : list[i - j - 1]) {
                        TreeNode root = new TreeNode(j + 1);
                        root.left = left;
                        root.right = clone(right, j + 1);
                        list[i].add(root);
                    }
                }
            }
        }
        return list[n];
    }
    private TreeNode clone(TreeNode root, int k) {
        if (root == null) {
            return root;
        }
        TreeNode newRoot = new TreeNode(root.val + k);
        newRoot.left = clone(root.left, k);
        newRoot.right = clone(root.right, k);
        return newRoot;
    }
}

//2
class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> list = new ArrayList<>();
        if (n == 0) {
            return list;
        }
        return dfs(1, n);
    }
    private List<TreeNode> dfs(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftList = dfs(start, i - 1);
            List<TreeNode> rightList = dfs(i + 1, end);
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    list.add(root);
                }
            }
        }
        return list;
    }
}