/**  
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.

if two words have the same frequency, then the word with the lower alphabetical order comes first.

1.构造Pair class
2.遍历，用HashMap记录词的出现次数
3.遍历Map.keySet(), 用PrioriyQueue，保留top K个最大的
4.poll(), 放入结果。先出的为小的，在后面

**/


class Solution {
    class Pair {
        String word;
        int count;
        
        Pair(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    
    private Comparator<Pair> pairComp = new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b) {
                if (a.count != b.count) {
                    return a.count - b.count;
                }
                return b.word.compareTo(a.word);
            }
    };
    
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0 || k == 0) {
            return result;
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(pairComp);
        for (String word : map.keySet()) {
            Pair newPair = new Pair(word, map.get(word));
            if (pq.size() < k) {
                pq.offer(newPair);
            } else if (pairComp.compare(newPair, pq.peek()) > 0) {
                pq.poll();
                pq.offer(newPair);
            }
            
        }
        
        for (int i = k - 1; i >= 0; i--) {
            result.add(0, pq.poll().word);
            
        }
        return result;
    }
}