package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> solution(int[] nums){
        int n=nums.length;
        for(int i=0;i<=n;i++)//从0到n对数组进行组合，将子集加入结果集中
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
        }
    }

}
