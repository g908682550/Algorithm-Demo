package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {

    List<List<Integer>> result=new ArrayList<>();

    public List<List<Integer>> test(int[] candidates, int target){
        if(candidates.length==0) return result;
        helper(candidates,new ArrayList<Integer>(),target,0);
        return result;
    }

    /**
     *
     * @param nums 原始数组
     * @param list  当前list集合
     * @param num   还缺的数字
     * @param count 当前遍历的下标起始位置
     */
    public void helper(int[] nums,List<Integer> list,int num,int count){
        if(num==0){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=count;i<nums.length;i++){
            if(num-nums[i]<0) continue;
            list.add(nums[i]);
            helper(nums,list,num-nums[i],i);//允许元素重复，这里传入i即可
            list.remove(list.size()-1);
        }
    }

}
