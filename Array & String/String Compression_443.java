/**
用pos记录当前位置， 用curr记录当前比较的字符，用count记录char的个数
用i遍历char[], 跟curr相同就count++。遇到不同的了，则把pos位写为curr，pos++。再判断count是否大于1，大于1就写入。写入时，注意count可能为两位数，祖耀占两个字符。
推出循环时，最后一个找的char还没有写入，所以再写入一下
**/
class Solution {
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        int pos = 0;
        char curr = chars[pos];
        int count = 1;
        
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == curr) {
                count++;
            } else {
                chars[pos] = curr;
                pos++;
                if (count > 1) {
                    for(char c : Integer.toString(count).toCharArray()) {
                        chars[pos] = c;
                        pos++;
                    }                  
                }
                curr = chars[i];
                count = 1;
            }
        }
        
        chars[pos] = curr;
        pos++;
        if (count > 1) {
            for(char c : Integer.toString(count).toCharArray()) {
                chars[pos] = c;
                pos++;
            }  
        }
        return pos;
        
    }
}   