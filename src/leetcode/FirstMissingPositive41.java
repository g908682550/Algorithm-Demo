package leetcode;

public class FirstMissingPositive41 {

    /**
     * 分别将对应元素放到其对应下标处，最后再对首元素做一个判断
     * @param nums
     * @return
     */
    public int solution(int[] nums){
        if(nums.length==0) return 1;
        for(int i=0;i<nums.length;i++){
            while(nums[i]>0&&nums[i]<nums.length&&nums[i]!=nums[nums[i]]){
                swap(nums,nums[i],i);
            }
        }
        for(int i=1;i<nums.length;i++)
            if(nums[i]!=i) return i;
        return nums[0]==nums.length?nums.length+1:nums.length;
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

}
