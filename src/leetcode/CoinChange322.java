package leetcode;

import org.junit.Test;

public class CoinChange322 {

    @Test
    public void test(){
        int[] coins={2};
        solution(coins,3);
    }

    /**
     * 动态规划，dp数组计算出当前容量的最小值，默认为amount+1，如果最后仍为（amount+1），说明不存在这样的匹配，则返回-1
     * @param coins
     * @param amount
     * @return
     */
    public int solution(int[] coins,int amount){
        int n=coins.length;
        int[] dp=new int[amount+1];
        for(int i=1;i<=amount;i++) dp[i]=amount+1;
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int coin:coins){
                if(coin<=i)
                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }

}
