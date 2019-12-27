package SwordRefersOffer;

import java.util.ArrayList;

/*
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述:
对应每个测试案例，输出两个数，小的先输出。
 */
public class Solution42 {
    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer>res = new ArrayList<Integer>();
        int i = 1, j = array.length - 1, target;
        if (j <= 2) return res;
        target = sum - array[0];
        for (int loop = 1; loop < array.length; loop ++){
            if (target == array[loop]){
               res.add(array[0]);
               res.add(array[loop]);
               j = loop - 1;
               break;
            }
            if (target < array[loop]){
                j = loop - 1;
                break;
            }
        }

        while (j > i){
            target = array[i] + array[j];
            if(target < sum){
                i ++;
            }
            else if (target == sum){
                if (res.isEmpty()){
                    res.add(array[i]);
                    res.add(array[j]);
                }
                else {
                    if (array[i] * array [j] < res.get(0) * res.get(1)){
                        res.clear();
                        res.add(array[i]);
                        res.add(array[j]);
                    }
                }
                i ++;
                j --;
            }
            else {
                j --;
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[]a = {1,2,4,7,11,16};
        FindNumbersWithSum(a,17);
    }
}
