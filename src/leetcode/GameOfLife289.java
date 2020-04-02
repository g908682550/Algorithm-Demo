package leetcode;

import org.junit.Test;

public class GameOfLife289 {

    /**
     * 8个方向分别计算进行判断
     */
    @Test
    public void test(){
        int[][] board={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        solution(board);
    }

    public void solution(int[][] board) {
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        int m=board.length;
        if(m==0) return;
        int n=board[0].length;
        if(n==0) return;
        int[][] result=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i][j]=board[i][j];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int x=i,y=j,count=0;
                for(int k=0;k<8;k++){
                    int nextX=x+dir[k][0],nextY=y+dir[k][1];
                    if(nextX>=0&&nextX<m&&nextY>=0&&nextY<n&&result[nextX][nextY]==1) count++;
                }
                if(board[i][j]==1){
                    if(count<2||count>3) board[i][j]=0;
                }else{
                    if(count==3) board[i][j]=1;
                }
            }
        }
    }

}
