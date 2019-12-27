package LeetCode;
/*
 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

 */

public class Solution31 {
    public void nextPermutation(int[] nums) {
        int i, n = nums.length, flag = -1, temp;
        if (1 >= n) {
            return;
        }
        for (i = n - 1; i > 0; --i) {
            if (nums[i - 1] < nums[i]) {
                flag = i - 1;
                break;
            }
        }

        if (-1 == flag) {
            flag = 0;
            --n;
            while(true){
                if(flag  <  n){
                    temp = nums[flag];
                    nums[flag] = nums[n];
                    nums[n] = temp;
                    ++flag;
                    --n;
                }
                else{
                    return;
                }
            }
        }

        for (; i < n; ++i) {
            if (nums[i] <= nums[flag]) {
                break;
            }
        }

        temp = nums[flag];
        nums[flag] = nums[i - 1];
        nums[i - 1] = temp;

        while(true) {
            if(++flag < n--){
                temp = nums[flag];
                nums[flag] = nums[n];
                nums[n] = temp;
            }
            else {
                break;
            }
        }

        return;
    }
}
