/**
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

给string和dict，切词，判断能否完美切分

1.state f[i]表示前i个字符能否完美切分
    boolean[] f
2.function
   [ a b c d | e f g]  f[i]=true  =>  f[j]=true && s[j+1,i] is a word
           j       i

3.initialize
    f[0] = true  f[0]代表的是开头的空串
4.answer
     f[n]  n=s.length()

#优化： 先求出dict中最长词的长度，s[j,i]超过了，就不是
**/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        //state
        boolean[] f = new boolean[s.length()+1];
        
        //initialize
        f[0] = true;
        
        //function
        for (int i = 1; i <= s.length(); i++) {
            f[i] = false;
            for (int j = 0; j < i; j++) {
                if (f[j] == true && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }              
            }
        }
    
        //answer
        return f[s.length()];
    }
}