package SwordRefersOffer;
/*
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution9 {
    private int JumpFloorII(int target) {
        if (target == 0)
            return 1;
        else{
            int temp = 0;
            for(int i = 0; i < target; i++)
                temp += JumpFloorII(i);
            return temp;
        }
    }
}
