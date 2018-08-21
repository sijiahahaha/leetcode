/**
Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]


对于index = i的root， root.left的index为i-1， root.right的index为i+1
类似level order，用两个queue，一个存node，一个存index
用HashMap存每个index中包含的node
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> nodeQue = new LinkedList<>();
        Queue<Integer> indexQue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        nodeQue.offer(root);
        indexQue.offer(0);
        int minIndex = 0;
        int maxIndex = 0;
        while (!nodeQue.isEmpty()) {
            int size = nodeQue.size();
            for (int i = 0; i < size; i++) {
                TreeNode currNode = nodeQue.poll();
                int currIndex = indexQue.poll();
                if (! map.containsKey(currIndex)) {
                    ArrayList<Integer> l = new ArrayList<>();
                    map.put(currIndex, l);
                } 
                ArrayList<Integer> nums = map.get(currIndex);
                nums.add(currNode.val);
                map.put(currIndex, nums);
                
                if (currNode.left != null) {
                    nodeQue.offer(currNode.left);
                    indexQue.offer(currIndex - 1);
                    minIndex = Math.min(minIndex, currIndex - 1);
                }
                if (currNode.right != null) {
                    nodeQue.offer(currNode.right);
                    indexQue.offer(currIndex + 1);
                    maxIndex = Math.max(maxIndex, currIndex + 1);
                }
            }  
        }
        
        for (int i = minIndex; i <= maxIndex; i++) {
            ArrayList<Integer> ls = map.get(i);
            result.add(new ArrayList<Integer>(ls));
        }
        return result;
    }
}