package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
给定一个未排序的整数数组，找出最长连续序列的长度。

要求算法的时间复杂度为 O(n)。

示例:

输入: [100, 4, 200, 1, 3, 2]
输出: 4
解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        int result = 0, curlen, next;
        Set<Integer> set = new HashSet<>();
        for (int temp : nums) {
            set.add(temp);
        }

        for (int key : set) {
            if (set.contains(key - 1)) {
                continue;
            }
            next = key + 1;
            curlen = 1;
            while (set.contains(next)) {
                curlen ++;
                next += 1;
            }
            result = Math.max(result, curlen);
        }
        return result;
    }
}
