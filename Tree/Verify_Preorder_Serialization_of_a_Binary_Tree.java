/**
stack:
这个方法简单的说就是不断的砍掉叶子节点。最后看看能不能全部砍掉。

已例子一为例，：”9,3,4,#,#,1,#,#,2,#,6,#,#” 遇到x # #的时候，就把它变为 #

我模拟一遍过程：

9,3,4,#,# => 9,3,# 继续读
9,3,#,1,#,# => 9,3,#,# => 9,# 继续读
9,#2,#,6,#,# => 9,#,2,#,# => 9,#,# => #

**/


class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) return true; 
        if (preorder.length() > 1 && preorder.charAt(0) == '#') return false;
        String[] nums = preorder.split(",");
        Stack<String> stack = new Stack<>();
        stack.push(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            String curr = nums[i];
            while (curr.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) return false;
                stack.pop();
            }
            stack.push(curr);

        }
        return stack.size() == 1 && stack.peek().equals("#");
        
    }
}

/*
total indegree = total outdegree

对于二叉树，我们把空的地方也作为叶子节点（如题目中的#），那么有

所有的非空节点提供2个出度和1个入度（根除外）
所有的空节点但提供0个出度和1个入度
我们在遍历的时候，计算diff = outdegree – indegree. 当一个节点出现的时候，diff – 1, 因为它提供一个入度；当节点不是#的时候，diff+2(提供两个出度) 如果序列式合法的，那么遍历过程中diff >=0 且最后结果为0.

*/

public boolean isValidSerialization(String preorder) {
    String[] nodes = preorder.split(",");
    int diff = 1;
    for (String node: nodes) {
        if (--diff < 0) return false;
        if (!node.equals("#")) diff += 2;
    }
    return diff == 0;
}

