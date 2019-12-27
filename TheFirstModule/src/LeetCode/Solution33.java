package LeetCode;
/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
*/
public class Solution33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n > 0) {
            return MySerch(nums, 0, n - 1, target);
        }
        return -1;
    }

    public int MySerch(int[] nums, int left, int right, int target){
        int mid = (left + right)/2;
        if(target > nums[left]){
            if(nums[mid] > nums[left]){
                if(target < nums[mid]){
                    return twofenSerch(nums, left, mid - 1, target);
                }
                else if(target > nums[mid]){
                    return MySerch(nums, mid + 1, right, target);
                }
                else{
                    return mid;
                }
            }
            else if(nums[mid] < nums[left]){
                return MySerch(nums, left, right - 1, target);
            }
            else{
                if(right == left) {
                    return -1;
                }
                else{
                    if(nums[right] == target){
                        return right;
                    }
                    else{
                        return -1;
                    }
                }
            }
        }
        else if(target < nums[left]){
            if(nums[mid] < nums[left]){
                if(target > nums[mid]){
                    return twofenSerch(nums, mid + 1, right, target);
                }
                else if(target < nums[mid]){
                    return MySerch(nums, left, mid - 1, target);
                }
                else{
                    return mid;
                }
            }
            else if(nums[mid] > nums[left]){
                return MySerch(nums, mid + 1, right, target);
            }
            else{
                if(right == left) {
                    return -1;
                }
                else{
                    if(nums[right] == target){
                        return right;
                    }
                    else{
                        return -1;
                    }
                }
            }
        }
        else{
            return left;
        }
    }

    public int twofenSerch(int[] nums, int left, int right, int target){
        int mid;
        while(left <= right){
            mid = (left + right)/2;
            if(target > nums[mid]){
                left = mid + 1;
                continue;
            }
            else if(target < nums[mid]){
                right = mid - 1;
                continue;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
