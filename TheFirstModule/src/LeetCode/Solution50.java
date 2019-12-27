package LeetCode;
/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class Solution50 {
    public double myPow(double x, int n) {
        if(x == 0)
            return 0;
        return PowFunc(x,n);
    }
    public double PowFunc(double x, int n){
        if(n == 1)
            return x;
        if(n == -1)
            return 1/x;
        if(n == 0)
            return 1;
        double temp = PowFunc(x,n/2);
        int mod = n % 2;
        if(mod == 1){
            return temp * temp * x;
        }
        else if(mod == -1){
            return temp * temp * (1/x);
        }
        else{
            return temp * temp;
        }
    }
}
