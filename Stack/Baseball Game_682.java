/**  
Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.


利用stack来做，注意在判断string 是否为数字的时候，用最后一位来判断
**/

class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        
        for (String curr : ops) {
            if (Character.isDigit(curr.charAt(curr.length()-1))) {
                int num = Integer.parseInt(curr);
                stack.push(num);
                sum += num;
            } else {
                if (curr.charAt(0) == '+') {
                    int lastNum = stack.pop();
                    int newNum = lastNum + stack.peek();
                    stack.push(lastNum);
                    stack.push(newNum);
                    
                    sum += newNum;
                } else if (curr.charAt(0) == 'D') {
                    int newNum = 2 * stack.peek();
                    stack.push(newNum);
                    sum += newNum;
                } else if (curr.charAt(0) == 'C') {
                    int lastNum = stack.pop();
                    sum -= lastNum;
                }
            }
            
        }
        
        return sum;
    }
}