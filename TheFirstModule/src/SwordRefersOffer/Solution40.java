package SwordRefersOffer;

import java.util.Arrays;

/*
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class Solution40 {
    public void FindNumsAppearOnce(int [] array, int[] num1, int[] num2) {
        Arrays.sort(array);
        boolean flag = false;
        for(int i = 1; i < array.length; i += 2){
            if(array[i] != array[i - 1]){
                if(!flag){
                    num1[0] = array[i - 1];
                    flag = true;
                    i -= 1;
                }
                else {
                    num2[0] = array[i - 1];
                    return;
                }
            }
        }
        num2[0] = array[array.length - 1];
    }
}
