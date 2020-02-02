package leetcode;

public class FindMaxForm474 {

    /**
     * 二维背包问题，三维数组
     * @return
     */
    public int solution1(String[] strs, int m, int n){
        int len=strs.length;
        int[][][] dp=new int[len+1][m+1][n+1];
        for(int k=1;k<=len;k++){
            int[] curr=count(strs[k-1]);
            for(int i=0;i<=m;i++){
                for(int j=0;j<=n;j++){
                    dp[k][i][j]=dp[k-1][i][j];
                    if(i>=curr[0]&&j>=curr[1])
                        dp[k][i][j]=Math.max(dp[k-1][i][j],dp[k-1][i-curr[0]][j-curr[1]]+1);
                }
            }
        }
        return dp[len][m][n];
    }

    /**
     * 当前状态只与上一行有关，二维数组
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int solution2(String[] strs, int m, int n){
        int[][] dp=new int[m+1][n+1];
        for(String s:strs){
            int[] curr=count(s);
            for(int i=m;i>=0;i--){
                for(int j=n;j>=0;j--){
                    if(i>=curr[0]&&j>=curr[1]){
                        dp[i][j]=Math.max(dp[i][j],dp[i-curr[0]][j-curr[1]]+1);
                    }
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String s){
        int[] curr=new int[2];
        for(char c:s.toCharArray())
            curr[c-'0']++;
        return curr;
    }

}
