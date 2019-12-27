package SwordRefersOffer;

import java.util.ArrayDeque;
import java.util.Queue;

/*
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Solution66 {
    public static int movingCount(int threshold, int rows, int cols)
    {
        int res = 0, rowPos, colPos, count;
        boolean[][]space = new boolean[rows][cols];
        boolean[][]Gone = new boolean[rows][cols];
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < rows; i ++){
            for (int j = 0; j < cols; j ++){
                if (GetCount(i,j) <= threshold){
                    space[i][j] = true;
                    System.out.print(1+" ");
                    continue;
                }
                System.out.print(0+" ");
            }
            System.out.println();
        }

        queue.add(0);
        queue.add(0);

        while (!queue.isEmpty()){

            rowPos = queue.poll();
            colPos = queue.poll();
            if (!Gone[rowPos][colPos]){
                if (space[rowPos][colPos])
                    res ++;
                else
                    continue;
                Gone[rowPos][colPos] = true;
                if (rowPos > 0 && !Gone[rowPos - 1][colPos]){
                    queue.add(rowPos - 1);
                    queue.add(colPos);
                }
                if (rowPos < rows - 1 && !Gone[rowPos + 1][colPos]){
                    queue.add(rowPos + 1);
                    queue.add(colPos);
                }
                if (colPos > 0 && !Gone[rowPos][colPos - 1]){
                    queue.add(rowPos);
                    queue.add(colPos - 1);
                }
                if (colPos < cols - 1 && !Gone[rowPos][colPos + 1]){
                    queue.add(rowPos);
                    queue.add(colPos + 1);
                }
            }
        }
        return res;
    }

    public static int GetCount(int x, int y){
        int result = 0;
        while (x != 0){
            result += x % 10;
            x /= 10;
        }
        while (y != 0){
            result += y % 10;
            y /= 10;
        }
        return result;
    }
}
