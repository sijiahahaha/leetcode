public class Solution {
    /**
     * @param nums: a list of integer
     * @return: return a boolean
     */
    public boolean splitArray(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() < 7) {
            return false;
        }
        int[] prefixSum = new int[nums.size()];
        prefixSum[0] = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            prefixSum[i] = prefixSum[i - 1] + nums.get(i);
        }
        
        for (int j = 3; j < nums.size() - 3; j++) {
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < j - 1; i++) {
                if (prefixSum[i - 1] == prefixSum[j - 1] - prefixSum[i]) {
                    set.add(prefixSum[i - 1]);
                }
            }
            for (int k = j + 2; k < nums.size() - 1; k++) {
                if (prefixSum[k - 1] - prefixSum[j] == prefixSum[nums.size() - 1] - prefixSum[k]) {
                    if (set.contains(prefixSum[k - 1] - prefixSum[j])) {
                        return true;
                    }
                }
                
            }
            
        }
        return false;
    }
}