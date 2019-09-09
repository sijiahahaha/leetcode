class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        if (nums == null || nums.length == 0) return res;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length * 2; i++) {
            int j = i % nums.length;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[j]) {
                int index = stack.pop();
                res[index] = nums[j];
            }
            stack.push(j);
        }
        return res;
    }
}