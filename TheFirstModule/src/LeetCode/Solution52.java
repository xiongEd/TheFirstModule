package LeetCode;

/*
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回 n 皇后不同的解决方案的数量。

示例:

输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class Solution52 {
    public int totalNQueens(int n) {
        int[] res = new int[1];
        char[][] temp = new char[n][n];
        for(int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                temp[i][j] = '.';
            }
        }
        boolean[] row = new boolean[n];
        boolean[] col = new boolean[n];
        boolean[] slash = new boolean[2 * n - 1];
        boolean[] backslash = new boolean[2 * n - 1];
        SolveFunc(temp,0,row,col,slash,backslash,res);
        return res[0];
    }
    public void SolveFunc(
                          char[][] temp,
                          int n,
                          boolean[] row,
                          boolean[] col,
                          boolean[] slash,
                          boolean[] backslash,
                          int[] res){
        int size = row.length;
        if(n == size){
            res[0] ++;
            return;
        }
        for(int i = 0; i < size;i++){
            if(row[n] || col[i] || slash[i + n] || backslash[n - i + size - 1])
                continue;
            temp[n][i] = 'Q';
            row[n] = !row[n];  col[i] = !col[i];  slash[i + n] = !slash[i + n];    backslash[n - i + size - 1] = !backslash[n - i + size - 1];
            SolveFunc(temp,n + 1,row,col,slash,backslash,res);
            row[n] = !row[n];  col[i] = !col[i];  slash[i + n] = !slash[i + n];    backslash[n - i + size - 1] = !backslash[n - i + size - 1];
            temp[n][i] = '.';
        }
    }
}
