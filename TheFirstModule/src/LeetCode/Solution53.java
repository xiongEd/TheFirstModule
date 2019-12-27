package LeetCode;
/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
进阶:

如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Solution53 {
    public int maxSubArray(int[] nums) {
        int val = 0,sum = nums[0],max = Integer.MIN_VALUE;
        for(int temp : nums){
            if(temp < 0)
                max = max < temp ? temp : max;
            val += temp;
            if(val >= 0){
                sum = sum > val ? sum : val;
            }
            else{
                val = 0;
            }
        }
        if(sum < 0)
            return max;
        return sum;
    }
}
