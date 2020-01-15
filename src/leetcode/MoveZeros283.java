package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveZeros283 {

    @Test
    public void test(){
        int[] nums={0,1,0,3,2};
        solution1(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 暴力法
     * @param nums
     */
    public void solution1(int[] nums){
        List<Integer> list=new ArrayList<>();
        for(int i:nums)
            if(i!=0) list.add(i);
        for(int i=0;i<list.size();i++)
            nums[i]=list.get(i);
        for(int i=list.size();i<nums.length;i++) nums[i]=0;
    }

    /**
     * 双指针遍历法，将非0元素逐一赋值至前面，随后将后面元素置为0
     * @param nums
     */
    public void solution2(int[] nums){
        int i=0,j=0,n=nums.length;
        while(j<n){
            if(nums[j]!=0) nums[i++]=nums[j];
            j++;
        }
        while(i<n) nums[i++]=0;
    }

    /**
     * 双指针修正，即通过交换操作来使后续元素置为0
     * @param nums
     */
    public void solution3(int[] nums){
        int i=0,j=0,n=nums.length;
        while(j<n){
            if(nums[j]!=0) {
                int temp=nums[j];
                nums[j]=0;
                nums[i++]=temp;
            }
            j++;
        }
    }

    /**
     * 双指针继续优化，如果两指针相等时不需要进行交换操作
     * @param nums
     */
    public void solution4(int[] nums){
        int i=0,j=0,n=nums.length;
        while(j<n){
            if(nums[j]!=0) {
                if(j!=i){
                    int temp=nums[j];
                    nums[j]=0;
                    nums[i++]=temp;
                }else i++;
            }
            j++;
        }
    }
}



