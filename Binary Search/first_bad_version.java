 /**
 biinary search
 **/
class Solution {
    public static int firstBadVersion(int n) {
        if (n == 0) {
            throw new IllegalArgumentException("Invalid input!");
        }
        int left = 0;
        int right = n;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isBadVersion(left)) {
            return left;
        }
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
