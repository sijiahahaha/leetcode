class Pair {
        int val;
        int count;
        Pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }
class Solution {
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) map.put(n, 0);
            map.put(n, map.get(n) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return b.count - a.count;
            }
        });
        
        for (int n : map.keySet()) {
            Pair curr = new Pair(n, map.get(n));
            pq.offer(curr);
        }
        for (int i = 0; i < k; i++) {
            res.add(pq.poll().val);
        }
        return res;
    }
}