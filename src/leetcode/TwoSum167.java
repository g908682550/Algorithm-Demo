package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class TwoSum167 {

    @Test
    public void test(){
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution2(nums, 9)));
    }

    /**
     * 双指针寻找，一个从前往后，一个从后往前
     * @param numbers
     * @param target
     */
    public int[] solution1(int[] numbers, int target){
        int i=0,j=numbers.length-1;
        while(i<j){
            if(numbers[i]+numbers[j]==target) return new int[]{i+1,j+1};
            else if(numbers[i]+numbers[j]>target) j--;
            else i++;
        }
        return new int[]{0,0};
    }

    /**
     * 二分查找法
     * @param numbers
     * @param target
     * @return
     */
    public int[] solution2(int[] numbers,int target){
        for(int i=0;i<numbers.length;i++){
            int l=0,r=numbers.length-1;
            int target1=target-numbers[i];
            while(l<r){
                int mid=(l+r)/2;
                if(numbers[mid]<target1) l=mid+1;
                else r=mid;
            }
            if(numbers[l]==target1&&l!=i)
            if(i<l) return new int[]{i+1,l+1};
            else return new int[]{l+1,i+1};
        }
        return new int[]{-1,-1};
    }
}
