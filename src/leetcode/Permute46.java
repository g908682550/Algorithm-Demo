package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Permute46 {

    @Test
    public void test(){
        int[] nums={1,2,3};
        solution2(nums);
    }

    List<List<Integer>> result=new ArrayList<>();

    /**
     * 利用交换特性进行递归和回溯
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums){
        int n=nums.length;
        if(n==0) return result;
        List<Integer> list=new ArrayList<>();
        for(int i:nums) list.add(i);
        helper(list,0);
        return result;
    }

    public void helper(List<Integer> list,int count){
        if(count==list.size()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=count;i<list.size();i++){
            Collections.swap(list,i,count);
            helper(list,count+1);
            Collections.swap(list,i,count);
        }
    }

    /**
     * 递归及回溯（添加和删除）
     * @param nums
     * @return
     */
    public List<List<Integer>> solution2(int[] nums){
        int n=nums.length;
        if(n==0) return result;
        boolean[] used=new boolean[n];
        helper(nums,0,new ArrayList<>(),used);
        return result;
    }

    /**
     * @param nums 原始数组
     * @param index 当前操作的层数
     * @param curr 当前操作的数组
     * @param used 标记数组当前位置是否被使用过
     */
    public void helper(int[] nums,int index,List<Integer> curr,boolean[] used){
        if(index==nums.length){
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                curr.add(nums[i]);
                used[i]=true;
                helper(nums,index+1,curr,used);
                curr.remove(curr.size()-1);
                used[i]=false;
            }
        }
    }

}
