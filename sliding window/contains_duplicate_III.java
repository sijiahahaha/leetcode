class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k < 0 || t < 0) {
            return false;
        }
        
        
        // -t <= i - j <= t
        // j - t <= i  && i <= j + t
        TreeSet<Long> ts = new TreeSet<>();
        
        
        for (int j = 0; j < nums.length; j++) {
            Long target = ts.ceiling((long)nums[j] - t);
            if (target != null && target <= (long)nums[j] + t) {
                return true;
            }
            ts.add((long)nums[j]);
            if (j >= k) {
                ts.remove((long)nums[j - k]);
            }
        }
        return false;
    }
}