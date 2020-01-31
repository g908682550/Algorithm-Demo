package leetcode;

public class Rob213 {

    /**
     * 分别求解两种动态规划问题。一个是从第一个房屋到倒数第二个房屋。另一个是第二个房屋到倒数第一个房屋。返回最大的那个
     * @param nums
     * @return
     */
    public int solution(int[] nums){
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int[] dp=new int[n];
        int[] dp2=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        dp2[1]=nums[1];
        dp2[2]=Math.max(nums[1],nums[2]);
        for(int i=2;i<n-1;i++) dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        for(int i=3;i<n;i++) dp2[i]=Math.max(dp2[i-1],dp2[i-2]+nums[i]);
        return Math.max(dp[n-2],dp2[n-1]);
    }

}
