package LeetCode;
/*
给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。

示例:

输入:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
输出: 6
 */
public class Solution85 {
    private static void printf(int[][]ints){
        for (int[] a: ints){
            for (int b: a){
                System.out.print(b + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        if (row == 0 || matrix[0].length == 0)
            return 0;
        int col = matrix[0].length;
        int basic = 1, res = 0, sum;
        boolean flag = true;
        boolean[][] array = new boolean[row][col];

        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j ++){
                array[i][j] = matrix[i][j] == '1';
            }
        }

        while (flag){
            //printf(array);
            flag = false;
            for (int i = 0; i < row; i ++){
                sum = 0;
                for (int j = 0; j < col; j ++){
                    if (array[i][j]) {
                        if (j == 0 || !array[i][j - 1]) {
                            sum = basic * basic;
                            res = Math.max(sum, res);
                            continue;
                        }
                        sum += basic;
                        res = Math.max(sum, res);
                    }
                }
            }

            for (int i = 0; i < col; i ++){
                sum = 0;
                for (int j = 0; j < row; j ++){
                    if (array[j][i]) {
                        if (j == 0 || !array[j - 1][i]) {
                            sum = basic * basic;
                            res = Math.max(sum, res);
                            continue;
                        }
                        sum += basic;
                        res = Math.max(sum, res);
                    }
                }
            }

            for (int i = row - 1; i >= 0; i --){
                for (int j = col - 1; j >= 0; j --){
                    if (i == 0 || j == 0){
                        array[i][j] = false;
                        continue;
                    }
                    if (array[i][j] && array[i - 1][j - 1] && array[i - 1][j] && array[i][j - 1]){
                        flag = true;
                    } else {
                        array[i][j] = false;
                    }
                }
            }
            basic ++;
        }
        return res;
    }

    public static void main(String[] args) {
        char[][] a =  { {'1','0','1','1','0','1','0'},
                        {'1','0','0','1','0','1','1'},
                        {'0','1','1','1','1','1','1'},
                        {'1','1','1','1','1','1','1'},
                        {'1','0','1','1','1','0','1'},
                        {'0','1','1','1','1','0','0'},
                        {'0','0','1','0','1','0','1'}};
        System.out.println("result: " + maximalRectangle(a));
    }
}
