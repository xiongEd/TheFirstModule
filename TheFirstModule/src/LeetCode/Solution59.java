package LeetCode;
/*
给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 0;
        int start = 0;
        while (n > 0){
            if (n == 1){
                res[start][start] = ++count;
            }
            for (int i = 0; i < n - 1; i ++){
                res[start][start + i] = ++count;
            }
            for (int i = 0; i < n - 1; i ++){
                res[start + i][start + n - 1] = ++count;
            }
            for (int i = 0; i < n - 1; i ++){
                res[start + n - 1][start + n - 1 - i] = ++count;
            }
            for (int i = 0; i < n - 1; i ++){
                res[start + n - 1 - i][start] = ++count;
            }
            start ++;
            n -=2;
        }
        return res;
    }
}
