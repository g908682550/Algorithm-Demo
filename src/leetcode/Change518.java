package leetcode;

import java.util.Arrays;

public class Change518 {

    public int solution(int amount,int[] coins){
        Arrays.sort(coins);
        int[] dp=new int[amount+1];
        dp[0]=1;
        for(int i=0;i<coins.length;i++){
            int coin=coins[i];
            for(int j=coin;j<=amount;j++){
                dp[j]+=dp[j-coin];
            }
        }
        return dp[amount];
    }

}
