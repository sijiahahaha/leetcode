/**
这道题的提示说了我们肯定不能把范围内的所有数字都更新，而是只更新开头结尾两个数字就行了
那么我们的做法就是在开头坐标startIndex位置加上inc，而在结束位置加1的地方加上-inc
那么根据题目中的例子，我们可以得到一个数组，nums = {-2, 2, 3, 2, -2, -3}
然后我们发现对其做累加和就是我们要求的结果result = {-2, 0, 3, 5, 3}
**/
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] add = new int[length + 1];
        for (int[] update : updates) {
            int start = update[0];
            int end = update[1];
            int value = update[2];
            add[start] += value;
            add[end + 1] -= value;
        }
        int[] result = new int[length];
        result[0] = add[0];
        for (int i= 1; i < length; i++) {
            result[i] = result[i - 1] + add[i];
        }
        return result;
    }
}