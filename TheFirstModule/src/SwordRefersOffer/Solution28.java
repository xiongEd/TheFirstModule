package SwordRefersOffer;

import java.util.Arrays;

/*
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int temp = array[array.length/2], count = 0;
        for(int a : array){
            if(a == temp)
                count ++;
        }
        if(count > array.length/2)
            return temp;
        return 0;
    }
}
