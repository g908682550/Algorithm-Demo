package leetcode;

import org.junit.Test;

public class MinSubArrayLen209 {

    @Test
    public void test(){
        int[] nums={2,3,1,2,4,3};
        System.out.println(solution2(7, nums));

    }

    /**
     * 暴力解决
     * @param s
     * @param nums
     * @return
     */
    public int solution1(int s, int[] nums){
        int result=nums.length+1,n=nums.length,sum=0;
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum>=s) {
                    result=Math.min(j-i+1,result);
                    break;
                }
            }
        }
        if(result==n+1) return 0;
        return result;
    }

    /**
     * 双指针遍历法
     * @param s
     * @param nums
     * @return
     */
    public int solution2(int s,int[] nums){
        int n=nums.length;
        int i=0,j=0,sum=0,result=n+1;
        while(j<n){
            sum=sum+nums[j];
            while(sum>=s&&i<=j){
                result=Math.min(result,j-i+1);
                sum=sum-nums[i++];
            }
            j++;
        }
        if(result==n+1) return 0;
        return result;
    }

}
