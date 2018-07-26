/**
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.


用两个栈
stack用来实现基本stack function
minStack用来记录每个值进入后，当前最小值

**/

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int pre = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    pre = 0;
                } else {
                    int currLen = i - stack.pop() + 1;
                    if (stack.isEmpty()) {
                        pre += currLen;
                        max = Math.max(max, pre);
                    } else {
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
        }
        
        return max;
    }
}
