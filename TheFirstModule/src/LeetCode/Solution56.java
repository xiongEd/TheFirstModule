package LeetCode;

import java.util.*;

/*
给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class Solution56 {

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

    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n < 2) return intervals;
        int[] order = {0, 1};
        sort(intervals, order);
        List<Integer>temp = new ArrayList<Integer>();
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

    public static void main(String[] args) {
        int[][] res = {{1,3},{2,-1},{1,-2},{15,18},{8,10},{1,2},{3,7},{1,6},{-6, 1}};
        int[] order = {0,1};
        sort(res, order);
        for (int[] a:res){
            for (int b: a){
                System.out.print(b + "  ");
            }
            System.out.println();
        }

    }
}
