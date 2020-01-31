package leetcode;

import java.util.List;

public class MinimumTotal120 {

    /**
     * 自底向上，动态规划
     * @param triangle
     * @return
     */
    public int solution(List<List<Integer>> triangle){
        int n=triangle.size();
        int[] dp=new int[n];
        List<Integer> list=triangle.get(n-1);
        for(int i=0;i<n;i++) dp[i]=list.get(i);
        for(int i=n-2;i>=0;i--){
            list=triangle.get(i);
            for(int j=0;j<i+1;j++){
                dp[j]=list.get(j)+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }
}
