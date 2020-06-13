package leetcode;

public class New21Game837 {

    /**
     * dp[i]代表当前数字总和为i时获胜的可能性
     * 1、当总数大于K的时候不能抽牌，即K<i<=N的时候概率为1，N<i<K+W的时候概率为0。
     * 2、总和小于K的时候概率计算为(dp[i+1]+dp[i+2]+...+dp[i+W-1])/W（因为相对于i来说，i+1....到i+W-1每种出现的可能性是一样的，都为1/W);
     * @param N 代表获胜的上限（包含）
     * @param K 代表停止抽牌的上限（包含）
     * @param W 代表可以抽牌的范围[1,W]
     * @return
     */
    public double solution(int N,int K,int W){
        double[] dp=new double[K+W];
        double s=0;
        for(int i=K;i<K+W;i++) {
            if(i<=N) dp[i]=1.0;
            s+=dp[i];
        }
        for(int i=K-1;i>=0;i--){
            dp[i]=s/W;
            s=s+dp[i]-dp[i+W];
        }
        return dp[0];
    }

}
