package LeetCode;
/*
给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class Solution96 {
    public int numTrees(int n) {
        int[] result = new int[n + 1];
        if (n == 0 || n == 1) {
            return 1;
        }
        int temp;
        result[0] = result[1] = 1;
        for (int i = 2; i <= n; i ++) {
            temp = 0;
            for (int j = 0; j < i / 2; j ++) {
                temp += result[j] * result[i - j - 1];
            }
            temp *= 2;
            if ((i & 1) == 1) {
                temp += result[i / 2] * result[i / 2];
            }
            result[i] = temp;
        }
        return result[n];
    }
}
