package leetcode;

public class NumberOfSubarrays1248 {

    public int solution(int[] nums,int k){
        int number=0,n=nums.length,res=0;
        int[] dp=new int[k+2];
        dp[0]=1;
        for(int num:nums){
            if(num%2==1) number++;
            if(number-k>=0) res+=dp[(number-k)%(k+2)];
            dp[(number+1)%(k+2)]=0;
            dp[number%(k+2)]++;
        }
        return res;
    }

}
