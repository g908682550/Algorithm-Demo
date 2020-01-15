package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicates26 {

    @Test
    public void test(){
        int[] nums={1,1,2};
        solution1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int solution1(int[] nums){
        if(nums.length==0) return 0;
        int i=0,j=1;
        while(j<nums.length){
            if(nums[j]!=nums[i]) {
                i++;
                nums[i]=nums[j];
            }
            j++;
        }
        return i+1;
    }
}
