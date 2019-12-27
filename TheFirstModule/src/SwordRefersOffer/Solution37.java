package SwordRefersOffer;
/*
统计一个数字在排序数组中出现的次数。
 */
public class Solution37 {
    public int GetNumberOfK(int [] array , int k) {
        int count = 0;
        for(int temp : array){
            if(temp < k)
                continue;
            else if (temp == k)
                count ++;
            else
                break;
        }
        return count;
    }
}
