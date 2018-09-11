/**
用递减栈
遍历温度，如果当前温度大于栈peek，说明遇到了warmer的温度，就pop出peek，计算index差值为需要的天数。
继续比较peek，直到没有大于了，放入stack形成递减栈
最后留在栈里的，说明后面没有warmer，都为0
**/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return new int[0];
        }
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}