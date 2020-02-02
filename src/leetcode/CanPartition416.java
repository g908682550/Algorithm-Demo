package leetcode;

public class CanPartition416 {

    public boolean solution(int[] nums){
        int sum=0,n=nums.length;
        for(int i:nums) sum+=i;
        if(sum%2==1) return false;
        int target=sum/2;
        boolean[] dp=new boolean[target+1];
        if(nums[0]<=target) dp[nums[0]]=true;
        for(int i=1;i<n;i++){
            for(int j=target;j-nums[i]>=0;j--)
                dp[j]=dp[j]||dp[j-nums[i]];
        }
        return dp[target];
    }

}
