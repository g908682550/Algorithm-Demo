package leetcode;

public class MaxProfit122 {


    /**
     * dp[m][n]意义与上题一样，不过允许多次交易
     * @param prices
     * @return
     */
    public int solution1(int[] prices){
        int n=prices.length;
        int[][] dp=new int[n][2];
        if(n==0) return 0;
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);//允许多次交易代表这里可以利用之前买卖后的结果
        }
        return dp[n-1][0];
    }

    /**
     * 采用常数个变量即可
     * @param prices
     * @return
     */
    public int solution2(int[] prices){
        int n=prices.length;
        if(n==0) return 0;
        int dp_0_0=0;
        int dp_0_1=-prices[0];
        for(int i=1;i<n;i++){
            dp_0_0=Math.max(dp_0_0,dp_0_1+prices[i]);
            dp_0_1=Math.max(dp_0_1,dp_0_0-prices[i]);
        }
        return dp_0_0;
    }

}
