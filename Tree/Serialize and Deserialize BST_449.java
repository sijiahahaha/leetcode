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
    //push TreeNode into queue
    //each time, poll(), generate string
    public String serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode head = queue.poll();
            if(head == null){
                sb.append("#");
            }else{
                sb.append(head.val);
                queue.offer(head.left);
                queue.offer(head.right);
            }
            sb.append(" ");         
        }
        
        //sb.deleteCharAt(sb.length()-1);
        
        return sb.toString();
               
        
    }

    // Decodes your encoded data to tree.
    // push TreeNode into queue
    // each time, root = poll(), according to data string, generate root.left, root.right, push left right into queue
    public TreeNode deserialize(String data) {
        data = data.trim();
        if(data.equals("#")){
            return null;
        }
        
        String[] val = data.split("\\s+");
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode head = new TreeNode(Integer.parseInt(val[0]));
        queue.offer(head);
        
        int index = 1;
        while(index<val.length){
            TreeNode cur = queue.poll();
            if(val[index].equals("#")){
                cur.left = null;
                index ++;
            }else{
                cur.left = new TreeNode(Integer.parseInt(val[index]));
                queue.offer(cur.left);
                index ++;
            }
            
            if(val[index].equals("#")){
                cur.right = null;
                index ++;
            }else{
                cur.right = new TreeNode(Integer.parseInt(val[index]));
                queue.offer(cur.right);
                index ++;
            }
            
        }
        
        return head;
        
        
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));