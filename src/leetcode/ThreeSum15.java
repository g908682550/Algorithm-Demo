package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {


    @Test
    public void test(){
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(solution1(nums));
    }

    /**
     * 双指针遍历，关键在于去重
     * @param nums
     * @return
     */
    public List<List<Integer>> solution1(int[] nums){
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);//对数组进行排序
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;//如果这个元素和上一个相等，则不再进行判断
            int target=-nums[i];
            int left=i+1,right=n-1;
            while(left<right){
                if(nums[left]+nums[right]==target){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while(left+1<right&&nums[left+1]==nums[left]) left++;//将左指针直接移动到该元素相同元素的最右端
                    while(right-1>left&&nums[right-1]==nums[right]) right--;//将右指针直接移动到该元素相同元素最左端
                    left++;
                    right--;
                }else if(nums[left]+nums[right]<target) left++;
                else right--;
            }
        }
        return result;
    }

}
