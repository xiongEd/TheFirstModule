package LeetCode;

import java.util.Arrays;

/*
给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。

如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。

请注意，答案不一定是 arr 中的数字。

 

示例 1：

输入：arr = [4,9,3], target = 10
输出：3
解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
示例 2：

输入：arr = [2,3,5], target = 10
输出：5
示例 3：

输入：arr = [60864,25176,27249,21296,20204], target = 56803
输出：11361
 

提示：

1 <= arr.length <= 10^4
1 <= arr[i], target <= 10^5
 */
public class Solution1300 {
    public int findBestValue(int[] arr, int target) {
        int min = 0, max = arr.length - 1, mid, temp;
        int[] res = {-1, 0};
        int[] sums = new int[arr.length];
        int count = 0;

        //排序并构造累加数组
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i ++){
            count += arr[i];
            sums[i] = count;
        }

        //目标值小于数组最小值时
        if (arr[0] * arr.length > target){
            count = target / arr.length;
            return target - count * arr.length < (count + 1) * arr.length - target ? count : count + 1;
        }

        //目标值大于数组最大值时
        if (sums[arr.length - 1] < target)
            return arr[arr.length - 1];

        //二分法找出数组中最接近目标组的两个数
        while (min <= max){
            mid = (min + max) / 2;
            count = sums[mid] + (arr.length - 1 - mid) * arr[mid];
            temp = Math.abs(count - target);

            if (res[0] == -1){
                res[0] = mid;
                res[1] = temp;
            } else {
                if (temp < res[1]){
                    res[0] = mid;
                    res[1] = temp;
                } else if (temp == res[1]){
                    res[0] = Math.min(res[0], mid);
                }
            }

            if (count > target){
                max = mid - 1;
            } else if (count < target){
                min = mid + 1;
            } else {
                return arr[mid];
            }
        }

        //数据处理，准备再次二分查找
        temp = min;
        min = arr[max];
        max = arr[temp --];
        res[0] = arr[res[0]];

        //二分法在第一次二分找到了两个数组树之间找到目标值
        while (min <= max){
            mid = (min + max) / 2;
            count = sums[temp] + mid * (arr.length - 1 - temp);

            if (Math.abs(count - target) < res[1]){
                res[0] = mid;
                res[1] = Math.abs(count - target);
            } else if (Math.abs(count - target) == res[1]){
                res[0] = Math.min(res[0], mid);
            }

            if (count > target){
                max = mid - 1;
            } else if (count < target){
                min = mid + 1;
            } else {
                return mid;
            }
        }

        return res[0];
    }
}
