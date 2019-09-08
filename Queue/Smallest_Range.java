public class Solution {
    /**
     * @param nums: k lists of sorted integers
     * @return: the smallest range that includes at least one number from each of the k lists
     */
    private class Pair {
        int val;
        int index;
        int list;
        Pair(int val, int index, int list) {
            this.val = val;
            this.index = index;
            this.list = list;
        }
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) return null;
        if (nums.size() == 1) return new int[]{nums.get(0).get(0), nums.get(0).get(0)};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                return a.val - b.val;
            }
        });
        
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> currList = nums.get(i);
            if (currList == null || currList.size() == 0) return null;
            pq.offer(new Pair(currList.get(0), 0, i));
            max = Math.max(max, currList.get(0));
        }
        min = pq.peek().val;
        int[] res = new int[]{min, max};
        while (true) {
            Pair out = pq.peek();
            if (out.index == nums.get(out.list).size() - 1) {
                break;
            }
            pq.poll();
            int newIndex = out.index + 1;
            int newVal = nums.get(out.list).get(newIndex);
            max = Math.max(max, newVal);
            pq.offer(new Pair(newVal, newIndex, out.list));
            min = pq.peek().val;
            if (res[1] - res[0] > max - min) {
                res[1] = max;
                res[0] = min;
            }
        }
        
        return res;
    }
}