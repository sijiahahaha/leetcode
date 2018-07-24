/**
{3,9,20,#,#,15,7}

  3
 / \
9  20
  /  \
 15   7
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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        tree2String(root, sb);
        return sb.toString();
    }
    private void tree2String(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            sb.append(" ");
        } else {
            sb.append(root.val);
            sb.append(" ");
            tree2String(root.left, sb);
            tree2String(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(" ")));
        TreeNode root = string2Tree(queue);
        return root;
    }
    private TreeNode string2Tree(Queue<String> queue) {
        String root = queue.remove();
        if (root.equals("#")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(root));
            node.left = string2Tree(queue);
            node.right = string2Tree(queue);
            return node;
        }
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));