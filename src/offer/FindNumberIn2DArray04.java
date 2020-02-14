package offer;

public class FindNumberIn2DArray04 {

    /**
     * 从右上角开始查找，找不到返回false
     * @param matrix
     * @param target
     * @return
     */
    public boolean solution(int[][] matrix, int target){
        int n=matrix.length;
        if(n==0) return false;
        int m=matrix[0].length;
        if(m==0) return false;
        int i=0,j=m-1;
        while(matrix[i][j]!=target){
            if(matrix[i][j]>target) j--;
            else i++;
            if(j<0||i==n) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
