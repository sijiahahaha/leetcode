/**
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.

用HashSet记录数字有没有重复
用HashMap记录pair有没有重复
**/

class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (set.contains(nums[i] - k)) {
                if (!map.containsKey(nums[i] - k)) {
                    map.put(nums[i] - k, nums[i]);
                    count++;
                }
            }
            set.add(nums[i]);
        }
        return count;
    }
}