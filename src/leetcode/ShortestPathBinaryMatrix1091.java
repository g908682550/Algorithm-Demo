package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix1091 {

    int[][] dirs={{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    int[][] dis;
    int R,C;

    /**
     * 八连通问题FloodFill
     * @param grid
     * @return
     */
    public int solution(int[][] grid){
        this.R=grid.length;
        this.C=grid[0].length;
        dis=new int[R][C];
        for(int i=0;i<R;i++)
            for(int j=0;j<C;j++) dis[i][j]=-1;
        if(grid[0][0]==1) return -1;
        if(R==1&&C==1) return 1;

        Queue<Integer> queue=new LinkedList<>();
        queue.offer(0);
        dis[0][0]=1;
        while(!queue.isEmpty()){
            int v=queue.poll();
            int currx=v/C,curry=v%C;
            for(int i=0;i<8;i++){
                int newx=currx+dirs[i][0],newy=curry+dirs[i][1];
                if(isTrue(newx,newy)&&dis[newx][newy]==-1&&grid[newx][newy]==0){
                    dis[newx][newy]=dis[currx][curry]+1;
                    int w=newx*C+newy;
                    queue.offer(w);
                }
            }
        }
        return dis[R-1][C-1];
    }

    public boolean isTrue(int x,int y){
        return x>=0&&x<R&&y>=0&&y<C;
    }

}
