 class Solution {
    public static int findDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) count++;
            }
            if (count <= mid) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return right;
    }

}
