/**
    1. 设序列pn=<3 6 4 2>，根据定义可算得下一个序列pn+1=<4 2 3 6>。
    2. 观察pn可以发现，其子序列<6 4 2>已经为减序，那么这个子序列不可能通过交换元素位置得出更大的序列了，因此必须移动最高位3（即a1）的位置，且要在子序列<6 4 2>中找一个数来取代3的位置。
    3. 子序列<6 4 2>中6和4都比3大，但6大于4。如果用6去替换3得到的序列一定会大于4替换3得到的序列，因此只能选4。
    4. 将4和3的位置对调后形成排列<4 6 3 2>。对调后得到的子序列<6 3 2>仍保持减序，即这3个数能够生成的最大的一种序列。而4是第1次作为首位的，需要右边的子序列最小，因此4右边的子序列应为<2 3 6>，这样就得到了正确的一个序列pn+1=<4 2 3 6>。
    
    <3 6 4 2>
    1. 从后往前，找到第一个不是递减的 i > i+1          <3   6 4 2>     
    2. 遍历后半段，找到比i大且差值最小的数 j  ==>  因为后半段是递减的，从后往前，找到第一个比i大的数           <4>
    3. 交换i,j                                    <4  6  3  2>
    4. 对后半段reverse                             <4  2  3  6>

**/
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int index = - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }
        //如果没找到，则为降序排列，已为最大，reverse为最小
        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        int biggerIndex = index + 1;
        for (int i = nums.length - 1; i > index; i--) {
            if (nums[i] > nums[index]) {
                biggerIndex = i;
                break;
            }
        }
        swap(nums, index, biggerIndex);
        reverse(nums, index + 1, nums.length - 1);
        
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
    
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}