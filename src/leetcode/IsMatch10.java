package leetcode;

import org.junit.Test;

public class IsMatch10 {


    @Test
    public void test(){
        String s="aa",p="a*";
        System.out.println(solution(s,p));
    }

    public boolean solution(String s, String p){
        int m=s.length(),n=p.length();
        boolean[][] dp=new boolean[m+1][n+1];
        dp[0][0]=true;
        for(int i=0;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-2];
                    if(match(s,p,i,j-1)) dp[i][j]=dp[i][j]||dp[i-1][j];
                }else if(match(s,p,i,j)) dp[i][j]=dp[i-1][j-1];
            }
        }
        return dp[m][n];
    }

    public boolean match(String s,String p,int i,int j){
        return i!=0&&(p.charAt(j-1)=='.'||s.charAt(i-1)==p.charAt(j-1));
    }
}
