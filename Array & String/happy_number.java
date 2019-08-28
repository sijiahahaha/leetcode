class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        HashSet<Long> set = new HashSet<>();
        long sum = n;
        while (sum != 1) {
            sum = getSum(sum);
            if (sum == 1) return true;
            if (set.contains(sum)) return false;
            set.add(sum);
        }
        return true;
    }
    
    private long getSum(long sum) {
        long result = 0;
        while (sum != 0) {
            result += (sum % 10) * (sum % 10);
            sum /= 10;
        }
        return result;
    }
}