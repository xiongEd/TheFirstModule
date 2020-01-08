package LeetCode;
/*
有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。

不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。

现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。

假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。

 

示例 1：

输入：n = 2, rollMax = [1,1,2,2,2,3]
输出：34
解释：我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所以不会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2 = 34。
示例 2：

输入：n = 2, rollMax = [1,1,1,1,1,1]
输出：30
示例 3：

输入：n = 3, rollMax = [1,1,1,2,2,3]
输出：181
 

提示：

1 <= n <= 5000
rollMax.length == 6
1 <= rollMax[i] <= 15
 */
public class Solution1223 {
    public int dieSimulator(int n, int[] rollMax) {
        int res;
        if(n < 1)
            return 0;
        long  ret = 0;
        for(int i = 1; i <= 6; i++)
            ret += SolveFuncion(n - 1, rollMax, i, 1);
        res = (int)(ret % 1000000007);
        return res;
    }

    private long SolveFuncion(int n, int[] rollmax, int index, int temp){
        long res = 0;
        if(temp > rollmax[index - 1])
            return 0;
        if(n == 0){
            return 1;
        }

        for(int i = 1; i <= 6; i++){
            if(i == index){
                res += SolveFuncion(n - 1,rollmax, i, temp + 1);
            }
            else{
                res += SolveFuncion(n - 1, rollmax, i, 1);
            }
        }

        res %= 1000000007;
        return res;
    }
}
