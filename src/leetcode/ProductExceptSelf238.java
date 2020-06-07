package leetcode;

import java.util.Arrays;

public class ProductExceptSelf238 {

    /**
     * 遍历两遍
     * @param nums
     * @return
     */
    public int[] solution(int[] nums){
        int n=nums.length;
        int[] result=new int[n];
        Arrays.fill(result,1);
        for(int i=1;i<n;i++){
            result[i]=result[i-1]*nums[i-1];
        }
        int temp=nums[n-1];
        for(int i=n-2;i>=0;i--){
            result[i]*=temp;
            temp=temp*nums[i];
        }
        return result;
    }

}
