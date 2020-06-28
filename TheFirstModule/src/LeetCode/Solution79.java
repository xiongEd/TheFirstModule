package LeetCode;

import java.util.ArrayList;

/*
给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

 

示例:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
 

提示：

board 和 word 中只包含大写和小写英文字母。
1 <= board.length <= 200
1 <= board[i].length <= 200
1 <= word.length <= 10^3
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        char[] matrix = new char[rows * cols];
        char[]str = word.toCharArray();
        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j ++) {
                matrix[i * cols + j] = board[i][j];
            }
        }
        return hasPath(matrix, rows, cols, str);
    }

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[][] Gone = new boolean[rows][cols];
        char[][]Matrix = new char[rows][cols];
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int rowPos,colPos;
        for (int i = 0; i < rows; i ++){
            for (int j = 0; j < cols; j ++){
                Matrix[i][j] = matrix[i * cols + j];
                if (Matrix[i][j] == str[0]){
                    temp.add(i);
                    temp.add(j);
                }
            }
        }
        while (!temp.isEmpty()){
            rowPos = temp.remove(0);
            colPos = temp.remove(0);
            Gone[rowPos][colPos] = true;
            if (Function(Matrix, rowPos,colPos,str,1,Gone)){
                return true;
            }
            Gone[rowPos][colPos] = false;
        }
        return false;
    }

    public boolean Function(char[][] Matrix, int rowPos, int colPos,  char[]str, int count, boolean[][]Gone){
        if (count == str.length){
            return true;
        }

        Gone[rowPos][colPos] = true;

        int rows = Matrix.length, cols = Matrix[0].length;
        if (rowPos > 0 && !Gone[rowPos - 1][colPos]){
            if (Matrix[rowPos - 1][colPos] == str[count]){
                if(Function(Matrix, rowPos - 1, colPos, str, count + 1, Gone))
                    return true;
            }
        }

        if (rowPos < rows - 1 && !Gone[rowPos + 1][colPos]){
            if (Matrix[rowPos + 1][colPos] == str[count]){
                if(Function(Matrix, rowPos + 1, colPos, str, count + 1, Gone))
                    return true;
            }
        }

        if (colPos > 0 && !Gone[rowPos][colPos - 1]){
            if (Matrix[rowPos][colPos - 1] == str[count]){
                if(Function(Matrix, rowPos, colPos - 1, str, count + 1, Gone))
                    return true;
            }
        }

        if (colPos < cols - 1 && !Gone[rowPos][colPos + 1]){
            if (Matrix[rowPos][colPos + 1] == str[count]){
                if(Function(Matrix, rowPos, colPos + 1, str, count + 1, Gone))
                    return true;
            }
        }
        Gone[rowPos][colPos] = false;
        return false;
    }
}
