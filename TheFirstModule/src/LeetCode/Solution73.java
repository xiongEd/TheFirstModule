package LeetCode;
/*
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。

示例 1:

输入:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
输出:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
示例 2:

输入:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
输出:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
进阶:

一个直接的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个常数空间的解决方案吗？
 */
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        boolean rowflag = false, colflag = false;

        //标记 0 行、0 列。同时设置matrix[0][0]的状态。
        for (int i = 0; i < matrix.length; i ++){
            for (int j = 0; j < matrix[i].length; j ++){
                if (matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if (i == 0) rowflag = true;
                    if (j == 0) colflag = true;
                }
            }
        }

        //将 matrix[1][1] 到 matrix[m][n] 根据标志位赋值
        for (int i = 1; i < matrix.length; i ++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        //处理第 0 行
        if (rowflag){
            for (int i = 1; i < matrix[0].length; i ++)
                matrix[0][i] = 0;
        }

        //处理第 0 列
        if (colflag){
            for (int i = 1; i < matrix.length; i ++){
                matrix[i][0] = 0;
            }
        }
    }
}
