package leetcode;

import org.junit.Test;

public class IsMatch44 {

    @Test
    public void test(){
        String s="aa";
        String p="*";
        solution(s,p);
    }

    public boolean solution(String s,String p){
        int m=s.length(),n=p.length();
        boolean[][] dp=new boolean[n+1][m+1];
        dp[0][0]=true;
        for(int i=1;i<=n;i++){
            if(p.charAt(i-1)!='*') break;
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                char a=s.charAt(j-1),b=p.charAt(i-1);
                if(b=='?'||a==b) dp[i][j]=dp[i-1][j-1];
                if(b=='*') dp[i][j]=dp[i-1][j]||dp[i][j-1];
            }
        }
        return dp[n][m];
    }


}
