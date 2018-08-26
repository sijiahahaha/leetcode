/**  
Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

把2放入1， 1保证有足够空间。 mn分别为12的有效数字个数

不用额外空间，在1里从第m+n-1位从后往操作
**/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            nums1[i--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        
        //nums1 都放完了
        while (n >= 0) {
            nums1[i--] = nums2[n--];
        }
        
        //else, nums2都放完了，剩下的就是nums1，不用动
    }
}