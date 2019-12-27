package LeetCode;
/*
我们将给定的数组 A 分成 K 个相邻的非空子数组 ，我们的分数由每个子数组内的平均值的总和构成。计算我们所能得到的最大分数是多少。

注意我们必须使用 A 数组中的每一个数进行分组，并且分数不一定需要是整数。

示例:
输入:
A = [9,1,2,3,9]
K = 3
输出: 20
解释:
A 的最优分组是[9], [1, 2, 3], [9]. 得到的分数是 9 + (1 + 2 + 3) / 3 + 9 = 20.
我们也可以把 A 分成[9, 1], [2], [3, 9].
这样的分组得到的分数为 5 + 2 + 6 = 13, 但不是最大值.
说明:

1 <= A.length <= 100.
1 <= A[i] <= 10000.
1 <= K <= A.length.
答案误差在 10^-6 内被视为是正确的。
 */
public  class Solution813 {
    public static int[]sums;
    public static double largestSumOfAverages(int[] A, int K) {
        if (A.length == 0 || K > A.length)
            return 0;
        int sum = 0;
        double[] res = new  double[1];
        res[0] = Double.MIN_VALUE;
        sums = new int[A.length];
        for (int i = 0; i < A.length; i ++){
            sum += A[i];
            sums[i] = sum;
        }

        SolveFunction(0, K, 0, res);
        return res[0];
    }

    public static double getSum(int i, int j){
        if (i == 0)
            return sums[j];
        else
            return sums[j] - sums[i - 1];
    }

    public static void SolveFunction(int begin, int CutOff, double cur, double[]res){
        double temp;
        if (CutOff == 1) {
            cur += getSum(begin, sums.length - 1)/(sums.length - begin);
            res[0] = Math.max(res[0], cur);
        }else {
            for (int i = begin; i <= sums.length - CutOff; i ++){
                temp = cur + getSum(begin, i)/(i - begin + 1);
                if (sums.length - CutOff == i){
                    temp += getSum(i + 1, sums.length - 1);
                    res[0] = Math.max(res[0], temp);
                }else {
                    SolveFunction(i + 1, CutOff - 1, temp, res);
                }
            }
        }
    }

    public static void main(String[] args){
        int[]a = {4663,3020,7789,1627,9668,1356,4207,1133,8765,4649,205,6455,8864,3554,3916,5925,3995,4540,3487,5444,8259,8802,6777,7306,989,4958,2921,8155,4922,2469,6923,776,9777,1796,708,786,3158,7369,8715,2136,2510,3739,6411,7996,6211,8282,4805,236,1489,7698};
        System.out.println(largestSumOfAverages(a, 12));
    }
}
