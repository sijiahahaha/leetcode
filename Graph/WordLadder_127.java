/**  
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.


bfs， 用queue遍历，用hashset存已经用过的词避免成环
1. 把start word放入queue
2. 对于每个level， length++，poll(), 生成这个词可能变成的词（每一位替换a-z，看是否在字典里）
      若这个词在hash里，过
      若这个词是end word，则停止
      若这个词都不是，则放入queue


**/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        
        if (dict == null) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }
        
        dict.add(beginWord);
      
        
        HashSet<String> hash = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        hash.add(beginWord);
        queue.offer(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String possible : getPossibleWord(word, dict)) {
                    if (hash.contains(possible)) {
                        continue;
                    }
                    if (possible.equals(endWord)) {
                        return length;
                    }
                    
                    hash.add(possible);
                    queue.offer(possible);
                }
            }
        }
        return 0;
    }
    
    
     private ArrayList<String> getPossibleWord(String word, Set<String> dict) {
        ArrayList<String> possibleWords = new ArrayList<String>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String newWord = replace(word, i, c);
                if (dict.contains(newWord)) {
                    possibleWords.add(newWord);
                }
            }
        }
        
        return possibleWords;
    }
    
    private String replace(String word, int index, char c) {
        char[] wordChar = word.toCharArray();
        wordChar[index] = c;
        word = String.valueOf(wordChar);
        return word;
    }
    
}