package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class ThreeSumClosest16 {

    @Test
    public void test(){
        int[] nums={1,2,5,10,11};
        solution1(nums,12);
    }

    /**
     * 确定出两个值，然后再二分查找找最接近的那个值，如果总和最接近则最佳
     * @param nums
     * @param target
     * @return
     */
    public int solution1(int[] nums, int target){
        Arrays.sort(nums);
        int n=nums.length,result=nums[0]+nums[1]+nums[2];
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int other=target-nums[i]-nums[j],left=j+1,right=n-1;
                while(left<right){
                    int mid=(left+right+1)>>>1;
                    if(nums[mid]>other) right=mid-1;
                    else left=mid;
                }
                if(left+1<n&&nums[left+1]-other<other-nums[left]) left=left+1;
                int temp=nums[left]+nums[i]+nums[j];
                if(Math.abs(temp-target)<Math.abs(result-target)) result=temp;
            }
        }
        return result;
    }

    /**
     * 确定出一个值，然后双指针查找
     * @param nums
     * @param target
     * @return
     */
    public int solution2(int[] nums,int target){
        Arrays.sort(nums);
        int n=nums.length,result=nums[0]+nums[1]+nums[2],flag=Math.abs(result-target);
        for(int i=0;i<n-2;i++){
            int left=i+1,right=n-1;
            while(left<right){
                int sum=nums[left]+nums[right]+nums[i];
                if(Math.abs(sum-target)<flag){
                    result=sum;
                    flag=Math.abs(sum-target);
                }
                if(sum<target) left++;
                else right--;
            }
        }
        return result;
    }

}
