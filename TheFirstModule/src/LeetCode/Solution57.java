package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
给出一个无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例 1:

输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
输出: [[1,5],[6,9]]
示例 2:

输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出: [[1,2],[3,10],[12,16]]
解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class Solution57 {
    private static void sort(int[][] ob, final int[] order) {
        Arrays.sort(ob, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int k : order) {
                    if (o1[k] > o2[k]) {
                        return 1;
                    } else if (o1[k] < o2[k]) {
                        return -1;
                    }
                }
                return 0;
            }
        });
    }

    private static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) return intervals;
        int[] order = {0, 1};
        sort(intervals, order);
        List<Integer> temp = new ArrayList<Integer>();
        int last = intervals[0][0];
        temp.add(last);
        for (int[] interval : intervals) {
            if (interval[0] == last) {
                last = interval[1];
            } else if (interval[0] < last) {
                last = Math.max(last, interval[1]);
            } else {
                temp.add(last);
                temp.add(interval[0]);
                last = interval[1];
            }
        }
        temp.add(last);

        int[][]res = new int[temp.size()/2][2];
        for (int i = 0; i < temp.size(); i ++){
            res[i / 2][i % 2] = temp.get(i);
        }
        return res;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][]res = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i ++){
            res[i][0] = intervals[i][0];
            res[i][1] = intervals[i][1];
        }
        res[intervals.length][0] = newInterval[0];
        res[intervals.length][1] = newInterval[1];

        return merge(res);
    }
}
