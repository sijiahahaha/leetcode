// Reverse String II .java
class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i += 2 * k) {
            if (i + k - 1 <= chars.length - 1) {
                reverse(chars, i, i + k - 1);
            } else {
                reverse(chars, i, s.length() - 1);
            }
        }
        return String.valueOf(chars);
    }
    
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }
}


