/**
从左到右遍历一遍，算出每一位与左边最近的C的距离
再从右往左遍历一遍，算出与右边最近C的距离
取短的
**/
class Solution {
    public int[] shortestToChar(String S, char C) {
        if (S == null || S.length() == 0) {
            return new int[0];
        }
        int len = S.length();
        int[] result = new int[len];
        int lastPos = -len;
        for (int i = 0; i < len; i++) {
            if (S.charAt(i) == C) {
                lastPos = i;
            }
            result[i] = i - lastPos;
        }
        
        for (int i = len - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                lastPos = i;
            }
            result[i] = Math.min(result[i], Math.abs(i - lastPos));
        }
        return result;
        
    }
}
