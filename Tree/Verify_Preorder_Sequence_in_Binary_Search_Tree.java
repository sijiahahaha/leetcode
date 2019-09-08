public class Solution {
    /**
     * @param preorder: List[int]
     * @return: return a boolean
     */
    public boolean verifyPreorder(int[] preorder) {
        // write your code here
        if (preorder == null || preorder.length == 0) return true;
        return helper(preorder, 0, preorder.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean helper(int[] preorder, int start, int end, int min, int max) {
        if (start > end) return true;
        int rootVal = preorder[start];
        if (rootVal >= max || rootVal <= min) return false;
        int i = start;
        for (; i <= end; i++) {
            if (preorder[i] > rootVal) break;
        }
        return helper(preorder, start + 1, i - 1, min, rootVal) && helper(preorder, i, end, rootVal, max);
    }
}

