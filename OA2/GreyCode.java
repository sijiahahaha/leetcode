/**  
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.


**/
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0; i< 1<<n; i++){
            result.add(i^ i>>1);
        }
        return result;
    }
}