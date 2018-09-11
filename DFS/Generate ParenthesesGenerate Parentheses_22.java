/**
dfs
记录剩余需要'('的数量和剩余需要')'的数量
判断如果left>right,真的无法构成valid

如果没有判断， time O(2^n)  因为有判断，符合Catalan number规律，即(0, n) (1, n - 1) (2, n - 2) ...所以O(n!)
**/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }
        String curr = "";
        int left = n;
        int right = n;
        dfs(result, curr, left, right);
        return result;
    }
    private void dfs(List<String> result, String curr, int left, int right) {
        if (left > right) {
            return;
        }
        if (left == 0 && right == 0) {
            result.add(curr);
            return;
        }
        if (left > 0) {
            dfs(result, curr + "(", left - 1, right);
        }
        if (right > 0) {
            dfs(result, curr + ")", left, right - 1);
        }
    }
}