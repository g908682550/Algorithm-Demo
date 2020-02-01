package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LengthOfLIS300 {

    @Test
    public void test(){
        int[] nums={10,9,2,5,3,7,101,18};
        solution2(nums);
    }


    public int solution1(int[] nums){
        int n=nums.length,result=1;
        if(n==0) return 0;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int max=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i])
                    max=Math.max(max,dp[j]+1);
            }
            dp[i]=max;
            result=Math.max(result,max);
        }
        return result;
    }

    public int solution2(int[] nums){
        int n=nums.length,result=1;
        if(n==0) return 0;
        List<Integer> list=new ArrayList<>();
        list.add(nums[0]);
        for(int i=1;i<n;i++){
            int target=nums[i];
            int left=0,right=list.size()-1;
            /**
             * 找到第一个大于它的数
             */
            while(left<right){
                int mid=(left+right)>>>1;
                if(list.get(mid)<target) left=mid+1;
                else right=mid;
            }
            //若找到的是最后一个索引，则判断当前值是否大于其最后值，若大于则将其添加到后面，否则对其进行覆盖
            if(left==list.size()-1&&target>list.get(left)) list.add(target);
            else list.set(left,target);
        }
        return list.size();
    }


}
