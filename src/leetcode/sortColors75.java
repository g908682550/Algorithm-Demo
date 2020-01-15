package leetcode;

import org.junit.Test;

import java.util.Arrays;


public class sortColors75 {

    @Test
    public void test(){
        int[] nums={2,0,2,1,1,0};
        solution2(nums);
        System.out.println(Arrays.toString(nums));
    }


    /**
     * 基于计数排序的解决方案
     * @param nums
     */
    public void solution1(int[] nums){
        int[] bucket=new int[3];
        for(int i:nums){
            bucket[i]++;
        }
        int i=0;
        for(int j=0;j<bucket.length;j++){
            while(bucket[j]>0){
                nums[i++]=j;
                bucket[j]--;
            }
        }
    }

    /**
     * 基于三个指针的一次性遍历
     * @param nums
     */
    public void solution2(int[] nums){
        int p1=0,p2=nums.length-1,curr=0,n=nums.length;
        while(curr<=p2){
            if(nums[curr]==2) swap(nums,curr,p2--);
            else{
                if(nums[curr]==0) swap(nums,curr,p1++);
                curr++;
            }
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
