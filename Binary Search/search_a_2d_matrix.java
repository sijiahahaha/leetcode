/**
 [ 小 -> 大
   大 -> 更大
   更大 ->最大 ]
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row

先找到最后一个小于target的行，再在行里找target
**/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int start = 0;
        int end = m - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[end][0] <= target) {
            m = end;
        } else if (matrix[start][0] <= target) {
            m = start;
        } else {
            return false;
        }
        
        start = 0;
        end = n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (matrix[m][mid] == target) {
                return true;
            } else if (matrix[m][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (matrix[m][start] == target) {
            return true;
        } else if (matrix[m][end] == target) {
            return true;
        } else {
            return false;
        }
        
    }
}

/**
   小 —— 大
   | 
   大
Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

从左下往右上找， 小就往右，大就往上
**/
public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param target: An integer you want to search in matrix
     * @return: An integer indicate the total occurrence of target in the given matrix
     */
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