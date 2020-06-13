package leetcode;

import org.junit.Test;

public class MaxProduct152 {

    @Test
    public void test(){
        int[] nums={-1,-2,-9,-6};
        solution1(nums);
    }

    public int solution1(int[] nums){
        int max=1,min=1,result=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(max*num,Math.max(num,min*num));
            min=Math.min(min*num,Math.min(num,max*num));
            result=Math.max(result,max);
        }
        return result;
    }

    /**
     * 记录当前最小值和最大值，如果nums[i]为负数将两者交换继续dp
     * @param nums
     * @return
     */
    public int solution(int[] nums){
        int max=Integer.MIN_VALUE,mint=1,maxt=1,n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]<0){
                int temp=mint;
                mint=maxt;
                maxt=temp;
            }
            mint=Math.min(nums[i],mint*nums[i]);
            maxt=Math.max(nums[i],maxt*nums[i]);
            max=Math.max(max,maxt);
        }
        return max;
    }

}
