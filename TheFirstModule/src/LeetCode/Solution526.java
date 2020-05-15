package LeetCode;

import java.util.HashMap;
import java.util.Map;

/*
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

示例 1 :

输入:nums = [1,1,1], k = 2
输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
说明 :

数组的长度为 [1, 20,000]。
数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 */
public class Solution526 {
    public static int subarraySum(int[] nums, int k) {
        int result = 0, pre = 0;
        HashMap<Integer, Integer> preMap = new HashMap<>();
        preMap.put(0, 1);
        for (int num : nums) {
            pre += num;
            result += preMap.getOrDefault(pre - k, 0);
            preMap.put(pre, preMap.getOrDefault(pre, 0) + 1);

        }
        return result;
    }
}
