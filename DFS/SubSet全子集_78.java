/**  
Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

DFS
**/

public class Solution {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        Arrays.sort(nums);
        ArrayList<Integer> curr = new ArrayList<>();
        helper(nums, curr, 0, result);
        return result;
    }
    
    private void helper(int[] nums, ArrayList<Integer> curr, int index, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(curr));
        for (int i = index; i < nums.length; i++) {
            curr.add(nums[i]);
            helper(nums, curr, i+1, result);
            curr.remove(curr.size() - 1);
        }
    }
}