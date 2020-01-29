package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum240 {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> solution(int[] candidates, int target){
        if(candidates.length==0) return result;
        Arrays.sort(candidates);
        helper(candidates,new ArrayList<Integer>(),target,0);
        return result;
    }

    public void helper(int[] nums,List<Integer> list,int num,int count){
        if(num==0){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=count;i<nums.length;i++){
            if(num-nums[i]<0) continue;
            list.add(nums[i]);
            helper(nums,list,num-nums[i],i+1);//当前下标元素不能重复使用，传入i+1
            list.remove(list.size()-1);
            while(i<nums.length-1&&nums[i+1]==nums[i]) i++;//下一个元素与当前元素相等不用判断
        }
    }

}
