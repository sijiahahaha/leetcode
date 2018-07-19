/**
把一个m*n的矩阵旋转90度，给一个flag规定是向左转还是向右转

1. transpose
2. 根据flag，顺时针左右翻转(横着j只遍历一半就换完了)，逆时针上下翻转(竖着i只遍历一半就换完了)



int[2][4] matrix =>  [[a,b,c,d],   => [[a,b,c,d], [e,f,g,h]]
			         [e,f,g,h]]
matrix.length = 2, matrix[0].length = 4

**/

public static int[][] rotate(int[][] matrix, int flag) {
	int m = matrix.length;
	int n = matrix[0].length;
	//transpose
	int[][] trans = new int[n][m];
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			trans[j][i] = matrix[i][j];
		}
	}
	//flip
	if (flag == 1) {//clockwise
		for (int i = 0; i < n, i++) {
			for (int j = 0; j < m / 2; j++) {
				int temp = trans[i][j];
				trans[i][j] = trans[i][m-j-1];
				trans[i][m-j-1] = temp;
			}
		} else { //counterclockwise
			for (int i = 0; i < n / 2, i++) {
			for (int j = 0; j < m; j++) {
				int temp = trans[i][j];
				trans[i][j] = trans[n-i-1][j];
				trans[n-i-1][j] = temp;
			}
		}
	}

	return trans;
}