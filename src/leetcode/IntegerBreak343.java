package leetcode;

public class IntegerBreak343 {

    /**
     * 动态规划求解
     * @param n
     * @return
     */
    public int solution(int n){
        int[] dp=new int[n+1];
        dp[1]=1;
        for(int i=2;i<=n;i++){
            int max=i-1;
            for(int j=1;j<=i-j;j++)
                max=Math.max(max,Math.max(j*(i-j),j*dp[i-j]));//dp数组的值为当前下标整数拆分后的最大值
            dp[i]=max;
        }
        return dp[n];
    }

}
