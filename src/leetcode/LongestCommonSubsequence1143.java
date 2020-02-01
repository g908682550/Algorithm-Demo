package leetcode;

public class LongestCommonSubsequence1143 {

    /**
     * dp数[m][n]表示text1的m长度与text2n长度能匹配的最大值
     * @param text1
     * @param text2
     * @return
     */
    public int solution(String text1, String text2){
        int m=text1.length();
        int n=text2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            char c1=text1.charAt(i-1);
            for(int j=1;j<=n;j++){
                char c2=text2.charAt(j-1);
                if(c1==c2) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[m][n];
    }


}
