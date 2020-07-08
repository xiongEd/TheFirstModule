package LeetCode_SwordRefersOffer;
/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

 

示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4]
注：[3,1,2,4] 也是正确的答案之一。
 

提示：

1 <= nums.length <= 50000
1 <= nums[i] <= 10000
 */
public class SwordRefersOffer21_调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int[] result = new int[nums.length];
        int head = 0, tail = nums.length - 1;
        for (int temp : nums) {
            if ((temp & 1) == 1) {
                result[head++] = temp;
            } else {
                result[tail--] = temp;
            }
        }
        return result;
    }
    /*
    原地数字前后指针进行交换
    public int[] exchange(int[] nums) {
        if(nums.length == 0) return nums;
        int i = 0,j = nums.length-1;
        while(i != j){
            while(nums[i] %2 != 0 && i<j ){
                i++;
            }
            while(nums[j] %2 == 0 && i<j ){
                j--;
            }
            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
     */
}
