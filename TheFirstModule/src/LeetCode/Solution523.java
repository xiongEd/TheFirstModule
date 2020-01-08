package LeetCode;

import java.util.HashMap;

/*
给定一个包含非负数的数组和一个目标整数 k，编写一个函数来判断该数组是否含有连续的子数组，其大小至少为 2，总和为 k 的倍数，即总和为 n*k，其中 n 也是一个整数。

示例 1:

输入: [23,2,4,6,7], k = 6
输出: True
解释: [2,4] 是一个大小为 2 的子数组，并且和为 6。
示例 2:

输入: [23,2,6,4,7], k = 6
输出: True
解释: [23,2,6,4,7]是大小为 5 的子数组，并且和为 42。
说明:

数组的长度不会超过10,000。
你可以认为所有数字总和在 32 位有符号整数范围内。
 */
public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) return false;
        if (k < 0) k = -k;
        HashMap<Integer, Integer>hashMap = new HashMap<Integer, Integer>();
        hashMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < n; i ++){
            sum += nums[i];
            if (k > 0)
                sum = sum % k;
            if (hashMap.containsKey(sum)){
                if (i - hashMap.get(sum) > 1)
                    return true;
            }else {
                hashMap.put(sum, i);
            }
        }
        return false;
    }
}
