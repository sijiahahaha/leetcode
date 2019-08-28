class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        digits[digits.length - 1] += 1;
        for (int i = digits.length - 1; i > 0; i--) {
            if (digits[i] == 10) {
                digits[i - 1] += 1;
                digits[i] = 0;
            }
        }
        
        if (digits[0] == 10) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}