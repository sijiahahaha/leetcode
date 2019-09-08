nested_list_weight_sum.java
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int sum = 0;
        for (NestedInteger childInt : nestedList) {
            sum += dfs(childInt, 1);
        }
        return sum;
    }
    private int dfs(NestedInteger nestedInt, int depth) {
        if (nestedInt.isInteger()) {
            return nestedInt.getInteger() * depth;
        }
        int sum = 0;
        for (NestedInteger childInt : nestedInt.getList()) {
            sum += dfs(childInt, depth + 1);
        }
        return sum;

    }
}