package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates442 {

    /**
     * 将访问过的元素置为负数，如果第二次访问到加到结果集中
     * @param nums
     * @return
     */
    public List<Integer> solution(int[] nums){
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            if(nums[index]<0) result.add(index+1);
            else nums[index]=-nums[index];
        }
        return result;
    }

}
