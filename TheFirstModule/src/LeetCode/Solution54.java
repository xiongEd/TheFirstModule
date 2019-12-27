package LeetCode;
import java.util.*;
/*
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer>res = new ArrayList<Integer>();
        int row = matrix.length;
        if(row == 0)
            return res;
        int col = matrix[0].length,index = 0,i;
        while(row >= 2 && col >= 2){
            for(i = index; i < index + col - 1;i ++)
                res.add(matrix[index][i]);
            for(i = index;i < index + row - 1; i ++)
                res.add(matrix[i][index + col - 1]);
            for(i = index + col - 1; i > index; i --)
                res.add(matrix[index + row - 1][i]);
            for(i = index + row - 1; i > index; i --)
                res.add(matrix[i][index]);
            index ++;
            row -= 2;
            col -= 2;
        }
        if(row == 1 && col != 0){
            for(i = index; i < index + col;i++)
                res.add(matrix[index][i]);
            row = 0;col = 0;
        }
        if(col == 1 && row != 0){
            for(i = index; i < index + row; i++)
                res.add(matrix[i][index]);
        }
        return res;
    }
}
