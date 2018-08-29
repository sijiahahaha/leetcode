/**
先把数都加起来，如果是奇数，则无法平分。得到一半mid，即要找是否有子集sum为mid
DP boolean[] f 
f[k] 表示nums是否有子集sum为k， k从0一直到20000
遍历nums[],  对于其中的一个n1，f[n1]为true（自己一个子集），下一个数n2，f[n2]为true, 而f[n1+n2]肯定为true
    所以，对于n1~mid的区间里，如果k-n1也在nums里，那么k可以由n1加n2得到
    即f[k] = f[k] || f[k - n1]         (n1 <= k <= mid)
    k 一定要从mid遍历到n1，而不能反过来 (f[0] = true -> f[1] = f[1]||f[0] = true .....都是true)
**/
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int mid = sum / 2; 
        
        boolean[] f  = new boolean[20000]; //200*100
        f[0] = true;
        for (int i = 1; i <= mid; i++) {
            f[i] = false;
        }
        
        for (int i = 0; i < nums.length; i++) {
            for (int k = mid; k >= nums[i]; k--) {
                f[k] = f[k] || f[k - nums[i]];
            }
        }
        return f[mid];
    }
}