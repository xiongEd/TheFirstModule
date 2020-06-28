package LeetCode_SwordRefersOffer;
/*
Solution343
给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

示例 1：

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
提示：

2 <= n <= 58
 */
public class SwordRefersOffer14_I_剪绳子 {
    public int cuttingRope(int n) {
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
