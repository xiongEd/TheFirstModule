package LeetCode;
/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int target_left, target_right;
        int n = nums.length - 1;
        int left = 2 * target - 1;
        int right = 2 * target + 1;

        int head = 0, end = n, mid;
        while (head <= end) {
            mid = (head + end) / 2;
            if (left > 2 * nums[mid]) {
                head = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        target_left = head;

        head = 0;
        end = n;
        while (head <= end) {
            mid = (head + end) / 2;
            if (right > 2 * nums[mid]) {
                head = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        target_right = end;

        if(target_left <= target_right){
            res[0] = target_left;
            res[1] = target_right;
        }
        return res;
    }
}

