/**
given n arrays, pick 2 num form different arrays to make abs(a,b) max

int minLeft, maxRight, maxDist
each time compare left, right, abs(left, maxRight), abs(minLeft, right)
update
 **/
import java.util.HashMap;
class Solution {
    public static int maxDistance(int[][] arrays) {
        if (arrays == null || arrays.length <= 1) {
            throw new IllegalArgumentException("Invalid inout!");
        }
        int minLeft = arrays[0][0];
        int maxRight = arrays[0][arrays[0].length - 1];
        int maxDist = 0;
        for (int n = 1; n <= arrays.length - 1; n++) {
            int d1 = Math.abs(minLeft - arrays[n][arrays[n].length - 1]);
            int d2 = Math.abs(maxRight - arrays[n][0]);
            maxDist = Math.max(maxDist, Math.max(d1, d2));
            minLeft = Math.min(minLeft, arrays[n][0]);
            maxRight = Math.max(maxRight, arrays[n][arrays[n].length - 1]);
        }
        return maxDist;
    }
}
class TEST {
    public static void main (String[] args) {
        int[][] arrays = {{1, 2, 3, 4, 5, 6, 7, 8, 9}, {0, 10}};
        int result = Solution.maxDistance(arrays);
        System.out.println(result);

    }
}
