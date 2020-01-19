package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum1 {

    @Test
    public void test(){
        int[] nums={2,7,11,15};
        System.out.println(Arrays.toString(solution1(nums,9)));
    }

    public int[] solution1(int[] nums, int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int curr=nums[i];
            int other=target-curr;
            if(map.containsKey(other)) return new int[]{map.get(other),i};
            else map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

}
