package LeetCode;
/*
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class Solution45 {
    public static int jump(int[] nums) {
        if(nums.length < 2)
            return 0;
        int[]res = new int[nums.length];
        int temp;

        for(int i = 0; i < nums.length; i ++ ){
            temp = res[i];
            for(int j = nums[i]; j >= 1; j -- ){
                if(i + j < nums.length - 1){
                    if(res[i + j] == 0){
                        res[i + j] = temp + 1;
                    }
                    else{
                        res[i + j] = temp + 1 < res[i + j] ? temp + 1 : res[i + j];
                    }
                }
                else {
                    return temp + 1;
                }
            }
        }
        return res[nums.length - 1];
    }

    public static void main(String[] args){
        int[]a = {2,3,1,1,4};
        System.out.println(jump(a));
    }
}
