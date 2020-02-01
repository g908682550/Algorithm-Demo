package leetcode;

public class maxProfit123 {


    /**
     * dp[m[k][n]：m表示当前所在索引下标，k表示当前交易的次数，n=1表示当前持有股票，0表示当前不持有
     * @param prices
     * @return
     */
    public int solution1(int[] prices){
        int n=prices.length;
        int[][][] dp=new int[n][3][2];
        if(n==0) return 0;
        dp[0][2][0]=0;
        dp[0][2][1]=-prices[0];
        dp[0][1][1]=-prices[0];
        for(int i=1;i<n;i++){
            for(int k=2;k>=1;k--){
                dp[i][k][0]=Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                dp[i][k][1]=Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[n-1][2][0];
    }

    /**
     * 用4个常量来保存数据
     * @param prices
     * @return
     */
    public int solution2(int[] prices){
        int n=prices.length;
        if(n==0) return 0;
        int dp_020=0,dp_021=-prices[0];
        int dp_010=0,dp_011=-prices[0];
        for(int i=1;i<n;i++){
            dp_020=Math.max(dp_020,dp_021+prices[i]);
            dp_021=Math.max(dp_021,dp_010-prices[i]);
            dp_010=Math.max(dp_010,dp_011+prices[i]);
            dp_011=Math.max(dp_011,-prices[i]);
        }
        return dp_020;
    }

}
