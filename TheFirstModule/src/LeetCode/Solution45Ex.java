package LeetCode;

public class Solution45Ex {
    public static int jump(int[] nums) {
        if(nums.length < 2)
            return 0;
        int temp,last = 0,next = 0, count = 0,cur;
        while (next < nums.length - 1){
            cur = next;
            for(; last <= cur; last ++){
                temp = nums[last] + last;
                next = temp > next ? temp : next;
            }
            count ++ ;
        }
        return count;
    }
}
