class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i <= heights.length; i++) {
            int currHeight = i == heights.length ? -1 : heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > currHeight) {
                int index = stack.pop();
                int height = heights[index];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, height * width);
            }
            stack.push(i);
        }
        return max;
    }
}