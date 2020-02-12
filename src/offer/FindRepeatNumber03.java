package offer;

import java.util.Arrays;

public class FindRepeatNumber03 {


    /**
     * 利用下标存储当前出现过的元素
     */
    public int solution1(int[] nums){
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=i){
                if(nums[i]==nums[nums[i]]) return nums[i];
                else swap(nums,i,nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    /**
     * 先排序后判断
     * @param nums
     * @return
     */
    public int solution2(int[] nums){
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]) return nums[i];
        }
        return -1;
    }

}
