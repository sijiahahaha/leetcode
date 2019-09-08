nested_list_weight_sum_ii.java
public class Solution {
    /**
     * @param nestedList: a list of NestedInteger
     * @return: the sum
     */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        int single = 0, sum = 0;
        Queue<List<NestedInteger>> queue = new LinkedList<>();
        queue.offer(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                List<NestedInteger> curr = queue.poll();
                for (NestedInteger childInt : curr) {
                    if (childInt.isInteger()) {
                        single += childInt.getInteger();
                    } else if (childInt.getList() != null) {
                        queue.offer(childInt.getList());
                    }
                }
            }
            sum += single;
        }
        return sum;
    }
}