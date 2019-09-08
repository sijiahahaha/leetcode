public class Solution {
    /**
     * @param expression: a string, denote the ternary expression
     * @return: a string
     */
    public String parseTernary(String expression) {
        // write your code here
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '?') stack.push(i);
        }
        String res = expression;
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            res = res.substring(0, idx - 1) + eval(res.substring(idx - 1, idx + 4)) + res.substring(idx + 4);
        }
        return res;
    }
    
    private String eval(String str) {
        return str.charAt(0) == 'T' ? str.substring(2, 3) : str.substring(4);
    }
}