package LeetCode;

public class Solution121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++){
            for (int j=i;j<prices.length;j++){
                if (prices[j]-prices[i]>maxProfit)
                    maxProfit=prices[j]-prices[i];
            }
        }
        return maxProfit;
    }
}
