package SwordRefersOffer;
/*
给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
输入描述:
输入一个数n，意义见题面。（2 <= n <= 60）
输出描述:
输出答案。
示例1
输入

复制
8
输出

复制
18
 */
public class Solution67 {
    public int cutRope(int target) {
        int a = 0;
        int c = 0;
        int maxValue = 2;

        if (target == 2) {
            return 1;
        }

        if (target == 3) {
            return 2;
        }

        if (target % 3 == 0) {
            maxValue = (int)Math.pow(3, target / 3);
        }

        else{
            a = target - 2;
            c = a % 3;
            maxValue = maxValue * (int)Math.pow(3, a / 3);

            if (0 != c) {
                maxValue = maxValue * c;
            }
        }
        return maxValue;
    }
}
