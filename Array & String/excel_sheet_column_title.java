/**
  1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
**/

class Solution {
    public String convertToTitle(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Input is not valid!");
        }
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
        n--;
        char c = (char)(n % 26 + 'A');
        sb.append(c);
        n /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
