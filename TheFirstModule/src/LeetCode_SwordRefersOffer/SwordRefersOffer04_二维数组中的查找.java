package LeetCode_SwordRefersOffer;
/*
Solution240
在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 

示例:

现有矩阵 matrix 如下：

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。

给定 target = 20，返回 false。

 

限制：

0 <= n <= 1000

0 <= m <= 1000
 */
public class SwordRefersOffer04_二维数组中的查找 {
    public boolean findNumberIn2DArray(int [][] matrix, int target) {
        int row = matrix.length;
        if(row == 0)
            return false;
        int low = matrix[0].length;
        int y = 0,x = row - 1;
        while(x >= 0 && y < low){
            if(target > matrix[x][y])
                y ++;
            else if(target < matrix[x][y])
                x --;
            else
                return true;
        }
        return false;
    }
}
