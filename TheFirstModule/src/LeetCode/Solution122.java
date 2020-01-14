package LeetCode;
//7 1 5 3 6 4
public class Solution122 {
    public int maxProfit(int[] prices) {
        int res = 0, in = -1, sum = 0,out = 0;
        for (int i = 0; i < prices.length; i++){
                if (i < prices.length - 1 && in == -1 && prices[i] < prices[i+1]) {
                    in = prices[i];
                    continue;
                }

                if (in != -1 && (i == prices.length - 1 || prices[i] > prices[i+1])){
                    out = prices[i];
                    res = out - in;
                    in = -1;
                    sum += res;
                }
        }
        return sum;
    }
}
