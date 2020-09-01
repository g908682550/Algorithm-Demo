package leetcode;

import org.junit.Test;

public class Rotate189 {

    @Test
    public void test(){
        int[] nums={1,2,3,4,5,6,7};
        solution(nums,3);
    }

    public void solution(int[] nums,int k){
        int next,count=0,n=nums.length,index=0,pre=0;
        for(int start=0;count<n;start++) {
            pre = nums[start];
            index = (start + k) % n;
            do {
                next = nums[index];
                nums[index] = pre;
                pre = next;
                index = (index + k) % n;
                count++;
            } while (index != start);
        }
    }

}
