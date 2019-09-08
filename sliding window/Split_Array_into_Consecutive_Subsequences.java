class Solution {
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> need = new HashMap<>();
        
        for (int num : nums) {
            if (!count.containsKey(num)) count.put(num, 0);
            count.put(num, count.get(num) + 1);
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (count.get(nums[i]) == 0) continue;
            else if (need.containsKey(nums[i]) && need.get(nums[i]) > 0) {
                count.put(nums[i], count.get(nums[i]) - 1);
                need.put(nums[i], need.get(nums[i]) - 1);
                if (!need.containsKey(nums[i] + 1)) need.put(nums[i] + 1, 0);
                need.put(nums[i] + 1, need.get(nums[i] + 1) + 1);
            } else if (count.containsKey(nums[i] + 1) && count.get(nums[i] + 1) > 0 && count.containsKey(nums[i] + 2) && count.get(nums[i] + 2) > 0) {
                count.put(nums[i], count.get(nums[i]) - 1);
                count.put(nums[i] + 1, count.get(nums[i] + 1) - 1);
                count.put(nums[i] + 2, count.get(nums[i] + 2) - 1);
                if (!need.containsKey(nums[i] + 3)) need.put(nums[i] + 3, 0);
                need.put(nums[i] + 3, need.get(nums[i] + 3) + 1);
            } else {
                return false;
            }
        }
        
        return true;
    }
}