package leetcode;

import org.junit.Test;

public class IsMatch10 {


    @Test
    public void test(){
        String s="TRADE_SUCCESS",p="a*";
        System.out.println(s.equals("TRADE_SUCCESS"));
    }

    public boolean solution(String s, String p){
        int m=s.length(),n=p.length();
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int j=1;j<=n;j++) if(p.charAt(j-1)=='*') dp[0][j]=dp[0][j-2];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='.') dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)=='*'){
                    if(p.charAt(j-2)!=s.charAt(i-1)&&p.charAt(j-2)!='.') dp[i][j]=dp[i][j-2];
                    else dp[i][j]=dp[i][j-1]||dp[i][j-2];
                }
            }
        }
        return dp[m][n];
    }

}
