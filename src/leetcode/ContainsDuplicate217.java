package leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate217 {

    @Test
    public void test(){
        int[] nums={1,2,3,1};
        System.out.println(solution1(nums));
    }

    public boolean solution1(int[] nums){
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])) return true;
            else set.add(nums[i]);
        }
        return false;
    }
}
