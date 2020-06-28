package LeetCode_SwordRefersOffer;

import java.util.ArrayList;
import java.util.Arrays;

/*
Solution79
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

 

示例 1：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：

输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false
提示：

1 <= board.length <= 200
1 <= board[i].length <= 200
 */
public class SwordRefersOffer12_矩阵中的路径 {
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
