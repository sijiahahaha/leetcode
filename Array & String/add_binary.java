class Solution {
    public String addBinary(String a, String b) {
        if (a == null) return b;
        if (b == null) return a;
        int ap = a.length() - 1;
        int bp = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (ap >= 0 || bp >= 0) {
            int sum = carry;
            if (ap >= 0) sum += a.charAt(ap--) - '0';
            if (bp >= 0) sum += b.charAt(bp--) - '0';
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.insert(0, carry % 2);
        return sb.toString();
    }
}
