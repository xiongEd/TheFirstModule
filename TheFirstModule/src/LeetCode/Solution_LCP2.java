package LeetCode;
/*
输入的cont代表连分数的系数（cont[0]代表上图的a0，以此类推）。返回一个长度为2的数组[n, m]，使得连分数的值等于n / m，且n, m最大公约数为1。

 

示例 1：

输入：cont = [3, 2, 0, 2]
输出：[13, 4]
解释：原连分数等价于3 + (1 / (2 + (1 / (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
示例 2：

输入：cont = [0, 0, 3]
输出：[3, 1]
解释：如果答案是整数，令分母为1即可。
限制：

cont[i] >= 0
1 <= cont的长度 <= 10
cont最后一个元素不等于0
答案的n, m的取值都能被32位int整型存下（即不超过2 ^ 31 - 1）。
 */
public class Solution_LCP2 {
    public int[] fraction(int[] cont) {
        int[] res = new int[2];
        int temp;
        if (cont.length < 1) return res;
        res[0] = cont[cont.length - 1];
        res[1] = 1;
        for (int i = cont.length - 2; i >= 0; i --){
            if (cont[i] == 0){
                temp = res[0];
                res[0] = res[1];
                res[1] = temp;
            } else {
                temp = res[0];
                res[0] = res[0] * cont[i] + res[1];
                res[1] = temp;
            }
        }

        int a = res[0], b = res[1];
        temp = a % b;
        while (temp != 0){
            a = b;
            b = temp;
            temp = a % b;
        }
        res[0] /= b;
        res[1] /= b;
        return res;
    }
}
