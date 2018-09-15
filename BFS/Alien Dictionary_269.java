/**
topological sort
注意： 不是单词中字母的顺序，
     word顺序，是当前n为位相同，根据不同位的顺序排序
1. 用HashMap<Character, HashSet<Character>> 来统计每个char后面的char有哪些
2. 统计in degree
3. 把为0的放入queue， bfs
**/
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> map = constructStructure(words);
        return topologicalSort(words, map);
    }
    
    private Map<Character, Set<Character>> constructStructure(String[]  words) {
        Map<Character, Set<Character>> map = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (!map.containsKey(c)) {
                    map.put(c, new HashSet<Character>());
                }
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    map.get(words[i].charAt(j)).add(words[i + 1].charAt(j));
                    break;
                }
            }
        }
        return map;  
    }
    
    private Map<Character, Integer> getIndegree(Map<Character, Set<Character>> map) {
        Map<Character, Integer> indegree = new HashMap<>();
        for (Character c : map.keySet()) {
            indegree.put(c, 0);
        }
        for (Character c : map.keySet()) {
            for (Character k : map.get(c)) {
                indegree.put(k, indegree.get(k) + 1);
            }
        }
        
        return indegree;
    }
    
    private String topologicalSort(String[] words, Map<Character, Set<Character>> map) {
        Map<Character, Integer> indegree = getIndegree(map);
        Queue<Character> que = new LinkedList<>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                que.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!que.isEmpty()) {
            Character curr = que.poll();
            sb.append(curr);
            for (Character k : map.get(curr)) {
                indegree.put(k, indegree.get(k) - 1);
                if (indegree.get(k) == 0) {
                    que.offer(k);
                }
            }
        }
        
        String result = sb.toString();
        if (result.length() != map.size()) {
            return "";
        }
        return result;
    }
}