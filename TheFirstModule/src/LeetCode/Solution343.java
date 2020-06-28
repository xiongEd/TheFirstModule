package LeetCode;
/*
给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

示例 1:

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
说明: 你可以假设 n 不小于 2 且不大于 58。
 */
public class Solution343 {
    public int integerBreak(int n) {
        int a = 0;
        int c = 0;
        int maxValue = 2;

        if (n == 2) {
            return 1;
        }

        if (n == 3) {
            return 2;
        }

        if (n % 3 == 0) {
            maxValue = (int)Math.pow(3, n / 3);
        }

        else{
            a = n - 2;
            c = a % 3;
            maxValue = maxValue * (int)Math.pow(3, a / 3);

            if (0 != c) {
                maxValue = maxValue * c;
            }
        }
        return maxValue;
    }
}
