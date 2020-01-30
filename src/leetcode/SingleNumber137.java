package leetcode;

import java.util.Arrays;

public class SingleNumber137 {

    public int solution(int[] nums){
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i+=3) if(nums[i]!=nums[i+1]) return nums[i];
        return nums[nums.length-1];
    }

}
