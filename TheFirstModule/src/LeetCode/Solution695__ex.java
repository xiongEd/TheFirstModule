package LeetCode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。

找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)

示例 1:

[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。

示例 2:

[[0,0,0,0,0,0,0,0]]
对于上面这个给定的矩阵, 返回 0。

注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 */
public class Solution695__ex {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] temp = new int[grid.length][grid[0].length];
        Queue<Integer> queue = new ArrayDeque<Integer>();
        int res = 0, count, m, n;
        for (int i = 0; i < grid.length; i ++){
            for (int j = 0; j < grid[0].length; j ++){
                if (grid[i][j] == 1 && temp[i][j] == 0){
                    count = 1;
                    queue.add(i);
                    queue.add(j);
                    temp[i][j] = 1;
                    while (!queue.isEmpty()){
                        m = queue.poll();
                        n = queue.poll();
                        if (m > 0 && grid[m - 1][n] != 0 && temp[m - 1][n] == 0){
                            temp[m - 1][n] = 1;
                            queue.add(m - 1);
                            queue.add(n);
                            count ++;
                        }
                        if (n > 0 && grid[m][n - 1] != 0 && temp[m][n - 1] == 0){
                            temp[m][n - 1] = 1;
                            queue.add(m);
                            queue.add(n - 1);
                            count ++;
                        }
                        if (m < grid.length - 1 && grid[m + 1][n] != 0 && temp[m + 1][n] == 0){
                            temp[m + 1][n] = 1;
                            queue.add(m + 1);
                            queue.add(n);
                            count ++;
                        }
                        if (n < grid[0].length - 1 && grid[m][n + 1] != 0 && temp[m][n + 1] == 0){
                            temp[m][n + 1] = 1;
                            queue.add(m);
                            queue.add(n + 1);
                            count ++;
                        }
                    }

                    res = Math.max(res, count);
                }
            }
        }
        return res;
    }
}
