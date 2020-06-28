package LeetCode_SwordRefersOffer;
/*
求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

 

示例 1：

输入: n = 3
输出: 6
示例 2：

输入: n = 9
输出: 45
 

限制：

1 <= n <= 10000
 */
public class SwordRefersOffer64_求1加2加n {
    int num = 0;
    public int sumNums(int n) {
        num = n;
        return (n + sqare(n)) >> 1;
    }
    private int sqare(int n) {
        int res = 0, temp = 0;
        boolean x = n > 1 && (res = sqare(n >> 1)) > 0;
        boolean y = ((n & 1) > 0) && (temp = num) > 0;
        return (res << 1) + temp;
    }
}
