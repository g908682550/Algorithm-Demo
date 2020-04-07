package leetcode;

public class Rotate48 {

    /**
     * 思路，以列中心交换，再斜对角线交换
     * @param matrix
     */
    public void solution(int[][] matrix){
        int n=matrix.length;
        if(n==0) return;
        int mid=n/2;
        for(int j=0;j<mid;j++){
            for(int i=0;i<n;i++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[n-j-1][n-i-1];
                matrix[n-j-1][n-i-1]=temp;
            }
        }
    }

}
