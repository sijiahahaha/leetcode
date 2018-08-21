/**
有多少个subarray的sum等于k


solution 1: bruce force      O(n^3) time
    计算出所有sum[i~j]，看等不等于K
solution 2: prefixsum
    sum[i~j] = sum[i ~ j-1] + j
    把复杂度减少到O(n^2)
solution 3: prefixsum array
    prefixsum[i] = sum[0 ~ i-1] + i
    sum[i~j] = prefixsum[j] - prefixsum[i-1]

    prefixsum = [0, ....] add 0
    sum[i~j] = prefixsum[j] - prefixsum[i] = k

    问题变为：对于每一个j，前面有多少个i满足 prefixsum[i] = prefixsum[j] - k
    用hashMap存<prefixsum[i], 出现次数>, 初始化map.put(0, 1);
**/

//2 
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int prefixsum = 0;
            for (int j = i; j < nums.length; j++) {
                prefixsum += nums[j];
                if (prefixsum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}


//3
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        int prefixsum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            prefixsum += nums[i];
            if (map.containsKey(prefixsum - k)) {
                count += map.get(prefixsum - k);
            }
            
            if (!map.containsKey(prefixsum)) {
                map.put(prefixsum, 1);
            } else {
                map.put(prefixsum, map.get(prefixsum) + 1);
            }
            
        }
        return count;
    }
}


/**
最长的subarray的sum等于k，有多长
prefixsum array
用hashMap存<prefixsum[i], 位置>
初始化map.put(0, -1);
**/
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int prefixsum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixsum += nums[i];
            if (map.containsKey(prefixsum - k)) {
                maxLen = Math.max(maxLen, i - map.get(prefixsum - k));
            } 
            if (!map.containsKey(prefixsum)) {
                map.put(prefixsum, i);
            }
        }
        return maxLen;
        
    }
}