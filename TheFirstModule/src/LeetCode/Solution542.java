package LeetCode;
/*
给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。

示例 1:
输入:

0 0 0
0 1 0
0 0 0
输出:

0 0 0
0 1 0
0 0 0
示例 2:
输入:

0 0 0
0 1 0
1 1 1
输出:

0 0 0
0 1 0
1 2 1
注意:

给定矩阵的元素个数不超过 10000。
给定矩阵中至少有一个元素是 0。
矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 */
public class Solution542 {
    public int[][] updateMatrix(int[][] matrix) {
        boolean flag = true;
        int row = matrix.length;
        if (row < 1) return matrix;
        int col = matrix[0].length;
        int count = 0;

        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++) {
                if (matrix[i][j] == 1)
                    matrix[i][j] = row + col;
            }
        }
        while (flag){
            flag = false;
            for (int i = 0; i < row; i ++){
                for (int j = 0; j < col; j ++){
                    if (matrix[i][j] == count){
                        if (i > 0 && count + 1 < matrix[i - 1][j]){
                            matrix[i - 1][j] = count + 1;
                            flag = true;
                        }
                        if (j > 0 && count + 1 < matrix[i][j - 1]){
                            matrix[i][j - 1] = count + 1;
                            flag = true;
                        }
                        if (i < row - 1 && count + 1 < matrix[i + 1][j]){
                            matrix[i + 1][j] = count + 1;
                            flag = true;
                        }
                        if (j < col -1 && count + 1 < matrix[i][j + 1]){
                            matrix[i][j + 1] = count + 1;
                            flag = true;
                        }
                    }
                }
            }
            count ++;
        }
        return matrix;
    }
}
