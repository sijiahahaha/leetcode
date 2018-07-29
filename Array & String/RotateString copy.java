/**
Input: "the sky is blue",
Output: "blue is sky the".
**/
//input string
public class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].equals("")) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(words[i]);
            }
        }
        
        return sb.toString();
    }
}

/**
Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
**/
//input character array
public class Solution {
    /**
     * @param str: a string
     * @return: return a string
     */
    public char[] reverseWords(char[] str) {
        if (str == null || str.length == 0) {
            return str;
        }
        
        String sentence = new String(str);
        String[] words = sentence.split(" ");
        
        int index = 0;
        for (int i = words.length - 1; i >= 0; i--) {
            if (index > 0) {
                str[index] = ' ';
                index++;
            }
            int j = 0;
            while (j < words[i].length()) {
                str[index] = words[i].charAt(j);
                j++;
                index++;
            }
        }
        
        return str;
    }
}