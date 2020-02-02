package leetcode;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class FindTargetSumWays494 {

     Map<Pair<Integer,Integer>,Integer> map=new HashMap<>();

    /**
     * 记忆化搜索，对当前索引下的当前值进行保存，防止重复计算
     * @param nums
     * @param S
     * @return
     */
    public int solution(int[] nums, int S){
        int n=nums.length;
        return count(nums,n-1,S);
    }

    public int count(int[] nums,int j,int target){
        Pair<Integer,Integer> pair=new Pair(target,j);
        if(map.containsKey(pair)) return map.get(pair);
        if(j==-1){
            if(target==0) return 1;
            else return 0;
        }
        int result=0;
        result=count(nums,j-1,target+nums[j])+count(nums,j-1,target-nums[j]);
        map.put(pair,result);
        return result;
    }

    /**
     * 0-1背包问题。求一个子集的和等与(S+sum)/2的个数，其中（S+sum）/2可理解为背包体积，子集数为数字大小
     * @param nums
     * @param S
     * @return
     */
    public int solution2(int[] nums,int S){
        int sum=0;
        for(int num:nums) sum+=num;
        if((S+sum)%2==1||S>sum) return 0;
        int sub=(S+sum)/2;
        int[] dp=new int[sub+1];
        dp[0]=1;
        for(int num:nums){
            for(int i=sub;i>=num;i--){
                dp[i]+=dp[i-num];
            }
        }
        return dp[sub];
    }



}
