replace_with_greatest_from_right.java
class Solution {
	public void replace(int[] nums) {
		if (nums == null || nums.length == 0) return;
		int len = nums.length;
		int max = nums[len - 1];
		nums[len - 1] = -1;
		for (int i = len - 2; i >= 0; i--) {
			int temp = nums[i];
			nums[i] = max;
			max = Math.max(max, temp);
		}
	}
}