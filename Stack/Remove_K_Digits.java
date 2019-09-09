class Solution {
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() < k) return "0";
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() > c && count < k)  {
                stack.pop();
                count++;
            }
            stack.push(c);
        }
        for (int i = count; i < k; i++) {
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        while (sb.length() > 1 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
}