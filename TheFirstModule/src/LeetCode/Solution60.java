package LeetCode;

import java.util.ArrayList;
import java.util.List;

/*
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。

说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:

输入: n = 3, k = 3
输出: "213"
示例 2:

输入: n = 4, k = 9
输出: "2314"
 */
public class Solution60 {
    public String getPermutation(int n, int k) {
        k -= 1;
        int[] ints = new int[n];
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> integers = new ArrayList<Integer>();

        for (int i = 1; i <= n; i ++){
            integers.add(i);
        }

        for (int i = 1; i <= n; i ++){
            count *= i;
            ints[n - i] = count;
        }

        if (k < 0 || k > ints[0] - 1)
            return stringBuilder.toString();

        for (int i = 1; i < n; i ++){
            stringBuilder.append(integers.remove(k/ints[i]));

            k = k % ints[i];
        }
        stringBuilder.append(integers.remove(0));

        return stringBuilder.toString();
    }
}
