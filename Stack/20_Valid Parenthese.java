/**  
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
  1. Open brackets must be closed by the same type of brackets.
  2. Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

{()} true     (]) false


判断括号是否对等 

# 把string变为char一个个比较： string.toCharArray()
用stack：
  1.遇到左就push
  2.右就pop出来一个比较是否一对
  3.pop时考虑stack是否为空
**/


class Solution {
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();     
        
        for (char c : s.toCharArray()) {
            // 1. 遇到左边，push
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // 2. 遇到右边，判断是否为一对
            // 3. pop时考虑是否为空
            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
            
        }
        
        return stack.isEmpty();
    }
}
