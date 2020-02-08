package offer;

public class cutRope {

    public int solution(int target){
        int[] dp=new int[target+1];
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=target;i++){
            for(int j=1;j<i;j++){
                dp[i]=Math.max(Math.max(j*(i-j),j*dp[i-j]),dp[i]);
            }
        }
        return dp[target];
    }

}
