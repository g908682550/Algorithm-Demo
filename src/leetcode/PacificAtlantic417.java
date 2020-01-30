package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlantic417 {


    @Test
    public void test(){
        int[][] matrix={{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        solution(matrix);
    }


    List<List<Integer>> result=new ArrayList<>();

    int m,n;
    int[][] step={{0,1},{0,-1},{-1,0},{1,0}};
    boolean[][] flag;

    /**
     * 从中心分别向边缘扩散，如果能同时扩散到太平洋和大西洋，加入结果集中
     * @param matrix
     * @return
     */
    public List<List<Integer>> solution(int[][] matrix){
        m=matrix.length;
        if(m==0) return result;
        n=matrix[0].length;
        flag=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific(matrix,i,j,matrix[i][j])&&atlantic(matrix,i,j,matrix[i][j])) result.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
        return result;
    }

    /**
     * 向大西洋扩散
     * @param nums
     * @param x
     * @param y
     * @param pre
     * @return
     */
    public boolean atlantic(int[][] nums,int x,int y,int pre){
        if(nums[x][y]>pre) return false;
        if(x==m-1||y==n-1) return true;
        else{
            flag[x][y]=true;
            for(int i=0;i<4;i++){
                int newX=x+step[i][0];
                int newY=y+step[i][1];
                if(isTrue(newX,newY)&&!flag[newX][newY]&&atlantic(nums,newX,newY,nums[x][y])) {
                    flag[x][y]=false;
                    return true;
                }
            }
            flag[x][y]=false;
        }
        return false;
    }

    public boolean isTrue(int x,int y){
        return x>=0&&x<m&&y>=0&&y<n;
    }


    int[][] pacific;
    int[][] atlantic;

    /**
     * 边缘向中心扩散
     * @param matrix
     * @return
     */
    public List<List<Integer>> solution2(int[][] matrix){
        m=matrix.length;
        if(m==0) return result;
        n=matrix[0].length;
        flag=new boolean[m][n];
        pacific=new int[m][n];
        atlantic=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0)
                    helper(matrix,i,j,matrix[i][j],pacific);
                if(i==m-1||j==n-1)
                    helper(matrix,i,j,matrix[i][j],atlantic);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j]==1&&atlantic[i][j]==1) result.add(new ArrayList<>(Arrays.asList(i,j)));
            }
        }
        return result;
    }

    public void helper(int[][] nums,int x,int y,int pre,int[][] other){
        if(nums[x][y]<pre||other[x][y]==1) return;
        else{
            other[x][y]=1;
            flag[x][y]=true;
            for(int i=0;i<4;i++){
                int newX=x+step[i][0];
                int newY=y+step[i][1];
                if(isTrue(newX,newY)&&!flag[newX][newY]) helper(nums,newX,newY,nums[x][y],other);
            }
            flag[x][y]=false;
        }
    }

    /**
     * 向太平洋扩散
     * @param nums
     * @param x
     * @param y
     * @param pre
     * @return
     */
    public boolean pacific(int[][] nums,int x,int y,int pre){
        if(nums[x][y]>pre) return false;
        if(x==0||y==0) return true;
        else{
            flag[x][y]=true;
            for(int i=0;i<4;i++){
                int newX=x+step[i][0];
                int newY=y+step[i][1];
                if(isTrue(newX,newY)&&!flag[newX][newY]&&pacific(nums,newX,newY,nums[x][y])) {
                    flag[x][y]=false;
                    return true;
                }
            }
            flag[x][y]=false;
        }
        return false;
    }




}
