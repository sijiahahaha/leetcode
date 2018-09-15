/**

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3


root: 1                           2                         3
left: 由(1-1)个node构成BST f(0)    由(2-1)个node构成BST f(1)   由(3-1)个node构成BST f(2)
right 由(n-1)个node构成BST f(2)    由(n-2)个node构成BST f(1)   由(n-3)个node构成BST f(0)

root = (left) * (right)
f(3) = f(0) * f(2) + f(1)*f(1) + f(2)*f(0)
f(n) = f(0) * f(n-1) + f(1)*f(n-2) + ... + f(n-1)*f(0)

**/
class Solution {
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                f[i] += f[j] * f[i - j - 1];
            }
        }
        return f[n];
    }
}