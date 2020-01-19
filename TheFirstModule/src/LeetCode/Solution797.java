package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给一个有 n 个结点的有向无环图，找到所有从 0 到 n-1 的路径并输出（不要求按顺序）

二维数组的第 i 个数组中的单元都表示有向图中 i 号结点所能到达的下一些结点（译者注：有向图是有方向的，即规定了a→b你就不能从b→a）空就是没有下一个结点了。

示例:
输入: [[1,2], [3], [3], []]
输出: [[0,1,3],[0,2,3]]
解释: 图是这样的:
0--->1
|    |
v    v
2--->3
这有两条路: 0 -> 1 -> 3 和 0 -> 2 -> 3.
提示:

结点的数量会在范围 [2, 15] 内。
你可以把路径以任意顺序输出，但在路径内的结点的顺序必须保证。
 */
public class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int length = graph.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<List<Integer>> accessibility = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        for (int i = 0; i < graph.length; i ++) {
            accessibility.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < graph.length; i ++) {
            for (int b: graph[i]) {
                accessibility.get(b).add(i);
            }
        }
        temp.add(graph.length - 1);
        SolveFunction(accessibility, temp, res);
        return res;
    }

    private void SolveFunction (List<List<Integer>> accessibility, List<Integer> temp, List<List<Integer>> res) {
        for (int a: accessibility.get(temp.get(temp.size() - 1))) {
            if (a != 0) {
                temp.add(a);
                SolveFunction(accessibility, temp, res);
                temp.remove(temp.size() - 1) ;
            } else {
                List<Integer> result = new ArrayList<Integer>();
                result.add(0);
                for (int i = temp.size() - 1; i >= 0; i --) {
                    result.add(temp.get(i));
                }
                res.add(result);
            }
        }
    }
}
