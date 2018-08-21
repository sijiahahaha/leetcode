
//判断B是否由A rotate 得来的
class Solution {
    public boolean rotateString(String A, String B) {
        if (A == null || B == null) {
            return false;
        }
        if (A.length() != B.length()) {
            return false;
        }
        return (A + A).indexOf(B) >= 0;
    }
}



// 给定一个string和一个offset，根据offset旋转string(从左向右旋转)
//利用 (A^T B^T)^T = (AB)^T = BA
public class Solution {
    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0)
            return;
            
        offset = offset % str.length; //可能好几圈
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }
    
    private void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }
}