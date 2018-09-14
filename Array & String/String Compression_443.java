/**
用pos记录当前位置， 用curr记录当前比较的字符，用count记录char的个数
遍历char[], 跟curr相同就count++。遇到不同的了，则把pos位写为curr，pos++。再判断count是否大于1，大于1就写入。写入时，注意count可能为两位数，祖耀占两个字符。
**/
class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int pos = 0;
        int curr = 0;
        int count = 0;
        char currChar = chars[curr];
        while (curr < chars.length) {
            currChar = chars[curr];
            count = 0;
            while (curr < chars.length && chars[curr] == currChar) {
                count++;
                curr++; 
            }
            chars[pos++] = currChar;
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[pos++] = c;
                }
            }
            
        }

        
        return pos;
        
    }
}   





