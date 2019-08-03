class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int prefixSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (map.containsKey(prefixSum - k)) maxLen = Math.max(maxLen, i - map.get(prefixSum - k));

            if (!map.containsKey(prefixSum)) map.put(prefixSum, i);
        }

        return maxLen;
    }
}