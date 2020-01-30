package leetcode;

public class NumsIslands200 {

    int m,n;
    boolean[][] flag;
    int[][] step={{0,1},{0,-1},{1,0},{-1,0}};

    /**
     * 二维数组的回溯算法，注释可参考79号问题
     * @param grid
     * @return
     */
    public int solution(char[][] grid){
        m=grid.length;
        if(m==0) return 0;
        n=grid[0].length;
        flag=new boolean[m][n];
        int sum=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'&&!flag[i][j]){
                    searchLands(grid,i,j);
                    sum+=1;
                }
            }
        }
        return sum;
    }

    public void searchLands(char[][] grid,int x,int y){
        if(grid[x][y]=='0'||flag[x][y]) return ;
        if(grid[x][y]=='1'){
            flag[x][y]=true;
            for(int i=0;i<4;i++){
                int newX=x+step[i][0];
                int newY=y+step[i][1];
                if(isTrue(newX,newY)&&!flag[newX][newY]){
                    searchLands(grid,newX,newY);
                }
            }
        }
    }

    public boolean isTrue(int x,int y){
        return x>=0&&x<m&&y>=0&&y<n;
    }

}
