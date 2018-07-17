/**
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
给一堆'(' ')'， 找最长的valid长度

O(n) stack:
  1. '(', push
  2. ')'
        - stack.isEmpty(), 前半部分无valid，清空，重新开始
        - 有'(', 长度为 i-pop+1
                 （ ----- ） 
                 pop     i
          - pop之后stack.isEmpty()，左边也为valid，可合并，pre += curr
          - pop之后还有'('，无法合并，找最大 Math.max(max, i-peek)

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
