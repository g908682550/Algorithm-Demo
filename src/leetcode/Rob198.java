package leetcode;

public class Rob198 {

    /**
     * 动态规划问题，dp表示当前为最后一个房子时所能偷取的最大值
     * @param nums
     * @return
     */
    public int solution(int[] nums){
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[n-1];
    }

    /**
     * 实际上只需要维护2个数字来计算即可
     * @param nums
     * @return
     */
    public int solution2(int[] nums){
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int dp_1=nums[0];
        int dp_2=Math.max(nums[0],nums[1]);
        int curr=dp_2;
        for(int i=2;i<n;i++){
            curr=Math.max(dp_2,dp_1+nums[i]);
            dp_1=dp_2;
            dp_2=curr;
        }
        return curr;
    }

}
