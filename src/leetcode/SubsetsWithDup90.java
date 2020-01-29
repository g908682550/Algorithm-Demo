package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup90 {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> solution(int[] nums){
        Arrays.sort(nums);//对数组进行排序
        int n=nums.length;
        for(int i=0;i<=n;i++)
            helper(nums,new ArrayList<>(),0,i);
        return result;
    }

    public void helper(int[] nums,List<Integer> list,int count,int length){
        if(list.size()==length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=count;i<(nums.length-(length-list.size())+1);i++){
            list.add(nums[i]);
            helper(nums,list,i+1,length);
            list.remove(list.size()-1);
            while(i+1<(nums.length-(length-list.size())+1)&&nums[i+1]==nums[i]) i++;//下一个元素与当前元素相等直接略过
        }
    }
}
