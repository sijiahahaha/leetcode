/**
用Map<Character, Integer>统计char的count
用priorityqueue排序
**/
class Solution {
    class Pair {
        char c;
        int count;
        Pair (char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    public String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (Character k : s.toCharArray()) {
            if (!map.containsKey(k)) {
                map.put(k, 0);
            }
            map.put(k, map.get(k) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return b.count - a.count;
            }
        });
        for (Character k : map.keySet()) {
            Pair p = new Pair(k, map.get(k));
            pq.offer(p);
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            for (int i = 0; i < curr.count; i++) {
                sb.append(curr.c);
            }  
        }
        return sb.toString();
    }
}