 /*
 * given image char[m][n] and one black pixel location (x, y)
 *
 * DFS or Binary Search
 *
 * Binary Search:
 *  use BS to find left, right, top, bottom boundary:
 *    - left : [0~y]*[0~m] find first '1'
 *    - right : [y~n]*[0~m] find last '1'
 *    - top : [0~x]*[left~right] find first '1'
 *    - bottom : [x~m]*[left~right] find last '1'
 *
 *
 * */

class Solution{
    public static int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        int left = findBoundary(image, 0, y, 0, m, false, true);
        int right = findBoundary(image, y + 1, n, 0, m, false, false);
        int top = findBoundary(image, 0, x, left, right, true, true);
        int bottom = findBoundary(image, x + 1, m, left, right, true, false);
        return (right - left) * (bottom - top);
    }

    private static int findBoundary(char[][] image, int start, int end, int low, int high, boolean horizontal, boolean first) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int k = low;
            while (k < high) {
                if ((horizontal ? image[mid][k] : image[k][mid]) == '1') break;
                k++;
            }
            if (first && k <= high) end = mid;
            else if (first && k > high) start = mid;
            else if (!first && k <= high) start = mid;
            else if (!first && k > high) end = mid;
        }
        return start;
    }

}
