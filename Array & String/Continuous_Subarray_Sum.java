class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int t = k == 0 ? prefixSum : (prefixSum % k);
            if (map.containsKey(t)) {
                if (i - map.get(t) >= 2) return true;
            } else {
                map.put(t, i);
            }
        }
        return false;
    }
}