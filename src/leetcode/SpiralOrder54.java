package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder54 {

    /**
     * 递归打印
     * @param matrix
     * @return
     */
    public List<Integer> solution(int[][] matrix){
        List<Integer> result=new ArrayList<>();
        helper(result,matrix);
        return result;
    }

    public void helper(List<Integer> result,int[][] nums){
        int m=nums.length;
        if(m==0) return;
        int n=nums[0].length;
        for(int i=0;i<n;i++){
            result.add(nums[0][i]);
        }
        if(m==1) return;
        for(int i=1;i<m;i++){
            result.add(nums[i][n-1]);
        }
        if(n==1) return;
        for(int i=n-2;i>=0;i--){
            result.add(nums[m-1][i]);
        }
        for(int i=m-2;i>0;i--){
            result.add(nums[i][0]);
        }
        if(m-2<=0||n-2<=0) return;
        int[][] newnums=new int[m-2][n-2];
        for(int i=1;i<m-1;i++){
            newnums[i-1]= Arrays.copyOfRange(nums[i],1,n-1);
        }
        helper(result,newnums);
    }

}
