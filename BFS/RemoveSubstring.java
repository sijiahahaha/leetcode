/**  
Given s = ccdaabcdbb, substrs = ["ab", "cd"]
Return 2

Explanation:
ccdaabcdbb -> ccdacdbb -> cabb -> cb (length = 2)
把s中所有包含的substrs去掉，得到最小长度

从最长开始找，遍历每一个词单里的词，去掉，得到substring，再继续找
BFS用queue
用hashSet记录是否重复找过了
**/
public class Solution {
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        Queue<String> queue = new LinkedList<>();
        Set<String> hash = new HashSet<>();
        
        int minLen = s.length();
        queue.offer(s);
        hash.add(s);
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            for (String sub : dict) {
                int found = curr.indexOf(sub);
                while (found >= 0) {
                    String newS = curr.substring(0, found) + curr.substring(found + sub.length());
                    if (!hash.contains(newS)) {
                        queue.offer(newS);
                        hash.add(newS);
                        minLen = Math.min(minLen, newS.length());
                    }
                    found = curr.indexOf(sub, found + 1);
                }
                
            }
        }
        return minLen;
    }
}