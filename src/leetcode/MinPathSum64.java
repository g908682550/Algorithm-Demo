package leetcode;

public class MinPathSum64 {

    /**
     * 经典动态规划问题，将第一行第一列赋值之后进行dp
     * @param grid
     * @return
     */
    public int solution(int[][] grid){
        int m=grid.length;
        if(m==0) return 0;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for(int i=1;i<m;i++) dp[i][0]=dp[i-1][0]+grid[i][0];
        for(int j=1;j<n;j++) dp[0][j]=dp[0][j-1]+grid[0][j];
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
        return dp[m-1][n-1];
    }
}
