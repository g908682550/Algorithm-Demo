package leetcode;

public class CombinationSum4377 {

    /**
     * dp数组代表当前容量能组合的个数
     * @param nums
     * @param target
     * @return
     */
    public int solution(int[] nums, int target){
        int n=nums.length;
        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=1;i<=target;i++)
            for(int num:nums)
                if(num<=i) dp[i]+=dp[i-num];

        return dp[target];
    }

}
