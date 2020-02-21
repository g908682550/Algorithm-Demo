package leetcode;

import org.junit.Test;

public class MinCut132 {

    @Test
    public void test(){
        String s="abbab";
        solution(s);
    }

    int[] dp;

    /**
     * 动态规划 dp[i]表示以i结尾切分为回文串所需要的最少次数
     * @param s
     * @return
     */
    public int solution(String s){
        if(s.length()==0) return 0;
        int n=s.length();
        dp=new int[n+1];
        for(int i=0;i<n;i++) dp[i]=i;
        for(int i=0;i<n;i++){
            String curr=s.substring(0,i+1);
            if(isPartition(curr)) dp[i]=0;
            else{
                for(int j=i;j>0;j--){
                    String next=s.substring(j,i+1);
                    if(isPartition(next)) dp[i]=Math.min(dp[j-1]+1,dp[i]);
                }
            }
        }
        return dp[n-1];
    }

    public boolean isPartition(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }


}
