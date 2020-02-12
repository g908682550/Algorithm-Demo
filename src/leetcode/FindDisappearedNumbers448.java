package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers448 {

    /**
     * 将出现过的元素的下标置为负数，第二遍访问若当前下标数字大于0，说明该下标+1的数字未出现过
     * @param nums
     * @return
     */
    public List<Integer> solution(int[] nums){
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i]);
            if(nums[index-1]<0) continue;
            else nums[index-1]=-nums[index-1];
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) result.add(i+1);
        }
        return result;
    }

}
