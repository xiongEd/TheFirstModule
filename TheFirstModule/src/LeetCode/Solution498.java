package LeetCode;
/*
给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。

 

示例:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

输出:  [1,2,4,7,5,3,6,8,9]

解释:

 

说明:

给定矩阵中的元素总数不会超过 100000 。
 */
public class Solution498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) return new int[0];
        int col = matrix[0].length, index = 0, x, y, flag = 1;
        int[] res = new int[row * col];
        for (int i = 0; i < row + col - 1; i ++) {
            if (flag == 1) {
                if (i > row - 1) {
                    y = i - row + 1;
                    x = row - 1;
                } else {
                    x = i;
                    y = 0;
                }
            } else {
                if (i > col - 1) {
                    x = i - col + 1;
                    y = col - 1;
                } else {
                    x = 0;
                    y = i;
                }
            }

            while (x >= 0 && y >= 0 && x < row && y < col) {
                res[index ++] = matrix[x][y];
                x -= flag;
                y += flag;
            }
            flag = -flag;
        }
        return res;
    }
}
