package leetcode;

import org.junit.Test;

public class OrangesRotting994 {

    @Test
    public void test(){
        int[][] graph={{2,1,1},{1,1,0},{0,1,1}};
        solution(graph);
    }

    int[][] grid;
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
    boolean[][] visited;
    int R,C,res;
    public int solution(int[][] grid) {
        this.grid=grid;
        R=grid.length;
        C=grid[0].length;
        visited=new boolean[R][C];
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(grid[i][j]==2&&!visited[i][j]){
                    res=Math.max(res,helper(i,j,0));
                }
            }
        }
        return res;
    }

    public int helper(int x,int y,int count){
        if(grid[x][y]!=1) return count;
        visited[x][y]=true;
        count+=1;
        for(int k=0;k<4;k++){
            int nextX=x+dir[k][0],nextY=dir[k][1];
            if(isTrue(nextX,nextY)&&!visited[nextX][nextY]) count=Math.max(count,helper(nextX,nextY,count));
        }
        return count;
    }

    private boolean isTrue(int x,int y){
        return x>=0&&x<R&&y>=0&&y<C;
    }

}
