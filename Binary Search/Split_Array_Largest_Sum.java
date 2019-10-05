Split_Array_Largest_Sum.java
public class Solution {
    /**
     * @param nums: a list of integers
     * @param m: an integer
     * @return: return a integer
     */
    public int splitArray(int[] nums, int m) {
        // write your code here
        if (nums == null || nums.length == 0) return 0;
		int max = 0;
		long sum = 0;
		for (int num : nums) {
			max = Math.max(num, max);
			sum += num;
		}
		if (m == 1) return (int)sum;
		if (m == nums.length) return max;

		long left = max;
		long right = sum;
		while (left <= right) {
			long mid = left + (right - left) / 2;
			if (valid(mid, nums, m)) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return (int)left;
    }
    private boolean valid(long target, int[] nums, int m) {
		int sum = 0;
		int count = 1;
		for (int num : nums) {
			sum += num;
			if (sum > target) {
				count ++;
				if (count > m) return false;
				sum = num;
			}
		}
		return true;
    }
}
