/**
遍历数字，用hashmap计算每个数字出现次数
将Pair<num, count> 存入pq，保留k个最大的
**/
class Solution {
    class Pair{
        int num;
        int count;
        Pair(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0) {
            return result;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            map.put(num, map.get(num) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new Comparator<Pair>(){
            @Override
            public int compare(Pair a, Pair b) {
                return a.count - b.count;
            }
        });
        for (int num : map.keySet()) {
            Pair np = new Pair(num, map.get(num));
            pq.offer(np);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        for (int i = 0; i < k; i++) {
            result.add(0, pq.poll().num);
        }
        return result;
    }
}