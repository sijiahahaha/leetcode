 /**
binary search
 **/
class Solution {
    public static int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            throw new IllegalArgumentException("Invalid inout!");
        }

        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (A[left] >= target) return left;
        if (A[right] < target) return right + 1;
        return right;
    }
}
class TEST {
    public static void main (String[] args) {
        int[] letters = new int[]{1,3,5,6};
        int result = Solution.searchInsert(letters, 0);
        System.out.println(result);

    }
}
