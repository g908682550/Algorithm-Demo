package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class RemoveDuplicates80 {

    @Test
    public void test(){
        int[] nums={1,1,1,2,2,3};
        solution1(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int solution1(int[] nums){
        if(nums.length==0) return 0;
        int i=0,j=0,count=1,n=nums.length;
        while(j<n){
            if(count<3) nums[i++]=nums[j];
            j++;
            if(j<n&&nums[j]==nums[j-1]) count++;
            else count=1;
        }
        return i;
    }
}


