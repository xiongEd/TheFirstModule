package LeetCode;
/*
给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

示例 1:

输入: [1,12,-5,-6,50,3], k = 4
输出: 12.75
解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 

注意:

1 <= k <= n <= 30,000。
所给数据范围 [-10,000，10,000]。
 */
public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        double max;
        int[] sum = new int[nums.length];
        int temp = 0;

        for (int i = 0; i < nums.length; i ++){
            temp += nums[i];
            sum[i] = temp;
        }

        max = sum[k - 1];
        for (int i = k; i < nums.length; i ++){
            max = Math.max(max, sum[i] - sum[i - k]);
        }
        return max / k;
    }
}
