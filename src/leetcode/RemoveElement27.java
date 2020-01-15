package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class RemoveElement27 {

    @Test
    public void test(){
        int[] nums={3,2,2,3};
        solution1(nums,3);
        System.out.println(Arrays.toString(nums));
    }

    public int solution1(int[] nums, int val){
        if(nums.length==0) return 0;
        int j=0;
        for(int i=0;i<nums.length;i++)
            if(nums[i]!=val) nums[j++]=nums[i];
        return j;
    }
}
