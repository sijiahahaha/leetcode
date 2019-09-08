class Solution {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    
    
    public double[] medianSlidingWindow(int[] nums, int k) {
        /*
        if (nums == null || nums.length < k) {
            throw new IllegalArgumentException("Score is not valid!");
        }
        */
        double[] res = new double[nums.length - k + 1];
        for (int i = 0; i < k - 1; i++) {
            addNum(nums[i]);
        }
        
        for (int i = k - 1; i < nums.length; i++) {
            addNum(nums[i]);
            res[i - k + 1] = findMedium();
            removeNum(nums[i - k + 1]);
        }
        
        return res;
        
    }
    
    private void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        } 
        
        int medium = maxHeap.peek();
        if (num <= medium) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }
        balance();
    }
    
    private void removeNum(int num) {
        int medium = maxHeap.peek();
        if (num <= medium) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
        balance();
    }
    
    private double findMedium() {
        if (maxHeap.size() == minHeap.size()) {
            return maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
    
    private void balance() {
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
}