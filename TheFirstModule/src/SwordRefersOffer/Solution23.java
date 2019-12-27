package SwordRefersOffer;

import java.util.Arrays;

/*
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution23 {
    private boolean VerifySquenceOfBST(int[] sequence) {
        int n = sequence.length;
        if(n == 0) return false;
        int count = 0;
        Boolean flag1,flag2;
        int[] temp1 ;
        int[] temp2 ;
        while(sequence[count] < sequence[n - 1]){
            count ++;
        }
        if(count == 0)
            flag1 = true;
        else
            flag1 = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, count));

        if(n - 1 - count == 0)
            flag2 = true;
        else
            flag2 = VerifySquenceOfBST(Arrays.copyOfRange(sequence, count, n - 1));

        while(count  < n - 1){
            if(sequence[count] <= sequence[n - 1]){
                return false;
            }
            count ++;
        }
        return flag1 && flag2;
    }
}
