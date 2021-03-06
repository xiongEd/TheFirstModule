package LeetCode;
/*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution9_Cplusplus {

    /* first
    bool isPalindrome(int x) {
        long exchange = 0, temp = x;
        while (temp > 0) {
            exchange = exchange *10 + temp % 10;
            temp /= 10;
        }
        return exchange == x;
    }
     */

    /* second
    public:
    bool isPalindrome(int x) {
        if(x < 0)
			return false;

		string s;
		int n,i,r;

		while (x)
			{
			r = x%10;
			x /= 10;
			s += r;
			}

		n = s.size();
		i =0; r = n-1;
		while (i <= r)
			{
			if(s[i] != s[r])
				return false;

			++i;
			--r;
			}
		return true;
    }
     */
}
