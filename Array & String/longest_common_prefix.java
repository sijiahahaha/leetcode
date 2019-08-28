
 
//Longest Common Prefix.java
class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if (strs == null || strs.length == 0) return "";
    	Arrays.sort(strs);
    	String head = strs[0];
    	String tail = strs[strs.length - 1];
    	int size = Math.min(head.length(), tail.length());
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < size; i++) {
    		if (head.charAt(i) != tail.charAt(i)) break;
    		sb.append(head.charAt(i));
    	}
    	return sb.toString();
    }
}