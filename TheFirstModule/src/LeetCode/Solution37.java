package LeetCode;
/*
编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。



一个数独。



答案被标成红色。

Note:

给定的数独序列只包含数字 1-9 和字符 '.' 。
你可以假设给定的数独只有唯一解。
给定数独永远是 9x9 形式的。
 */
public class Solution37 {
    public static void solveSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] boxes = new int[9];
        char temp;
        int arr, index, bin;
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j) {
                temp = board[i][j];
                if (temp != '.') {
                    arr = temp - '0';
                    index = j / 3 + (i / 3) * 3;
                    bin = 1 << arr;
                    rows[i] += bin;
                    columns[j] += bin;
                    boxes[index] += bin;
                }
            }
        solveFunction(board, rows,columns,boxes);
    }

    public static boolean solveFunction(char[][] board, int[] rows, int[] columns, int[] boxes){
        int i,j,k = 0,index,arr;
        for (i = 0; i < 9; ++i)
            for (j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    index = j / 3 + (i / 3) * 3;
                    arr = rows[i] | columns[j] | boxes[index];
                    arr = ((~arr) >> 1) & 511;
                   while(arr > 0){
                       ++k;
                        if(arr % 2 == 1){
                            board[i][j] = (char)(k + '0');
                            rows[i] += 1 << k;
                            columns[j] += 1 << k;
                            boxes[index] += 1 << k;
                            if(true == solveFunction(board,rows,columns,boxes)){
                                return true;
                            }
                            rows[i] -= 1 << k;
                            columns[j] -= 1 << k;
                            boxes[index] -= 1 << k;
                            board[i][j] = '.';
                        }
                        arr /= 2;
                    }
                   return false;
                }
            }
        return true;
    }

    public static void main(String[] args){
        char[][]a = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku(a);
        int temp;
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                temp = (int)(a[i][j] - '0');
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
