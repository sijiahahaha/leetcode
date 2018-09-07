/**  
Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]


看nums是否有重复的数：
  1. 无重复的数
     递归，visited的数标记，直到排列的size等于全部数
     递归之后要remove加入的数

  2. 有重复的数
     sort nums
     如果遇到 nums[i] = nums[i-1],需要判断nums[i-1]有没有visited，如果没有，nums[i]也不可以放进去。两个放一个只能是前面的
**/


//无重复的数
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0){
            return results;
        }    
        boolean[] isVisited = new boolean[nums.length];
        List<Integer> curr = new ArrayList<Integer>();
        helper(nums, isVisited, curr, results);
        return results;
    }
    
    
    private void helper(int[] nums, boolean[] isVisited, List<Integer> curr, List<List<Integer>> results) {
        if (curr.size() == nums.length) {
            results.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            curr.add(nums[i]);
            isVisited[i] = true;
            helper(nums, isVisited, curr, results);
            curr.remove(curr.size() - 1);
            isVisited[i] = false;          
        }
    }
}



//如果有重复的数
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[nums.length];
        List<Integer> curr = new ArrayList<Integer>();
        helper(nums, isVisited, curr, results);
        return results;
    }
    
    public void helper(int[] nums, boolean[] isVisited, List<Integer> curr, List<List<Integer>> results) {
        if (curr.size() == nums.length) {
            results.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (isVisited[i]) {
                continue;
            }
            
            if (i > 0 && nums[i] == nums[i-1] && !isVisited[i-1]) {
                continue;
            }
            
            curr.add(nums[i]);
            isVisited[i] = true;
            helper(nums, isVisited, curr, results);
            curr.remove(curr.size() - 1);
            isVisited[i] = false;
        }
        
    }
}

//求第kth个全排列， 不用递归做了
//对于n个数字，选定第一位后，有(n-1)! 种排列，以此类推。每次用k/(n-1)!得到首位
class Solution {
    public String getPermutation(int n, int k) {
        //factorial = [1,1,2,6,24,120,...,n!]
        int sum = 1;
        int[] factorial = new int[n+1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }
        
        //nums = [1,2,3,4,...,n]
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }
        
        //build string
        StringBuilder sb = new StringBuilder();
        k = k-1;
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n-i];
            sb.append(String.valueOf(nums.get(index)));
            nums.remove(index);
            k = k % factorial[n-i];
        }
        
        return String.valueOf(sb);
        
    }
}


