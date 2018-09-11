/**
思想类似Daily Temperatures
对nums2 利用栈，找到每一个数右边第一个greater的数，关系放入hashmap
遍历nums1，对每个数，直接到map里找
**/
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if (map.containsKey(nums1[i])) {
                result[i] = map.get(nums1[i]);
            } else {
                result[i] = -1;
            }
        }
        return result;
    }
}

/**
可以search circularly to find its next greater number
同于1，但是在遍历完一遍后，再遍历一遍，达成circularly search。 因为第一遍都已入栈，第二遍不push了，只是比较大小
**/
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
            stack.push(i);
        }
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i];
            }
        }
        return result;
    }
}

/**
32bit Integer, 找到next greater int由same digits构成的
类似Next Permutation，返回时要注意是否超出int范围
<3 6 4 2>
    1. 从后往前，找到第一个不是递减的 i > i+1          <3   6 4 2>     
    2. 遍历后半段，找到比i大且差值最小的数 j  ==>  因为后半段是递减的，从后往前，找到第一个比i大的数           <4>
    3. 交换i,j                                    <4  6  3  2>
    4. 对后半段reverse                             <4  2  3  6>

**/
class Solution {
    public int nextGreaterElement(int n) {  
        char[] digits = String.valueOf(n).toCharArray();
        int index = -1;
        for (int i = digits.length - 1; i >= 1; i--) {
            if (digits[i] > digits[i - 1]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            return -1;
        }
        
        int biggerIndex = index + 1;
        for (int i = digits.length - 1; i > index; i--) {
            if (digits[i] > digits[index]) {
                biggerIndex = i;
                break;
            }
        }
        swap(digits, index, biggerIndex);
        reverse(digits, index + 1, digits.length - 1);
        long value = Long.parseLong(new String(digits));
        return value <= Integer.MAX_VALUE ? (int) value : -1;    
    }
    private void swap(char[] nums, int left, int right) {
        char temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
    
    private void reverse(char[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}