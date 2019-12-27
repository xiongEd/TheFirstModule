package SwordRefersOffer;

/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */

import java.util.ArrayList;

public class Solution65 {
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
