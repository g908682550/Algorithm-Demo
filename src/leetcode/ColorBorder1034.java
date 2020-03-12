package leetcode;

import org.junit.Test;

import java.util.*;

public class ColorBorder1034 {

    @Test
    public void test(){
        int n='1'-48;
        System.out.println(n);
        StringBuilder s=new StringBuilder();
        s.toString().toCharArray();
    }

    int[][] grid;
    boolean[][] visited;
    int R,C,color,origin;
    int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};

    /**
     * 从(r0,c0)开始向边缘扩散，对边界进行判定，如果是边界进行着色
     * @param grid
     * @param r0
     * @param c0
     * @param color
     * @return
     */
    public int[][] solution(int[][] grid, int r0, int c0, int color){
        this.grid=grid;
        this.color=color;
        this.origin=grid[r0][c0];
        R=grid.length;
        C=grid[0].length;
        visited=new boolean[R][C];
        helper(r0,c0);
        return grid;
    }

    public void helper(int x,int y){
        //边界判定
        if(isEdge(x,y)){
            grid[x][y]=color;
        }
        visited[x][y]=true;
        for(int i=0;i<4;i++){
            int nextX=x+dir[i][0],nextY=y+dir[i][1];
            if(isTrue(nextX,nextY)&&!visited[nextX][nextY]&&grid[nextX][nextY]==origin) helper(nextX,nextY);

        }
    }

    public boolean isTrue(int x,int y){
        return x>=0&&x<R&&y>=0&&y<C;
    }

    public boolean isEdge(int x,int y){
        if(x==0||x==R-1||y==0||y==C-1) return true;
        for(int i=0;i<4;i++){
            int newX=x+dir[i][0],newY=y+dir[i][1];
            if(!visited[newX][newY]&&grid[newX][newY]!=origin) return true;
        }
        return false;
    }

}
