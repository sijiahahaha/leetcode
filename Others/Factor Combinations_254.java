/**
dfs
i从2开始遍历，如果可以整除i，把i放入list，接着对n/i递归，从i开始遍历（有可能还可以整除i）
**/
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), n, 2);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> list, int n, int start) {
        if (n <= 1) {
            if (list.size() > 1) {
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                dfs(result, list, n/i, i);
                list.remove(list.size() - 1);
            }
        }
    }
    

}



