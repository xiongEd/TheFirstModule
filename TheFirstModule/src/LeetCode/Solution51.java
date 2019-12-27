package LeetCode;
import java.util.*;
/*
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。
 */
public class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
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
        SolveFunc(res,temp,0,row,col,slash,backslash);
        return res;
    }
    public void SolveFunc(List<List<String>> res,
                             char[][] temp,
                             int n,
                             boolean[] row,
                             boolean[] col,
                             boolean[] slash,
                             boolean[] backslash){
        int size = row.length;
        if(n == size){
            List<String> List = new ArrayList<String>();
            for(int i = 0; i < size; i ++){
                List.add(new String(temp[i]));
            }
            res.add(List);
            return;
        }
        for(int i = 0; i < size;i++){
            if(row[n] || col[i] || slash[i + n] || backslash[n - i + size - 1])
                continue;
            temp[n][i] = 'Q';
            row[n] = !row[n];  col[i] = !col[i];  slash[i + n] = !slash[i + n];    backslash[n - i + size - 1] = !backslash[n - i + size - 1];
            SolveFunc(res,temp,n + 1,row,col,slash,backslash);
            row[n] = !row[n];  col[i] = !col[i];  slash[i + n] = !slash[i + n];    backslash[n - i + size - 1] = !backslash[n - i + size - 1];
            temp[n][i] = '.';
        }
    }
}
