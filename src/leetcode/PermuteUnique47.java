package leetcode;

import java.util.*;

public class PermuteUnique47 {

    Set<List<Integer>> set=new HashSet<>();

    /**
     * 基于全排列1，利用set进行去重
     * @param nums
     * @return
     */
    public List<List<Integer>> solution(int[] nums){
        int n=nums.length;
        if(n==0) return null;
        List<Integer> list=new ArrayList<>();
        for(int i:nums) list.add(i);
        List<List<Integer>> result=new ArrayList<>(set);
        helper(list,0);

        return result;
    }

    public void helper(List<Integer> list,int count){
        if(count==list.size()){
            set.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=count;i<list.size();i++){
            Collections.swap(list,i,count);
            helper(list,count+1);
            Collections.swap(list,i,count);
        }
    }

}
