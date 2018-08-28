/**
1.遍历word，用HashMap记录词的出现次数
2.遍历Map.keySet(), 将pair<word,count>存入pq，保留top K个最大的
3.poll(), 放入结果。先出的为小的，在后面

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
  
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0 || k == 0) {
            return result;
        }
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 0);
            }
            map.put(word, map.get(word) + 1);
            
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b) {
                if (a.count != b.count) {
                    return a.count - b.count;
                }
                return b.word.compareTo(a.word);
            }
        });
        for (String word : map.keySet()) {
            Pair newPair = new Pair(word, map.get(word));
            pq.offer(newPair);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        for (int i = 0; i < k; i++) {
            result.add(0, pq.poll().word);
        }
        return result;
    }
}