package leetcode;

public class MaxSubArray53 {

    public int solution(int[] nums){
        if(nums.length==1) return nums[0];
        int result=nums[0];
        int dp=result;
        for(int i=1;i<nums.length;i++){
            dp=Math.max(dp+nums[i],nums[i]);
            if(dp>result) result=dp;
        }
        return result;
    }

}
