package LeetCode_SwordRefersOffer;

import java.util.ArrayDeque;
import java.util.Queue;

/*
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

 

示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20
 */
public class SwordRefersOffer13_机器人的运动范围 {
    public int movingCount(int m, int n, int k)
    {
        int res = 0, rowPos, colPos, count;
        boolean[][]space = new boolean[m][n];
        boolean[][]Gone = new boolean[m][n];
        Queue<Integer> queue = new ArrayDeque<Integer>();
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                if (GetCount(i,j) <= k){
                    space[i][j] = true;
                    continue;
                }
            }
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
                if (rowPos < m - 1 && !Gone[rowPos + 1][colPos]){
                    queue.add(rowPos + 1);
                    queue.add(colPos);
                }
                if (colPos > 0 && !Gone[rowPos][colPos - 1]){
                    queue.add(rowPos);
                    queue.add(colPos - 1);
                }
                if (colPos < n - 1 && !Gone[rowPos][colPos + 1]){
                    queue.add(rowPos);
                    queue.add(colPos + 1);
                }
            }
        }
        return res;
    }

    public int GetCount(int x, int y){
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
