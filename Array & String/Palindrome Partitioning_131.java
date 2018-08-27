/**  
Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
把string分割成回文串，求所有可能的分割

dfs
遍历，当前i个isPalindrome
        记录，对剩下的部分递归接着分割
        删除，接着i+1


**/


/class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        }
        List<String> partitions = new ArrayList<>();
        dfs(s, 0, partitions, result);
        return result;
    }
    private void dfs(String s, int start, List<String> partitions, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<String>(partitions));
            return;
        }
        
        for (int i = start; i < s.length(); i++) {
            String sub = s.substring(start, i + 1);
            if (isPalindrome(sub)) {
                partitions.add(sub);
                dfs(s, i + 1, partitions, result);
                partitions.remove(partitions.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}