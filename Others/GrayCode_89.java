/**
000
001
011
010

110
111
101
100
**/

public class Solution {
    /**
     * @param n: a number
     * @return: Gray code
     */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(0);
            return result;
        }
        if (n == 1) {
            result.add(0);
            result.add(1);
            return result;
        }
        
        List<Integer> half = grayCode(n - 1);
        ArrayList<Integer> rev = reverse(half);
        int bit = 1 << (n - 1);
        for (int i = 0; i < rev.size(); i++) {
            rev.set(i, rev.get(i) + bit);
        }
        result.addAll(half);
        result.addAll(rev);
        
        return result;
        
    }
    
    private ArrayList<Integer> reverse(List<Integer> half) {
        ArrayList<Integer> rev = new ArrayList<>();
        for (int i = 0; i < half.size(); i++) {
            rev.add(half.get(half.size() - i - 1));
        }
        return rev;
    }
}