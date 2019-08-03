import java.util.Arrays;
class Solution {
    public static void sortColors(int[] A) {
        if (A == null || A.length == 0) {
            return;
        }

        int nred = 0, nblue = A.length - 1;
        while (nred < A.length && A[nred] == 0) {
            nred++;
        }
        while (nblue >= 0 && A[nblue] == 2) {
            nblue--;
        }

        int curr = nred;
        while (curr <= nblue) {
            if (A[curr] == 0) {
                swap(A, curr, nred);
                nred++;
                curr++;
            } else if (A[curr] == 2) {
                swap(A, curr, nblue);
                nblue--;
            } else {
                curr++;
            }
        }
    }

    private static void swap(int[] A, int left, int right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}