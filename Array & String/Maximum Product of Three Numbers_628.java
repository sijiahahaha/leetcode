/**
排序 
可能的情况：
    都是正数 ： 要最后三个
    都是负数 ： 要最后三个 （负数，要绝对值小的）
    有正有负 ： Max（要两个负一个正：前两个负，最后一个正 or 最三个正）
所以，只可能取最后三个，或前两个和最后一个。排序取出来比较就行了
**/
class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return -1;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int p1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int p2 = nums[n - 1] * nums[0] * nums[1];
        return p1 > p2 ? p1 : p2;
    }
}