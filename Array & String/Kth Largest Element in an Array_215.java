/**
1. sort, find kth
    O(nlogn)
2. quick select: 先任取一个做sort，如果正好是第k位，return。不然，看k应该在前半部分还是后半部分，取一部分做sort，继续。
    if can choose mid value each time : O(n) + O(n/2) + O(n/4) + ... + 1 = O(2n)
3. heap, poriorityqueue 
    O(nlogk)  找前k大（top k）

**/

//1
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length){
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
        
    }
}

//2 
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length){
            return -1;
        }
        return partition(nums, 0, nums.length - 1, k);
    }
    
    private int partition(int[] nums, int start, int end, int k) {
        if (start > end) {
            return nums[k];
        }
        
        int pivot = nums[start];
        int left = start + 1, right = end;
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        //pivot,  < pivot  ,     > pivot   
        //start,      right, left,      end  
        swap(nums, start, right);
        //  < pivot   , pivot,  > pivot 
        //start,        right, left,    end

        if (right + 1 > k) {
            return partition(nums, start, right - 1, k);
        }

        if (right + 1 < k) {
            return partition(nums, right + 1, end, k);
        }
        return pivot;
    }
    
    private void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}

//3
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length){
            return -1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
       
        return pq.poll();
    }
}


