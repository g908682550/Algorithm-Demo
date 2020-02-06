package leetcode;

import java.util.HashSet;

public class MaxAreaOfIsland695 {

    private int[][] grid;
    private int R;
    private int C;
    private HashSet<Integer>[] G;//建图
    private int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    private boolean[] visited;

    /**
     * 建图+深度优先遍历
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        R=grid.length;
        if(R==0) return 0;
        C=grid[0].length;
        if(C==0) return 0;
        this.grid=grid;
        //建图过程
        G=construct();
        visited=new boolean[G.length];
        int result=0;
        for(int v=0;v<G.length;v++){
            int x=v/C,y=v%C;
            if(grid[x][y]==1&&!visited[v]) result=Math.max(result,dfs(v));
        }
        return result;
    }

    private int dfs(int v){
        visited[v]=true;
        int result=1;
        for(int w:G[v]){
            if(!visited[w]) result+=dfs(w);
        }
        return result;
    }

    private HashSet[] construct(){
        G=new HashSet[R*C];
        for(int i=0;i<G.length;i++) G[i]=new HashSet<>();
        for(int i=0;i<G.length;i++){
            int x=i/C,y=i%C;
            if(grid[x][y]==1){
                for(int k=0;k<4;k++){
                    int nextX=x+dir[k][0],nextY=y+dir[k][1];
                    if(isTrue(nextX,nextY)&&grid[nextX][nextY]==1){
                        int index=nextX*C+nextY;
                        G[i].add(index);
                        G[index].add(i);
                    }
                }
            }
        }
        return G;
    }

    boolean[][] flag;

    private boolean isTrue(int x,int y){
        return x>=0&&x<R&&y>=0&&y<C;
    }

    /**
     * 递归和回溯方法
     * @param grid
     * @return
     */
    public int solution(int[][] grid){
        R=grid.length;
        if(R==0) return 0;
        C=grid[0].length;
        if(C==0) return 0;
        this.grid=grid;
        flag=new boolean[R][C];
        int result=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(!flag[i][j]) result=Math.max(result,helper(i,j));
            }
        }
        return result;
    }

    private int helper(int i,int j){
        if(grid[i][j]==0) return 0;
        else{
            int res=1;
            flag[i][j]=true;
            for(int k=0;k<4;k++){
                int nextX=i+dir[k][0];
                int nextY=j+dir[k][1];
                if(isTrue(nextX,nextY)&&!flag[nextX][nextY]) res+=helper(nextX,nextY);
            }
            return res;
        }
    }

}
