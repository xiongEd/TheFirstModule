package LeetCode;

public class Solution122Ex {
    int maxProfit(int[] prices) {
        int res = 0, last = 0;
        for (int i = 0; i < prices.length; i ++){
            if (i == 0){
                last = prices[i];
                continue;
            }
            if (prices[i] > prices[i - 1]){
                res += prices[i] - prices[i - 1];
            }
        }
        return res;
    }
}
