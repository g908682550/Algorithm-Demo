package leetcode;

public class MaxProfit121 {


    public void test(){

    }

    /**
     * dp[m][n]的m表示当前位置，n表示当前是否持有股票
     * @param prices
     * @return
     */
    public int solution1(int[] prices){
        int n=prices.length;
        int[][] dp=new int[n+1][2];
        dp[0][0]=0;
        dp[0][1]=Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i-1]);
            dp[i][1]=Math.max(dp[i-1][1],-prices[i-1]);//因为只能交易一次，所以默认初始为-prices[i-1]
        }
        return dp[n][0];
    }

    /**
     * 根据解法1改进，当前状态只与前一个状态有关，仅使用常数级别的变量即可完成遍历
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
            dp_0_1=Math.max(dp_0_1,-prices[i]);
        }
        return dp_0_0;
    }


}
