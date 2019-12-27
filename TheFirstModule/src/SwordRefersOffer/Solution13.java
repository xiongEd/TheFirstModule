package SwordRefersOffer;
/*
输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution13 {
    public void reOrderArray(int [] array) {
        int count = 0, temp;
        for(int i = 0; i < array.length; i++){
            if((array[i] & 1) == 1){
                temp = array[i];
                for(int j = i; j > count; j--){
                    array[j] = array[j - 1];
                }
                array[count ++] = temp;
            }
        }
    }
}
