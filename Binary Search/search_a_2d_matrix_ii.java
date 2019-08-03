 /**
 *
 * small ----------large
 * |                |
 * |                |
 * |                |
 * |                |
 * |                |
 * large            large
 *
 * start with right-top, if larger than target, go left,
 *                       if smaller than target, go down
 *
 *
 * **/
class Solution {
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0;
        
        int i = m - 1;
        int j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] == target) {
                count++;
                i--;
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                j++;
            }
        }
        
        return count;
        
    }

}

