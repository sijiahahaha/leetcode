/**
level order traverse的变形。 一层正向输出，下一层反向输出

用一个boolean记录是否要reverse，要的话就Collections.reverse(level);

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(root == null){
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean reverse = false;
        while(!queue.isEmpty()){
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode head = queue.poll();
                level.add(head.val);

                if(head.left != null){
                    queue.offer(head.left);
                }
                if(head.right != null){
                    queue.offer(head.right);
                }
            }
            
            if (reverse) {
                Collections.reverse(level);
                result.add(level);
                reverse = false;
            } else {
                result.add(level);
                reverse = true;
            }
            
        }
        
        return result;
    }
}