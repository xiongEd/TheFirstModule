package LeetCode;
/*
给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1
 */
public class Solution41 {
    private static int firstMissingPositive(int[] nums) {
        int looptime,len = nums.length,temp;
        boolean zero = false;
        for(looptime = 0; looptime < len; ++ looptime){
            if(nums[looptime] == 1){
                zero = true;
            }
            if(nums[looptime] > len || nums[looptime] <= 0){
                nums[looptime] = 1;
            }
        }

        if(!zero){
            return 1;
        }

        for(looptime = 0; looptime < len; ++ looptime){
            temp = Math.abs(nums[looptime]) - 1;
            if(nums[temp] > 0)
            nums[temp] *= -1;
        }


        for(looptime = 0; looptime < len; ++ looptime){
            if(nums[looptime] > 0){
                return looptime + 1;
            }
        }
        return len + 1;
    }

    public static void main(String[] args){
        int[]a = {3,4,-1,1};
        System.out.println(firstMissingPositive(a));
    }
}
