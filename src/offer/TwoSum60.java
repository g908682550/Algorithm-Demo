package offer;

import org.junit.Test;

public class TwoSum60 {

    @Test
    public void test(){
        solution(2);
    }

    public double[] solution(int n){
        Double total=Math.pow(6,n);
        int[][] dp=new int[n+1][n*6+1];
        for(int i=1;i<=6;i++) dp[1][i]=1;
        for(int i=2;i<=n;i++){
            for(int j=i;j<i*6+1;j++){
                for(int curr=1;curr<=6;curr++){
                    if(curr>=j) break;
                    dp[i][j]+=dp[i-1][j-curr];
                }
            }
        }
        double[] result=new double[6*n-n+1];
        for(int i=0;i<6*n-n+1;i++){
            result[i]=dp[n][n+i]/total;
        }
        return result;
    }

}
