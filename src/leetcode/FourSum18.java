package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum18 {

    @Test
    public void test(){
        int[] nums={1,0,-1,0,-2,2};
        solution1(nums,0);
    }

    /**
     * 选准两个基准点的双指针
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> solution1(int[] nums, int target){
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-3;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                int other=target-nums[i]-nums[j];
                int left=j+1,right=n-1;
                while(left<right){
                    if(nums[left]+nums[right]==other){
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        result.add(list);
                        while(left+1<right&&nums[left+1]==nums[left]) left++;
                        while(right-1>left&&nums[right-1]==nums[right]) right--;
                        left++;
                        right--;
                    }else if(nums[left]+nums[right]<other) left++;
                    else right--;
                }
            }
        }
        return result;
    }

}
