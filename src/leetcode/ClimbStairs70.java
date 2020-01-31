package leetcode;

import org.junit.Test;

public class ClimbStairs70 {

    @Test
    public void test(){
        solution(3);
    }

    public int solution(int n){
        int[] dp=new int[n+1];//创建n+1个数组，防止边界问题
        dp[0]=1;
        dp[1]=2;
        for(int i=2;i<n+1;i++) dp[i]=dp[i-1]+dp[i-2];
        return dp[n-1];
    }

}
