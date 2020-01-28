package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PermuteUnique47 {

    List<List<Integer>> result=new ArrayList<>();

    /**
     * 基于全排列1，在添加结果进入result时进行一个判断
     * @param nums
     * @return
     */
    public List<List<Integer>> solution(int[] nums){
        int n=nums.length;
        if(n==0) return result;
        List<Integer> list=new ArrayList<>();
        for(int i:nums) list.add(i);
        helper(list,0);
        return result;
    }

    public void helper(List<Integer> list,int count){
        if(count==list.size()&&!result.contains(list)){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=count;i<list.size();i++){
            Collections.swap(list,i,count);
            helper(list,count+1);
            Collections.swap(list,i,count);
        }
    }

}
