package leetcode;
import java.util.*;
public class UpdateMatrix542 {


    int[][] dir={{0,1},{0,-1},{-1,0},{1,0}};
    int[][] result,matrix;
    int m,n;
    boolean[][] flag;

    /**
     * 从1到0进行bfs
     * @param matrix
     * @return
     */
    public int[][] solution1(int[][] matrix) {
        this.matrix=matrix;
        m=matrix.length;
        if(m==0) return result;
        n=matrix[0].length;
        if(n==0) return result;
        result=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1) result[i][j]=count(i,j);
            }
        }
        return result;
    }

    public int count(int x,int y){
        Queue<Integer> queue=new LinkedList<>();
        int num=x*n+y,result=1;
        queue.add(num);
        while(true){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int curr=queue.poll();
                int currX=curr/n,currY=curr%n;
                for(int k=0;k<4;k++){
                    int nextX=currX+dir[k][0],nextY=currY+dir[k][1];
                    int next=nextX*n+nextY;
                    if(isTrue(nextX,nextY)){
                        if(matrix[nextX][nextY]==0) return result;
                        queue.add(next);
                    }

                }
            }
            result++;
        }
    }

    /**
     * 从0到1进行多源bfs
     * @param matrix
     * @return
     */
    public int[][] solution2(int[][] matrix) {
        this.matrix=matrix;
        m=matrix.length;
        if(m==0) return result;
        n=matrix[0].length;
        if(n==0) return result;
        result=new int[m][n];
        flag=new boolean[m][n];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0) queue.add(i*n+j);
            }
        }
        int count=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int curr=queue.poll();
                int currX=curr/n,currY=curr%n;
                for(int k=0;k<4;k++){
                    int nextX=currX+dir[k][0],nextY=currY+dir[k][1];
                    if(isTrue(nextX,nextY)&&!flag[nextX][nextY]){
                        flag[nextX][nextY]=true;
                        if(matrix[nextX][nextY]==1) result[nextX][nextY]=count;
                        queue.add(nextX*n+nextY);
                    }
                }
            }
            count++;
        }
        return result;
    }



    public boolean isTrue(int x,int y){
        return x>=0&&x<m&&y>=0&&y<n;
    }



}
