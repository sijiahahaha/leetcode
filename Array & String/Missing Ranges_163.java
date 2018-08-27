/** 
Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]

分段补充：
  lower --> nums[0] - 1
  nums[0] + 1 --> nums[1] - 1 
  .....
  nums[n - 1] + 1  --> nums[n] - 1
  nums[n] + 1  --> upper
**/


class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList();
        if (nums == null || nums.length == 0) {
            addRange(result, lower, upper);
            return result;
        }
        
        addRange(result, lower, (long)nums[0] - 1);
        for (int i = 1; i < nums.length; i++) {
            addRange(result, (long)nums[i - 1] + 1, (long)nums[i] - 1);
        }
        addRange(result, (long)nums[nums.length - 1] + 1, upper);
        
        return result;
        
    }
    private void addRange(List<String> result, long start, long end) {
        if (start > end) {
            return;
        }
        if (start == end) {
            result.add(String.valueOf(start));
            return;
        }
        
        result.add(String.valueOf(start) + "->" + String.valueOf(end));
    }
}