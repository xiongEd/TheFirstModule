package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
你有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。

我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。

示例 1:

输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
输出: [20,24]
解释:
列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
注意:

给定的列表可能包含重复元素，所以在这里升序表示 >= 。
1 <= k <= 3500
-105 <= 元素的值 <= 105
对于使用Java的用户，请注意传入类型已修改为List<List<Integer>>。重置代码模板后可以看到这项改动。
 */
public class Solution632__ex {
    public static int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();
        int[] res = {nums.get(0).get(0), nums.get(0).get(0)}, index = new int[n], temp = new int[4];
        if (n == 1) return res;
        Arrays.fill(index, 0);
        int count = Integer.MAX_VALUE;
        boolean Ret = true;
        while (GetMaxAndMin(nums, index, temp)){
            System.out.println("Min: " + temp[0] + "   Min Index: " + temp[1] + "   Max: " + temp[2] + "   Max Index: " + temp[3]);
            if (temp[2] - temp[0] < count){
                res[0] = temp[0];
                res[1] = temp[2];
                count = temp[2] - temp[0];
            }
            index[temp[1]] ++;
        }
        return res;
    }

    private static boolean GetMaxAndMin(List<List<Integer>> nums, int[] index, int[] temp){
        temp[0] = Integer.MAX_VALUE;
        temp[2] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i ++){
            if (nums.get(i).size() == index[i])
                return false;

            if (nums.get(i).get(index[i]) < temp[0]){
                temp[0] = nums.get(i).get(index[i]);
                temp[1] = i;
            }

            if (nums.get(i).get(index[i]) > temp[2]){
                temp[2] = nums.get(i).get(index[i]);
                temp[3] = i;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[]a = {4,10,15,24,26}, b = {0,9,12,20}, c = {5,18,22,30};
        ArrayList<Integer> A = new ArrayList<Integer>();
        ArrayList<Integer> B = new ArrayList<Integer>();
        ArrayList<Integer> C = new ArrayList<Integer>();
        for (int temp: a){
            A.add(temp);
        }
        for (int temp: b){
            B.add(temp);
        }
        for (int temp: c){
            C.add(temp);
        }
        List<List<Integer>>res = new ArrayList<List<Integer>>();
        res.add(A);
        res.add(B);
        res.add(C);

        int []d = smallestRange(res);
        System.out.print("Result:  " + d[0] + "   ");
        System.out.println(d[1]);
    }
}
