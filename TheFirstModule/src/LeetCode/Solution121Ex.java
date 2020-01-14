package LeetCode;

public class Solution121Ex {
    public int maxProfit(int[] prices) {
        int res = 0, last = 0, sum;
        for (int i = 0; i < prices.length; i ++){
            if (i == 0){
                last = prices[i];
            }
            last = Math.min(last, prices[i]);
            res = Math.max(res, prices[i] - last);
        }
        return res;
    }
}
