package LeetCode;
/*
实现 int sqrt(int x) 函数。

计算并返回 x 的平方根，其中 x 是非负整数。

由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:

输入: 4
输出: 2
示例 2:

输入: 8
输出: 2
说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。
 */
public class Solution69 {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        int min = 0, max = x, mid;
        while (min < max){
            mid = (min + max) / 2;

            if (mid == 0) return 1;

            if (x / mid < mid){
                max = mid - 1;
            }
            else if (x / mid == mid)
                return mid;
            else {
                min = mid + 1;
            }
        }
            return max;
        /*
        double temp = 0;
        int count = 0;
        int res = count;
        while (temp <= x){
            res = count ++;
            temp = (double)count * count;
        }
        return res;
     */
    }
}
