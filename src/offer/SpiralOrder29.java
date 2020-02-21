package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder29 {

    @Test
    public void test(){
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        solution(matrix);
    }


    public int[] solution(int[][] matrix){
        List<Integer> result=new ArrayList<>();
        helper(result,matrix);
        int[] res=new int[result.size()];
        for(int i=0;i<result.size();i++) res[i]=result.get(i);
        return res;
    }

    public void helper(List<Integer> result,int[][] matrix){
        int m=matrix.length;
        if(m==0) return;
        int n=matrix[0].length;
        if(n==0) return;
        for(int i=0;i<n;i++) result.add(matrix[0][i]);
        if(m==1) return;
        for(int i=1;i<m;i++) result.add(matrix[i][n-1]);
        if(n==1) return;
        for(int i=n-2;i>=0;i--) result.add(matrix[m-1][i]);
        for(int i=m-2;i>=0;i--) result.add(matrix[i][0]);
        if(m<=2||n<=2) return;
        int[][] next=new int[m-2][n-2];
        for(int i=1;i<m-1;i++)
            for(int j=1;j<n-1;j++)
                next[i-1][j-1]=matrix[i][j];

        helper(result,next);
    }


}
