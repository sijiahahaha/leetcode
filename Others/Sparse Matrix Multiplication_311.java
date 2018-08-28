/**
Generally for the following equation:
C[ i ][ j ] = A[ i ][0]*B[0][j] + A[i][1]*B[1][j] + A[i][2]*B[2][j] + ... A[i][k]*B[k][j] .... A[i][K]*B[K][j]
j can be from 0 to nB, if we write all of them down, it will like following:
[For i from 0 to nB
C[ i ][ 0 ]=A[ i ][0]*B[0][0] + A[i][1]*B[1][0] + A[i][2]*B[2][0] + ... A[i][k]B[k][0] .... A[i][K]*B[K][0]
C[ i ][ 1 ]=A[ i ][0]*B[0][1] + A[i][1]*B[1][1] + A[i][2]*B[2][1] + ... A[i][k]B[k][0] .... A[i][K]*B[K][1]
...
C[ i ][ nB ]=A[ i ][0]*B[0][nB] + A[i][1]*B[1][nB] + A[i][2]*B[2][nB] + ... A[i][k]B[k][nB] .... A[i][K]*B[K][nB]

As you can see from above: for the same value A[i][k] from the first matrix, it will be used at most nB times if A[i][k] is not zero. And the smart solution is taking advantage of that!!!, the smart solution can be described as:

For each value A[i][k] in matrix A, if it is not zero, we calculate A[i][k] * B[k][j] and accumulate it into C[ i ][ j ] (Key part: the C[ i ][ j ] by now is not the final value in the result matrix !! Remember, in the brute force solution, the final value of C[i][j], takes sum of all multiplication values of K corresponding values from A and B? here C[ i ][ j ] is only sum of some multiplication values, NOT ALL until the program is done )


**/
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || B == null) {
            return null;
        }
        int m = A.length;
        int n = A[0].length; // n = B.length;
        int s = B[0].length;
        
        int[][] AB = new int[m][s];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < s; k++) {
                        AB[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return AB;
    }
}