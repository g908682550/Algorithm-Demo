package leetcode;

import org.junit.Test;

public class MaximalSquare {

    @Test
    public void test(){
        
    }

    public int solution(char[][] matrix){
        int result=0,m=matrix.length;
        if(m==0) {
            return result;
        }
        int n=matrix[0].length;
        if(n==0) {
            return result;
        }
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]=='0') {
                    dp[i][j]=0;
                }
                else{
                    if(i==0||j==0) {
                        dp[i][j]=1;
                    }
                    else {
                        dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    }
                }
                result=Math.max(dp[i][j],result);
            }
        }
        return result*result;
    }

}
