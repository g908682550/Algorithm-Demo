package leetcode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDistance1162 {

    @Test
    public void test(){
        int[][] nums={{1,0,1},{0,0,0},{1,0,1}};
        System.out.println(solution(nums));
    }

    /**
     * 多源BFS求最远路径
     * @param grid
     * @return
     */
    public int solution(int[][] grid) {
        int n=grid.length;
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        int result=-1;
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) queue.add(i*n+j);
            }
        }
        if(queue.isEmpty()||queue.size()==n*n) return -1;
        while(!queue.isEmpty()){
            int count=queue.size();
            for(int i=0;i<count;i++){
                int curr=queue.poll();
                int x=curr/n,y=curr%n;
                for(int k=0;k<4;k++){
                    int nextX=x+dir[k][0],nextY=y+dir[k][1];
                    if(nextX>=0&&nextX<n&&nextY>=0&&nextY<n&&grid[nextX][nextY]==0) {
                        queue.add(nextX*n+nextY);
                        grid[nextX][nextY]=1;
                    }
                }
            }
            result++;
        }
        return result;
    }

}
