package LeetCode;
/*
给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。

返回被除数 dividend 除以除数 divisor 得到的商。

示例 1:

输入: dividend = 10, divisor = 3
输出: 3
示例 2:

输入: dividend = 7, divisor = -3
输出: -2
说明:

被除数和除数均为 32 位有符号整数。
除数不为 0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class Solution29_Cplusplus {
    /*
    public:
	int divide(int dividend, int divisor) {
		if(dividend == 0)
			return 0;
		int flag = 1,n = 0;

		if((dividend == INT_MIN && divisor == -1) || (dividend == INT_MAX && divisor == 1))
			return INT_MAX;
		if((dividend == INT_MIN && divisor == 1) || (dividend == INT_MAX && divisor == -1))
			return INT_MIN;

		flag = (dividend ^ divisor) <0;
		long t = abs((long) dividend);
		long d= abs((long) divisor);

		while (t >= d) {
			long  s = d, p = 1;
			while (t >= (s << 1)) {
				s <<= 1;
				p <<= 1;
			}
			n += p;
			t -= s;
		}


		if(flag  == 0)
		return n;
		return -n;
    }
     */
}
