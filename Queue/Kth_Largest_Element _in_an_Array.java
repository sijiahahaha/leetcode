class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length < k) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int n : nums) pq.offer(n);
        for (int i = 0; i < nums.length - k; i++) {
            pq.poll();
        }
        return pq.peek();
    }
}