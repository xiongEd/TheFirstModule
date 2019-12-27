package LeetCode;

public class Solution813Ex {

    private static double[]sums;

    public static double largestSumOfAverages(int[] A, int K) {
        if (A.length == 0 || K > A.length)
            return 0;

        int sum = 0;

        sums = new double[A.length];
        for (int i = 0; i < A.length; i ++){
            sum += A[i];
            sums[i] = sum;
        }

        double[] dp = new double[A.length];
        for (int i = 0; i < A.length; i ++){
            dp[i] = getAvevage(i, A.length - 1);
        }

        for (int i = 0; i < K - 1; i ++){
            for (int j = 0; j < A.length; j ++){
                for (int k = j + 1; k < A.length; k ++){
                    dp[j] = Math.max(dp[j], (getAvevage(j, k - 1) + dp[k]));
                }
            }
        }

        return dp[0];
    }

    private static double getAvevage(int i, int j){
        if (i == 0)
            return sums[j] / (j + 1);
        else
            return (sums[j] - sums[i - 1]) / (j - i + 1);
    }

}
