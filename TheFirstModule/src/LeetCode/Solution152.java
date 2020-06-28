package LeetCode;
/*
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

 

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class Solution152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        int max, min, result, tempValue, simplicityMin;
        max = min = result = simplicityMin = Integer.MIN_VALUE;
        for (int temp : nums) {
            if (temp > 0) {
                if (max == simplicityMin) {
                    max = temp;
                } else {
                    max *= temp;
                }
                if (min != simplicityMin) {
                    min *= temp;
                }
            } else if (temp < 0) {
                tempValue = min;
                if (max == simplicityMin) {
                    min = temp;
                } else {
                    min = max * temp;
                }
                if (tempValue != simplicityMin) {
                    max = tempValue * temp;
                } else {
                    max = tempValue;
                }
            } else {
                max = min = simplicityMin;
                result = Math.max(result, 0);
            }
            result = Math.max(result, max);
        }
        return Math.max(result, max);
    }
}
