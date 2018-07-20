/**  
Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.


难点是用O(n)来解 -- 用deque
要保证deque里永远是 (head)first [最大， 第二大， 第三大，......] last(tail)
 # inDeque : 从last开始比较，while(!isEmpty() && peekLast < num){pollLast()}, 然后offer(num)
 # outDeque: 移至下一点前，现将window最左端点出队（如果还在队里的话） if(peekFirst() = num) {pollFirst()}


  1.将 i < (k-1)放入deque （直到window倒数第二个）
  2.将 i= k-1 放入deque （window最后一个）， 构成第一个window
    deque.peekFirst 为此window最大
    将window最左端移除
  3.i++
**/

import java.util.Deque;
import java.util.ArrayDeque;
class Solution {
    private void inDeque(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.pollLast();
        }
        deque.offer(num);
    }
    
    private void ourDeque(Deque<Integer> deque, int num) {
        if (deque.peekFirst() == num) {
            deque.pollFirst();
        }
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {     
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        
        int[] max = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k - 1; i++) {
            //put nums[i] in deque
            inDeque(deque, nums[i]);
        }
        int count = 0;
        for (int i = k - 1; i< nums.length; i++) {
            //put nums[i] in deque
            inDeque(deque, nums[i]);
            //deque.peekFirst = max
            max[count] = deque.peekFirst();
            count++;
            //remove nums[i-k+1]
            ourDeque(deque, nums[i - k + 1]);
        }
        
        return max;
    }   
}