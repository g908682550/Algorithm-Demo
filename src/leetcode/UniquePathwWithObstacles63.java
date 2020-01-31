package leetcode;

public class UniquePathwWithObstacles63 {

    /**
     * 与62类似，重点是初始值的赋值
     * @param obstacleGrid
     * @return
     */
    public int solution(int[][] obstacleGrid){
        int m=obstacleGrid.length;
        if(m==0) return 0;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        int row=0,col=0;
        while(row<m){
            if(obstacleGrid[row][0]==0) dp[row][0]=1;
            else break;
            row++;
        }
        while(col<n){
            if(obstacleGrid[0][col]==0) dp[0][col]=1;
            else break;
            col++;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==0) dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

}
